	package factory;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	

	static WebDriver driver;
    static Properties p;
	static Logger logger;
	
	 public static WebDriver initializeDriver() throws IOException
	 {
		 p=getProperty();
		 String browser=p.getProperty("browser");
		 String os=p.getProperty("os");
		 String ExecutionEnv=p.getProperty("execution_env");
		 
		 if(ExecutionEnv.equalsIgnoreCase("remote"))
			 
		 {
			 DesiredCapabilities capabilities=new DesiredCapabilities();
			 //os
			 switch(os.toLowerCase())
			 {
				 case "windows":capabilities.setPlatform(Platform.WIN11);break;
				 case "mac":capabilities.setPlatform(Platform.MAC);
				 case "linux":capabilities.setPlatform(Platform.LINUX);
				 default: System.out.println("Invalid os"); return null;
			 }
			 //browser
			 switch(browser.toLowerCase())
			 {
			    case "chrome":capabilities.setBrowserName("chrome");break;
			    case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			    case "firefox":capabilities.setBrowserName("firefox");break;
			    default:System.out.println("invalid browser"); return null;
			 }	
			 
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			 
			 
		 }
		 else if(ExecutionEnv.equalsIgnoreCase("local"))
		 {
			 switch(browser)
			 {
			 case "chrome":driver=new ChromeDriver();break;
			 case "edge":driver=new EdgeDriver();break;
			 case "firefox":driver=new FirefoxDriver();break;
			 case "safari":driver=new SafariDriver();break;
			 default:System.out.println("invalid browser");driver= null;
			 }
		 }
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 return driver;
	 }
	 
	 public static WebDriver getDriver()
	 {
		 return driver;
	 }
	 
	 public static Properties getProperty() throws IOException
	 {
		 FileReader file=new FileReader(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		 p=new Properties();
		 p.load(file);
		 return p;
	 }
	 
	 public static Logger logger()
	 {
		 logger=LogManager.getLogger();
		 return logger;
	 }
	
	 public static String randomStringAlphabet() 
	 {
		 String randomalphabet=RandomStringUtils.randomAlphabetic(5);
		 return randomalphabet;
	 }
	 
	 public static String randomStringNumber()
	 {
		 String randomnumber=RandomStringUtils.randomNumeric(10);
		 return randomnumber;
	 }
	 
	 public static String randomStringAlphaNumeric()
	 {
		 String alphanumeric=RandomStringUtils.randomAlphanumeric(5);
		 return alphanumeric;
	 }

}
