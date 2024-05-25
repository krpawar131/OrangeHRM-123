package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement passenger= driver.findElement(By.xpath("//div[@class='col-1']/div[1]/h3"));
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",passenger);
		
		Thread.sleep(3000);
		driver.findElement(By.id("dob")).click();
		
		WebElement mdrp=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select sl=new Select(mdrp);
		sl.selectByVisibleText("Nov");	
		
		
		
	}

}
