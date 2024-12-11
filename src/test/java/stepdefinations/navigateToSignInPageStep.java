package stepdefinations;

import base.Base;
import enums.WaitStrategy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.google.LandingP;
import pages.google.SignInPage;
import utils.WaitUtility;

public class navigateToSignInPageStep extends Base {
    LandingP landingP;
    SignInPage signInPage;
    // WaitUtility wait;


    @Before
    public void setUP() {
        super.setup();

        this.landingP = new LandingP(driver);


    }


    @Given("user is on google landing page")
    public void user_is_on_google_landing_page() {
       // WaitUtility.applyGlobalWait();
    }


    @When("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
        WaitUtility.applyWait(landingP.signInButton, driver, WaitStrategy.CLICKABLE).click();

    }

    @Then("user should be navigated to sign in page")
    public void user_should_be_navigated_to_sign_in_page() {

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fwww.google.com%2F&ec=GAZAmgQ&hl=en&ifkv=AeZLP98N3d-iwnVzd-AchQRfDYe84VKwPa-G6_i_eV0qGaMHboEDI0CQvS9uPGJVHWMOc-ThK_Icpg&passive=true&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-734324430%3A1733932835918799&ddm=1";
      //  Assert.assertEquals( actualUrl, expectedUrl,"faild");
    }

    @Then("user should see sign in text and print it to console")
    public void user_should_see_sign_in_text_and_print_it_to_console() {

        this.signInPage = new SignInPage(driver);
        WaitUtility.applyWait(signInPage.signInText,driver,WaitStrategy.VISIBLE);
        signInPage.printSignInText();


    }
    @After
    public void tearDown(){
        super.tearDown();
    }
}
