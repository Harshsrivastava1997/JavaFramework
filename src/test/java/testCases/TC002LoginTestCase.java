package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AfterLoginPageBase;
import pageObjects.HomePageBase;
import pageObjects.LoginPageBase;
import testBase.TestBase;

public class TC002LoginTestCase  extends TestBase {

    @Test(groups="Master")
    public void LoginPage() {
        logger.info("***************Test case Started************");
        try {

            HomePageBase hp = new HomePageBase(driver); //these methods are called to do action on main page
            hp.setAccount();
            hp.setLogin();

            //Now login page methods will be called
            LoginPageBase lp = new LoginPageBase(driver);
            lp.setEmail_id(p.getProperty("email2")); //Reading data from config.properties
            lp.setPassword(p.getProperty("password2"));
            lp.setLogin_button();

            //Now titlecheck method will be called from AfterLoginpage

            AfterLoginPageBase alb = new AfterLoginPageBase(driver);
            boolean ismypage_exist = alb.titlecheck();
            Assert.assertEquals(ismypage_exist, true, "Login Failed");
        }
        catch (Exception e) {
            Assert.fail();
        }
        logger.info("************TestCase Ends*********************");
    }
}


