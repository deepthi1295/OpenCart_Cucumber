package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	//driver
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement displaytext;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	//action methods
	public boolean displaytext()
	{
		try
		{
			return (displaytext.isDisplayed());
		 
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
