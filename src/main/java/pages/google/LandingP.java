package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class LandingP {
   public final   WebDriver driver;
  public final    WebElement aboutButton;
  public final By byGmailButtonXpath;
    WebElement storeButton;
    public final WebElement signInButton;

    public LandingP(WebDriver driver) {
        this.driver = driver;
        this.aboutButton=driver.findElement(By.xpath("//a[text()='About']"));
        this.storeButton=driver.findElement(By.xpath("//a[text()='Store']"));
        this.byGmailButtonXpath= By.xpath("//a[text()='Gmail']");
        this.signInButton=driver.findElement(By.xpath("//a[@aria-label='Sign in']"));

    }
    public void clickOnAboutButton() {

        aboutButton.click();
    }
    public void clickOnStoreButton(){
        storeButton.click();

    }
    public void clickOnGmailButton(){
        driver.findElement(byGmailButtonXpath).click();
    }
}
