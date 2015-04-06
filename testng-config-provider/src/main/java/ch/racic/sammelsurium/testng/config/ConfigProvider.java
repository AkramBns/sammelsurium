/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.config;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by rac on 05.04.15.
 */
public class ConfigProvider {

    private static final Logger log = LogManager.getLogger(ConfigProvider.class);

    private ConfigEnvironment environment;
    private Class clazz;

    private static final String CONFIG_BASE_FOLDER = "config";
    private static final String CONFIG_GLOBAL_BASE_FOLDER = "global";
    private static final String CONFIG_CLASS_FOLDER = "class";

    private Properties props;

    private FilenameFilter propertiesFilter = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            if (name.endsWith(".properties")) return true;
            else return false;
        }
    };

    public ConfigProvider(ConfigEnvironment environment, Class clazz) {
        this.environment = environment;
        this.clazz = clazz;
        loadProperties();
    }

    private void loadProperties() {
        props = new Properties();

        // check that base config directory exists to be used as a base for all following actions
        File configBaseFolder = FileUtils.toFile(getClass().getClassLoader().getResource(CONFIG_BASE_FOLDER));
        if (!(configBaseFolder != null && configBaseFolder.exists() && configBaseFolder.isDirectory())) {
            log.error("Configuration initialisation error", new IOException("Config folder not existing or not a directory"));
        }

        // Load global base properties
        File configGlobalBaseFolder = new File(configBaseFolder, CONFIG_GLOBAL_BASE_FOLDER);
        if (configGlobalBaseFolder.exists() && configGlobalBaseFolder.isDirectory()) {
            // Get list of files in global folder and load it into props
            for (File f : configGlobalBaseFolder.listFiles(propertiesFilter)) {
                log.debug("Loading properties from " + f.getPath());
                try {
                    props.load(new FileReader(f));
                } catch (IOException e) {
                    log.error("Configuration initialisation error", e);
                }
            }
        } else {
            log.warn("global folder not existing, can't load default values");
        }

        // Load environment base properties
        File configEnvironmentBaseFolder = null;
        if (environment != null) {
            configEnvironmentBaseFolder = new File(configBaseFolder, environment.getCode());
            if (!(configEnvironmentBaseFolder.exists() && configEnvironmentBaseFolder.isDirectory())) {
                log.error("Configuration initialisation error", new IOException("Environment specific configuration folder does not exist for " + environment));
            }
            // Get list of files in environment folder and load it into props, overriding existing global properties
            for (File f : configEnvironmentBaseFolder.listFiles(propertiesFilter)) {
                log.debug("Loading properties from " + f.getPath());
                try {
                    props.load(new FileReader(f));
                } catch (IOException e) {
                    log.error("Configuration initialisation error", e);
                }
            }
        }

        // Load global class properties
        if (configGlobalBaseFolder.exists() && configGlobalBaseFolder.isDirectory() && clazz != null) {
            // Check if a class file exists
            File classProps = new File(configGlobalBaseFolder, CONFIG_CLASS_FOLDER + "/" + clazz.getSimpleName() + ".properties");
            if (classProps.exists() && classProps.isFile()) {
                // It exists, load it into props
                log.debug("Loading properties from " + classProps.getPath());
                try {
                    props.load(new FileReader(classProps));
                } catch (IOException e) {
                    log.error("Configuration initialisation error", e);
                }
            }
        }

        // Load environment class properties
        if (configEnvironmentBaseFolder != null && clazz != null) {
            // Check if a class file exists
            File classProps = new File(configEnvironmentBaseFolder, CONFIG_CLASS_FOLDER + "/" + clazz.getSimpleName() + ".properties");
            if (classProps.exists() && classProps.isFile()) {
                // It exists, load it into props
                log.debug("Loading properties from " + classProps.getPath());
                try {
                    props.load(new FileReader(classProps));
                } catch (IOException e) {
                    log.error("Configuration initialisation error", e);
                }
            }
        }

    }

    public ConfigEnvironment getEnvironment() {
        return environment;
    }

    public Class getClazz() {
        return clazz;
    }

    public String get(String key) {
        return get(key, null);
    }

    public String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public void logAvailableProperties() {
        log.info("CM Properties available" + ((environment != null) ? " for environment " + environment : ""));
        for (String key : props.stringPropertyNames())
            log.info("\tKey[" + key + "], Value[" + props.get(key) + "]");
    }
}
