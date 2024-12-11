package tests.browser;

import base.Base;
import org.testng.annotations.Test;
import pages.google.LandingP;

public class GoogleTest extends Base {
    @Test
    public void navigate_to_about_page() throws InterruptedException {
        LandingP landingPage=new LandingP(driver);
        Thread.sleep(5000);
        landingPage.clickOnAboutButton();
        Thread.sleep(3000);



    }

}
