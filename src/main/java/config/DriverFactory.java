package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.opentelemetry.semconv.SemanticAttributes.NetHostConnectionSubtypeValues.EDGE;

public class DriverFactory {
    public static WebDriver driver;
    public static WebDriver initializeWebDriver(){
        String browser =ConfigManager.getProperty("browser").toUpperCase();
        switch (browser) {
            case CHROME:
               // WebDriverManager.chromedriver().setup();
             driver=new ChromeDriver();
             break;

            case EDGE:
               driver=new EdgeDriver();
               break;
            case FIREFOX:
                driver= new FirefoxDriver();
            default:
                System.out.println("invalid input");


        }
        return driver;

    }



}
