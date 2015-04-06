/*
 * Copyleft (c) 2015. This code is for learning purposes only.
 * Do whatever you like with it but don't take it as perfect code.
 * //Michel Racic (http://rac.su/+)//
 */

package ch.racic.sammelsurium.testng.config;

/**
 * Created by rac on 05.04.15.
 */
public class ConfigEnvironment {
    private String name;
    private String description;
    private String code;

    public ConfigEnvironment() {
    }

    public ConfigEnvironment(String name, String description, String code) {
        this.name = name;
        this.description = description;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public ConfigEnvironment setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ConfigEnvironment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ConfigEnvironment setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "ConfigEnvironment{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
