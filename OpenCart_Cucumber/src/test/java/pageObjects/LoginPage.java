package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//driver
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	//action methods
	public void setemail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clicklogin()
	{
		login.click();
	}

}
