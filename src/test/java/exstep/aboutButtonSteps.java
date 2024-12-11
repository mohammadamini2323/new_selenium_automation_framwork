package exstep;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.google.LandingP;

public class aboutButtonSteps extends Base {
   LandingP landingPage;



    @Before
    public void setUp(){
        super.setup();
        this.landingPage=new LandingP(driver);


    }
    @Given("user is on google")
    public void user_is_on_google_page() throws InterruptedException {
       // Thread.sleep(10000);

    }
    @When("user clicks on about button")
public void click_on_about_button(){
        landingPage.clickOnAboutButton();

    }
    @Then("user shuold be navigated to about page")
    public void user_should_be_on_about_page() {

    }

@After
    public void tearDown(){
        super.tearDown();
}



}
