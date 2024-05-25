package automation.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HardAssertionDemo {

	/*
	 * 1. openApp
	 * 2. verify title 
	 * 3. close browser
	 */
	
	WebDriver driver;
	
	@BeforeClass
	public void openApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@Test(priority=1)
	public void verifyTitle()
	{
		String act_title="OrangeHRM1";
		String exp_title=driver.getTitle();
		
		AssertJUnit.assertEquals(act_title, exp_title);
		
		
	}
	
	@Test(priority=2)
	public void verifyLogo()
	{
		WebElement btn=driver.findElement(By.xpath("//button[@type='submit']"));
		AssertJUnit.assertTrue(btn.isDisplayed());
	}
	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
