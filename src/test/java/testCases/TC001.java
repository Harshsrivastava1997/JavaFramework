package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePageBase;
import pageObjects.RegistrationPageBase;
import testBase.TestBase;

import java.time.Duration;

public class TC001 extends TestBase {


    @Test(priority = 1, groups = {"Master", "Sanity", "Regression"})

    public void homePageTestMethod() {
        try {

            logger.info("Test Case Started");


            HomePageBase hb = new HomePageBase(driver);
            hb.setAccount();
            hb.setRegister();
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }

    @Test(priority = 2, groups = {"Master", "Sanity", "Regression"})
    public void registerPageTestMethod() {

        logger.info("Registration Page testcase started");
        try {

            RegistrationPageBase rb = new RegistrationPageBase(driver);
            rb.firstname(randomString().toUpperCase());
            rb.lastname(randomString().toUpperCase());
            rb.emailID(randomAplhaNumeric() + "@hotmail.com");
            rb.telephone(randomNumber());
            rb.passwd("tester");
            rb.cnfpasswd("tester");
            rb.privacy_policy();
            rb.Button();
            logger.info("Matching title of the page");
            Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!", "Title mismatch on Register page!");
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}





