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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDemo {

	WebDriver driver;
	SoftAssert softAssert=new SoftAssert(); 
	
	@BeforeClass
	public void openApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	public void test()
	{
		String act_title="OrangeHRM";
		String exp_title=driver.getTitle();
		AssertJUnit.assertEquals(act_title, exp_title,"Title Does Not Matched");
		
		
		WebElement btn=driver.findElement(By.xpath("//button[@type='submit']"));
		AssertJUnit.assertTrue(btn.isDisplayed());
		softAssert.assertAll();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
