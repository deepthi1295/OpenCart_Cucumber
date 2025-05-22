package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class LoginSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage mp;
	List<HashMap<String, String>> datamap; //Data driven
	
	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() 
	{
		hp=new HomePage(BaseClass.getDriver());
		hp.setaccount();
		hp.setlogin();
	    
	}

	@When("the user enters email as {string} and password as {string}")
	public void the_user_enters_email_as_and_password_as(String email, String password) 
	{
		lp=new LoginPage(BaseClass.getDriver());
		lp.setemail(email);
		lp.setpassword(password);
	   
	}

	@When("the user clicks login button")
	public void the_user_clicks_login_button() 
	{
		lp.clicklogin();
	    
	}

	@Then("the user is navigated to my account page")
	public void the_user_is_navigated_to_my_account_page() 
	{
		mp=new MyAccountPage(BaseClass.getDriver());
		boolean targetstatus=mp.displaytext();
		Assert.assertEquals(targetstatus, true);
	    
	}
	
	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows) {

        try {
			datamap=DataReader.data(System.getProperty("user.dir")+"/testData/Opencart_LoginData.xlsx", "Sheet1");
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.setemail(email);
        lp.setpassword(pwd);

        lp.clicklogin();
        mp=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=mp.displaytext();
            System.out.println("target page: "+ targetpage);
            if(exp_res.equalsIgnoreCase("Valid"))
            {
                if(targetpage==true)
                {
                    mp.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equalsIgnoreCase("Invalid"))
            {
                if(targetpage==true)
                {
                    mp.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
	}

}
