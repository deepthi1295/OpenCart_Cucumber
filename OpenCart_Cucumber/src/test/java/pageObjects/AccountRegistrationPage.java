package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class AccountRegistrationPage extends BasePage
{
	//driver
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement cpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement proceed;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//action methods
	public void setFirstName(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setemail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void settelephone(String phone)
	{
		telephone.sendKeys(phone);
	}
	
	public void setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void setcpassword(String cpass)
	{
		cpassword.sendKeys(cpass);
	}
	
	public void setagree()
	{
		agree.click();
	}
	
	public void clickcontinue()
	{
		proceed.click();
	}
	
	public String confirmationmsg()
	{
		try
		{
			return msgConfirmation.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
