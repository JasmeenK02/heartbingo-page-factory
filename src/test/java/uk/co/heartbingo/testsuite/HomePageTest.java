package uk.co.heartbingo.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import uk.co.heartbingo.customlisteners.CustomListeners;
import uk.co.heartbingo.pages.HomePage;
import uk.co.heartbingo.testbase.BaseTest;

@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {

    HomePage homePage;
    SoftAssert softAssert;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        softAssert = new SoftAssert();
    }

    @Test
    public void verifyUserShouldNavigateToHomePageSuccessfully(){
        homePage.clickOnAcceptCookies();
        homePage.verifyThatLoginButtonIsVisible();
        String expectedMessage = "HeartBingo";
        softAssert.assertEquals(homePage.verifyLogo(),"HeartBingo", "Unable to verify logo");

    }
}