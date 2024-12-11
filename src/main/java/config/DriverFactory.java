package config;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static io.opentelemetry.semconv.SemanticAttributes.NetHostConnectionSubtypeValues.EDGE;

public class DriverFactory {
    public final static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public static WebDriver getDriver(){
        if (driver.get()==null){
            initializeWebDriver();
        }
        return driver.get();
    }
   private static void initializeWebDriver(){
        Browser browser=Browser.valueOf(ConfigManager.getProperty("browser").toUpperCase());
        boolean isHeadless=Boolean.parseBoolean(ConfigManager.getProperty("isHeadless"));
        WebDriver webDriver;
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions();
                if (isHeadless){
                chromeOptions.addArguments("--headless");}
              webDriver=new ChromeDriver(chromeOptions);
             break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions=new EdgeOptions();
                if (isHeadless){
                    edgeOptions.addArguments("--headless");}
               webDriver=new EdgeDriver(edgeOptions);
               break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                if (isHeadless){
                    firefoxOptions.addArguments("--headless");}
                webDriver= new FirefoxDriver(firefoxOptions);
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();

                webDriver= new SafariDriver();
            default:
                throw new IllegalArgumentException("invalid browser name");

        }
        webDriver.manage().window().maximize();
        driver.set(webDriver);

    }
    public static void quitDriver(){
        if (driver.get() != null ){
        driver.get().quit();
        driver.remove();}
    }



}
