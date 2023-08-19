package uk.co.heartbingo.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import uk.co.heartbingo.customlisteners.CustomListeners;
import uk.co.heartbingo.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.Duration;


public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(id = "onetrust-accept-btn-handler")
//   //button[@id='onetrust-accept-btn-handler']
    WebElement acceptCookies;

    @CacheLookup
    @FindBy (xpath = "//a[contains(text(),'Log In')]")
    WebElement btnLoginButton;

    @CacheLookup
    @FindBy(className ="bvs-site-logo")
    WebElement logo;



    public void clickOnAcceptCookies(){
        log.info("Accepting the Cookies on the page");
        CustomListeners.test.log(Status.PASS,"Accepting the Cookies");
        clickOnElement(acceptCookies);
    }
    public void verifyThatLoginButtonIsVisible(){
        verifyThatElementIsDisplayed(btnLoginButton);
        log.info("Login button is visible");
        CustomListeners.test.log(Status.PASS,"Verify login button is visible on Homepage ");
    }

    public String verifyLogo(){
        log.info("Verifying the Logo on Homepage");
        CustomListeners.test.log(Status.PASS,"Verify Logo on Homepage ");

        return getTextFromElement(logo);


    }

}
