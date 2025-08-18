package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageBase  extends BasePage{


  public  RegistrationPageBase(WebDriver driver)  //Constructor invoking from Base class
    {
        super(driver);
    }

    //Locators for the page using POM concept

    @FindBy(xpath="//input[@id ='input-firstname']")
    WebElement setFirstName;

    @FindBy(xpath="//input[@id ='input-lastname']")
    WebElement setLastName;

    @FindBy(xpath="//input[@id ='input-email']")
    WebElement setEmailId;

    @FindBy(xpath="//input[@id ='input-telephone']")
    WebElement setTelePhone;

    @FindBy(xpath="//input[@id ='input-password']")
    WebElement setPassword;

    @FindBy(xpath="//input[@id ='input-confirm']")
    WebElement confirmPassword;

    @FindBy(xpath="//input[@type ='checkbox']")
    WebElement checkbox;

    @FindBy(xpath="//input[@type ='submit']")
    WebElement continueButton;


    // Actions methods for page

    public void firstname(String fname)
    {
        setFirstName.sendKeys(fname);
    }
    public void lastname(String lname)
    {
        setLastName.sendKeys(lname);
    }
    public void emailID(String email)
    {
        setEmailId.sendKeys(email);
    }
    public void telephone(String phonenum)
    {
        setTelePhone.sendKeys(phonenum);
    }
    public void passwd(String pwd)
    {
        setPassword.sendKeys(pwd);
    }
    public void cnfpasswd(String cnfpwd)
    {
        confirmPassword.sendKeys(cnfpwd);
    }
    public void privacy_policy()
    {
        checkbox.click();
    }
    public void Button()
    {
        continueButton.click();
    }

}
