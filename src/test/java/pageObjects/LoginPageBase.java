package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageBase extends BasePage{

    public LoginPageBase(WebDriver driver)   //Constructor
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email_id;
    @FindBy(xpath ="//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement login_button;

    //Action methods

    public void setEmail_id(String email)
    {
        email_id.clear();
        email_id.sendKeys(email);

    }
    public void setPassword(String Password)
    {
        password.clear();
        password.sendKeys(Password);
    }
    public void setLogin_button()
    {
        login_button.click();
    }


    }


