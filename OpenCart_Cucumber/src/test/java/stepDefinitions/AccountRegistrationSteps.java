package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class AccountRegistrationSteps {
	WebDriver driver;
	HomePage hp;
	AccountRegistrationPage ar;
	
	@Given("the user navigates to registration page")
	public void the_user_navigates_to_registration_page() 
	{
	    hp=new HomePage(BaseClass.getDriver());
	    hp.setaccount();
	    hp.setregister();
	    
	}

	@When("the user enters the details as below")
	public void the_user_enters_the_details_as_below(DataTable dataTable) 
	{
		ar=new AccountRegistrationPage(BaseClass.getDriver());
		Map<String, String>datamap=dataTable.asMap(String.class,String.class);
		ar.setFirstName(datamap.get("firstname"));
		ar.setLastName(datamap.get("lastname"));
		ar.setemail(BaseClass.randomStringAlphaNumeric()+"@gmail.com");
		ar.settelephone(datamap.get("telephone"));
		ar.setpassword(datamap.get("password"));
		ar.setcpassword(datamap.get("password"));
	    
	}

	@When("the user agrees and click continue")
	public void the_user_agrees_and_click_continue() {
	   ar.setagree();
	   ar.clickcontinue();
	}

	@Then("the registration message is shown to user")
	public void the_registration_message_is_shown_to_user() {
	   String actualText= ar.confirmationmsg();
	   Assert.assertEquals(actualText, "Your Account Has Been Created!");
	}


}
