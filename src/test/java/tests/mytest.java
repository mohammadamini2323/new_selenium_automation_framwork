package tests;

import config.ConfigManager;


public class mytest {
    public static void main(String[] args) {

       System.out.println(ConfigManager.properties.getProperty("env"));
        System.out.println(ConfigManager.getEnvironment());
        System.out.println(ConfigManager.getProperty("browser"));
        System.out.println(ConfigManager.getProperty("isHeadless"));
        System.out.println(ConfigManager.getProperty("enableWait"));
        System.out.println(ConfigManager.getProperty("waitInSeconds"));
        System.out.println(ConfigManager.getProperty("testRunner"));
        System.out.println(ConfigManager.getProperty("baseUrl"));
        System.out.println(ConfigManager.getProperty("timeout"));
        System.out.println(ConfigManager.getProperty("isHealess","this  one is wrong"));


    }
}
