package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainEditAccountBase extends BasePage {

    public MainEditAccountBase(WebDriver driver)
    {
        super(driver);
    }

    //locators

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement editfname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement editlname;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement editemail;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement edittelephone;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement editContinue;

    // Action methods

    public void setEditfname(String f_name)

    {
        editfname.clear();
        editfname.sendKeys(f_name);
    }
    public void setEditlname(String l_name)
    {
        editlname.clear();
        editlname.sendKeys(l_name);
    }
    public void setEditemail(String edit_email)
    {
        editemail.clear();
        editemail.sendKeys(edit_email);

    }
    public void setEdittelephone(String edit_telephone)
    {
        edittelephone.clear();
        edittelephone.sendKeys(edit_telephone);
    }
    public void setEditContinue()
    {
        editContinue.click();
    }
}
