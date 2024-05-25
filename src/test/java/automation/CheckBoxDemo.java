package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
//		WebElement chb1=driver.findElement(By.id("checkBoxOption1"));
//		wait.until(ExpectedConditions.visibilityOf(chb1));
//		chb1.click();
//				
//		WebElement chb2=driver.findElement(By.id("checkBoxOption2"));
//		wait.until(ExpectedConditions.visibilityOf(chb2));
//		chb2.click();
//
//		WebElement chb3=driver.findElement(By.id("checkBoxOption3"));
//		wait.until(ExpectedConditions.visibilityOf(chb3));
//		chb3.click();
//		
//		WebElement chb_1=driver.findElement(By.id("checkBoxOption1"));
//		wait.until(ExpectedConditions.visibilityOf(chb_1));
//		chb_1.click();
		
		List<WebElement>chb=driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
		System.out.println("Total no of Checkboxes are:"+chb.size());
		
		for(WebElement ch:chb)
		{
			//ch.click();
			
			//1 and 3 rd chb click 
			
			String value=ch.getAttribute("value");
			System.out.println(value);
			if(value.equals("option1") || value.equals("option2"))
			{
				ch.click();
			}
		}
		
	}

}
