/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.config.guice;

import ch.racic.sammelsurium.testng.config.ConfigEnvironment;
import ch.racic.sammelsurium.testng.config.ConfigProvider;
import com.google.inject.AbstractModule;
import org.testng.ITestContext;
import org.testng.xml.XmlTest;

/**
 * Created by rac on 06.04.15.
 */
public class ConfigModule extends AbstractModule {

    private ConfigEnvironment env;
    private Class testClass;

    public static final String ENVIRONMENT_NAME = "environment.name";
    public static final String ENVIRONMENT_DESCRIPTION = "environment.description";
    public static final String ENVIRONMENT_CODE = "environment.code";

    public ConfigModule(ITestContext context, Class<?> testClass) {
        XmlTest test = context.getCurrentXmlTest();
        String envName = test.getParameter(ENVIRONMENT_NAME);
        String envDesc = test.getParameter(ENVIRONMENT_DESCRIPTION);
        String envCode = test.getParameter(ENVIRONMENT_CODE);

        if (envCode != null) {
            env = new ConfigEnvironment(envName, envDesc, envCode);
        }

        this.testClass = testClass;
    }

    @Override
    protected void configure() {
        bind(ConfigProvider.class).toProvider(new ConfigModuleProvider(env, testClass));
    }
}
