package automation.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DataProviderDemo {

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@DataProvider(name="Sachin",indices= {0})
	String [][] loginData()
	{
		String [][] data= {
							{"Admin","admin123",},
							{"Admin1","admin123"},
							{"Admin","admin123"},
							{"Admin","admin12345"},
							{"Admina","admin1234"},
						  };
		
		return data;
	}
	
	@Test(dataProvider = "Sachin")
	public void login(String username,String password) throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String act="Dashboard";
		String expt=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(act, expt);
		Assert.assertTrue(true);
		System.out.println("Login is Successfull!!!!!!!!!!!!!");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("Logout is Successfull!!!!!!!!!!!!!");
	}
	
	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
}
