package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountsBase extends BasePage {

    public EditAccountsBase(WebDriver driver)
    {
        super(driver);
    }

    //Locators
     @FindBy(xpath="//a[normalize-space()='Edit Account']")
      WebElement EditAccount;

    //Actions methods
    public void setEditAccount()
    {
        EditAccount.click();
    }

}
