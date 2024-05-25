package automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("//https://demo.automationtesting.in/Register.html"); 
		driver.manage().window().maximize();
		
		String act_title="Register";
		String exp_title=driver.getTitle();
		Assert.assertEquals(act_title,exp_title);
		System.out.println("Title is verified.....");
		
		WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("Kishor");
		
	    Thread.sleep(2000);
		driver.close();
		
		
		
		
	}

}
