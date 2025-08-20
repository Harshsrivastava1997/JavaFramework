package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.EditAccountsBase;
import pageObjects.HomePageBase;
import pageObjects.MainEditAccountBase;
import pageObjects.RegistrationPageBase;
import testBase.TestBase;

import static org.testng.TestRunner.PriorityWeight.priority;

public class TC001 extends TestBase {


    @Test(priority = 1,groups={"Master","Sanity","Regression"})

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

    @Test(priority = 2,groups={"Master","Sanity","Regression"})
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

    @Test(priority = 3,groups={"Master","Sanity","Regression"})
    public void redirectionToEditAccount() {

        logger.info("Redirecting to EditAccount Page");
        try {
            EditAccountsBase eab = new EditAccountsBase(driver);
            eab.setEditAccount();
        } catch (Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }

    @Test(priority = 4,groups={"Master","Sanity","Regression"})
    public void editAccounts() {

        logger.info("Editing the information");
        try {
            MainEditAccountBase mb = new MainEditAccountBase(driver);
            mb.setEditfname("Harry");
            mb.setEditlname("bose");
            mb.setEditemail("mummy@google.com"); // keep changing this email to get proper results
            mb.setEdittelephone("123456789");
            mb.setEditContinue();

        } catch (
                Exception e) {
            logger.error("Test Failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }

    //Again calling editaccount code to check updation happened or not
    @Test(priority = 5,groups={"Master","Sanity","Regression"})
    public void RedirectionToEditAccount() {

        logger.info("Checking Edit operation was success or not");
        try {
            EditAccountsBase eab = new EditAccountsBase(driver);
            eab.setEditAccount();

            String Actual_email = driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("value");
              if(Actual_email.equals( "mummy@google.com"))
              {
                  Assert.assertTrue(true);
              }
              else{
                  Assert.assertTrue(false);
                  logger.debug("Debug logs");
                  logger.error("Test Failed");

              }
        } catch (Exception e) {

            Assert.fail();
        }
        logger.info("*******Test case is Finished********");
    }
}



