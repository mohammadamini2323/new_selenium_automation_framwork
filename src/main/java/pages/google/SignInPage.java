package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
   public final WebElement signInText;
    public final WebDriver driver;
    public SignInPage(WebDriver driver){
        this.driver=driver;

        this.signInText= driver.findElement(By.xpath("//span[text()='Sign in']"));
    }

    public void printSignInText(){
        System.out.println(signInText.getText());
    }

}
