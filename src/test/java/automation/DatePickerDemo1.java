package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * 
		 * 1. click on datepicker
		 * 2. select month and year----String month="June" string year="2018"
		 * 3. Match the given month and year---find xpath and gettext 
		 * 4. next button click -- until match -- break loop
		 * 5. string date="25" -- date table match -- click date -- break
		 * 
		 * while(true)
		 * {
		 * if(true)
		 * {
		 * 	Match the given month and year---find xpath and gettext
		 *  break;
		 * }
		 * 	click on next button 
		 * }
		 * 
		 *  date select 
		 *  for()
		 */
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		//driver.findElement(By.id("datepicker")).sendKeys("31/03/2024");
		
		//1. click on datepicker
		
		driver.findElement(By.id("datepicker")).click();
		
		//2. date , month and year -- store in variable
		
		String date="25";
		String month="June";
		String year="2020";
		
		//3. match month and year 
		
		while(true)
		{
			String m=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(m.equals(month) && yr.equals(year))
			{
				break;
			}
			
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
			
		}
		
		// 4. select date from date table
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//td"));
		
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}

	}

}
