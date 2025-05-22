package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	Properties p;
	
	@Before
	public void setUp() throws IOException
	{
	    driver=BaseClass.initializeDriver();
		p=BaseClass.getProperty();
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
		
	}

	@After
	public void teardown()
	{
		driver.quit();
	}
	
	@AfterStep
	public void addScteenshot(Scenario scenario)
	{
		// this is for cucumber junit report
		if(scenario.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
}
