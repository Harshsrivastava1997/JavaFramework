package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AfterLoginPageBase extends BasePage {

    public AfterLoginPageBase(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement title;

    @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
    WebElement logout;



    public boolean titlecheck() {

        try {
            Boolean answer = title.isDisplayed();
            Assert.assertTrue(answer, "Title not matched");
            return answer;
        } catch (Exception e) {
            Assert.fail("Exception occurred while verifying title: " + e.getMessage());
            return false;
        }
    }

        public void logoutbuttonclick()//To take other input in Data driven test lgoout is reuire;
        {
            logout.click();
        }
    }
