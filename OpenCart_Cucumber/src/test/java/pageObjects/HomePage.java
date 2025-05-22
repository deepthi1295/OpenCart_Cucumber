package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	//driver
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement register;
	

	//action methods
	
	public void setaccount()
	{
		MyAccount.click();
	}
	
	public void setlogin()
	{
		login.click();
	}
	
	public void setregister()
	{
		register.click();
	}
}
