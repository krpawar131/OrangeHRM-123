package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		
		//1. close()
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize(); 

		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		//driver.close();
		driver.quit();
	}

}
