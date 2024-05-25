package automation.TestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenersTest {

	WebDriver driver;
	
	@Test(priority=1)
	public  void test1()
	{
		WebDriverManager.edgedriver().create();
		driver=new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Assert.assertEquals(1,1);
	}
	
	
	@Test(priority=2)
	public void test2()
	{
		Assert.assertEquals("OrangeHRM123",driver.getTitle());
	}
	
	@Test(priority=3,dependsOnMethods = {"test2"})
	public void test3()
	{
		Assert.assertEquals(3,3);
	}
	
}
