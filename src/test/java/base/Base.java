package base;

import config.ConfigManager;
import config.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    protected WebDriver driver;
    Logger logger= LogManager.getLogger(Base.class);
@BeforeMethod
    public void setup(){
        driver= DriverFactory.getDriver();
        driver.get(ConfigManager.getProperty("baseUrl"));
        logger.info("started test with URL{ "+ConfigManager.getProperty("baseUrl")+" }");
    }



    @AfterMethod
    public void tearDown(){
    DriverFactory.quitDriver();
    }

}
