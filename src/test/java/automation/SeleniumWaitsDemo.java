package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitsDemo {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//implicit wait -- it applicable to whole automation script
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit wait
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10)); // throws ElementNotVisibleException
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
				
		WebElement textbox=driver.findElement(By.id("autocomplete"));
		
		wait.until(ExpectedConditions.visibilityOf(textbox));
		
		textbox.sendKeys("Selenium Java");
		
		WebElement btn=driver.findElement(By.id("openwindow"));
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		btn.click();
		
		
	}

}
