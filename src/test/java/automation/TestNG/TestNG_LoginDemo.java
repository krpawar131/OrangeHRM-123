package automation.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNG_LoginDemo {

	
	WebDriver driver;
		
	@Test(priority=1)
	public void launchApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority=2)
	public void login() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//verify dashboard page after login
		String act="Dashboard";
		
		Thread.sleep(5000);
		String exp=driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
		
		AssertJUnit.assertEquals(act, exp);
		AssertJUnit.assertTrue(true);
		System.out.println("Login is successfull!!!");
	}
	
	@Test(priority=3)
	public void logout() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']//i")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
					
		String act="Login";
		Thread.sleep(5000);
		String expt=driver.findElement(By.xpath("//h5[text()='Login']")).getText();
			
		AssertJUnit.assertEquals(act, expt);
		AssertJUnit.assertTrue(true);
		System.out.println("Logout is successfull!!!");
	}
	
	
	@Test(priority=4)
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}
