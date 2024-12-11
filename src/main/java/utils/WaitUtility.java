package utils;

import config.ConfigManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    public static Duration getTimeout(){
        String timeoutValue= ConfigManager.getProperty("timeout");
        int timeoutInSecond=(timeoutValue !=null) ? Integer.parseInt(timeoutValue):10;
        return Duration.ofSeconds(timeoutInSecond);
    }
    public static void applyGlobalWait(){
        boolean isEnable=Boolean.parseBoolean(ConfigManager.getProperty("enableWait"));
        int timeoutInSecond=Integer.parseInt(ConfigManager.getProperty("waitInSeconds"));
        if (isEnable&&(timeoutInSecond>0)){
            try {
                Thread.sleep(timeoutInSecond*1000L);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("GLOBAL Wait INTERUPTED"+e.getMessage());
            }

        }

    }
    public static WebElement applyWait(WebElement webElement, WebDriver driver, WaitStrategy waitStrategy){
        WebDriverWait wait=new WebDriverWait(driver,getTimeout());
        switch (waitStrategy) {
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOf(webElement));
            case NONE:
            default:
                return webElement;
        }



    }
    public static WebElement applyWait(WebElement webElement, WebDriver driver, WaitStrategy waitStrategy, By element){
        WebDriverWait wait=new WebDriverWait(driver,getTimeout());
        switch (waitStrategy) {
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOf(webElement));
            case PRESENCE:
                wait.until(ExpectedConditions.presenceOfElementLocated(element));
            case NONE:
            default:
                return webElement;
        }



    }

}
