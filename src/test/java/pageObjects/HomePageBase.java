package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageBase extends BasePage{

    public HomePageBase(WebDriver driver) //Constructor invoking from BasePage class
    {
        super(driver);
    }

    //locators for Base Page

    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement Myaccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement Register;

    @FindBy(xpath="//a[text()=\"Login\"]")
    WebElement Login;


    //Action methods

    public void setAccount()
    {
        Myaccount.click();

    }
    public void setRegister()
    {
        Register.click();
    }

    public void setLogin()
    {
        Login.click();
    }
}
