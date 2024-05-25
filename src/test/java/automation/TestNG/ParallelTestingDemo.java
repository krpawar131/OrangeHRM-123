package automation.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestingDemo {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	    
	}
	
	@Test
	public void login()
	{
		driver.get("https://demo.opencart.com/");
		Assert.assertTrue(true);
	}
	
	
	@AfterClass
	public void closeApp() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
