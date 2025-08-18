package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AfterLoginPageBase;
import pageObjects.HomePageBase;
import pageObjects.LoginPageBase;
import testBase.TestBase;
import utilities.DataProviders;

public class TC003Login_DDT  extends TestBase {

    @Test(dataProvider="LoginData",dataProviderClass = DataProviders.class,groups="Data driven")
    public void verifylogin(String email, String pwd, String exp_result)
    {
        logger.info("**********Starting TC003_Login_DDT****************");

        try {
             HomePageBase hp = new HomePageBase(driver); //these methods are called to do action on main page
             hp.setAccount();
             hp.setLogin();

             //Now login page methods will be called
             LoginPageBase lp = new LoginPageBase(driver);
             lp.setEmail_id(email);
             lp.setPassword(pwd);
             lp.setLogin_button();

             AfterLoginPageBase alb = new AfterLoginPageBase(driver);
             boolean target_page = alb.titlecheck();

             //Datariven logic start her


             if (exp_result.equalsIgnoreCase("Valid")) {
                 if (target_page) // this will execute only if target_page=true
                 {
                     System.out.println("Login successful, Test passed");
                     alb.logoutbuttonclick(); //clicking logout because login is success
                     Assert.assertTrue(true);
                 } else {
                     Assert.fail("Login Unsuccessful");
                     //No logout rquired because login was unsucessfull
                 }
             } else if (exp_result.equalsIgnoreCase("Invalid"))
             {
                 if (target_page) // data is invalid still login is successfull
                 {
                     alb.logoutbuttonclick();//clicking logout because login is success
                     Assert.fail(); // invalid data so login should not happen
                 } else {  // data is invalid login is not success
                     System.out.println("Test Passed");
                     Assert.assertTrue(true);
                 }
             }
         }
         catch(Exception e)
         {
             Assert.fail();
         }
        logger.info("**********Finished TC003_Login_DDT****************");
    }

}
