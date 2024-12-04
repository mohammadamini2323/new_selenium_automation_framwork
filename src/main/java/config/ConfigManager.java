package config;

import enums.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;




public class ConfigManager {
   public static final Properties properties=new Properties();
   public static final Logger logger= LogManager.getLogger(ConfigManager.class);
   static {
       loadProperties();
   }

   private static void loadProperties(){
       try {
           FileInputStream baseConfig=new FileInputStream("src/main/resources/config/config.properties");
           properties.load(baseConfig);
           baseConfig.close();
           Environment env=Environment.valueOf(properties.getProperty("env").toUpperCase());
           FileInputStream envConfig=new FileInputStream("src/main/resources/config/"+env.name().toLowerCase()+"_config.properties");
           properties.load(envConfig);
           envConfig.close();
           logger.info("Configuration loaded for environment " + env);

       } catch (IOException e) {
           logger.error("Failed to load configuration. " + e);
           throw new RuntimeException("Configuration loading failed"+e);
       }

   }
   public static String getProperty(String key){
       return properties.getProperty(key);
   }
   public static String getProperty(String Key,String defaultValue){
       return properties.getProperty(Key,defaultValue);
   }
   public static Environment getEnvironment() {
       return Environment.valueOf(properties.getProperty("env").toUpperCase());
   }
}
