package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupDemo {

	public static void main(String[] args) {
			
WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
//		if(driver.findElement(By.xpath("//span[@class='_30XB9F']")).isDisplayed())
//		{
//			driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();
//		}

	}

}
