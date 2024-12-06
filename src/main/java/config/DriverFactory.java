package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.opentelemetry.semconv.SemanticAttributes.NetHostConnectionSubtypeValues.EDGE;

public class DriverFactory {
    public static WebDriver driver;
    public static WebDriver initializeWebDriver(){
        String browser =ConfigManager.getProperty("browser").toUpperCase();
        boolean isHeadless=Boolean.parseBoolean(ConfigManager.getProperty("isHeadless"));
        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions=new ChromeOptions();
                if (isHeadless){
                chromeOptions.addArguments("--headless");}
             driver=new ChromeDriver(chromeOptions);
             break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions=new EdgeOptions();
                if (isHeadless){
                    edgeOptions.addArguments("--headless");}
               driver=new EdgeDriver(edgeOptions);
               break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                if (isHeadless){
                    firefoxOptions.addArguments("--headless");}
                driver= new FirefoxDriver(firefoxOptions);
            default:
                System.out.println("invalid input");


        }
        driver.manage().window().maximize();

        return driver;

    }
    public static void quitDriver(){
        driver.quit();
    }



}
