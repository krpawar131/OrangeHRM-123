package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownBySelect {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

		WebElement drp=driver.findElement(By.id("dropdown-class-example"));
		wait.until(ExpectedConditions.visibilityOf(drp));
		
		Select sl=new Select(drp);
		
		sl.selectByIndex(1);
		Thread.sleep(2000);
		sl.selectByValue("option2");
		Thread.sleep(2000);
		sl.selectByVisibleText("Option3");
		
		
	}

}
