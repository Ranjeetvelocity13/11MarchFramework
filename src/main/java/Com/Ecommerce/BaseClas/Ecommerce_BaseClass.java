package Com.Ecommerce.BaseClas;

import java.lang.ProcessHandle.Info;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Ecommerce.Configuration.ReadConfiguration;
import Com.Ecommerce.Utilities.TestUtils;

public class Ecommerce_BaseClass {

	public static WebDriver driver;
	public static Logger logger;
    
	
	ReadConfiguration readconfig = new ReadConfiguration();
	
	public String BaseURL =  readconfig.getApplicationURL();
	public String Username = readconfig.Username();
	public String password = readconfig.Password();
	

	@SuppressWarnings("deprecation")
	@BeforeMethod
	
	@Parameters("Browser")
	public void initialization(String Browsername) {
		
		logger = logger.getLogger("11March_Automation_Framework");
		
		PropertyConfigurator.configure("log4j.properties");
		
		if(Browsername.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.GetChromepath());
		driver = new ChromeDriver();
		}
		else if(Browsername.equals("FireFox")) {
		 System.setProperty("webdriver.gecko.driver", readconfig.GetFirefox());
         driver = new FirefoxDriver();		
		}
		else if(Browsername.equals("Edge")) {
			 System.setProperty("webdriver.edge.driver", readconfig.GetFirefox());
         driver =new EdgeDriver();
		}
		
		logger.info("Open browser");
	   
		driver.manage().window().maximize();

		logger.info("Maximize the browser");
		
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(BaseURL);	
		
		logger.info("Open application");	
	}

	@AfterMethod
	public void Teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
