package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {

	public static void main(String[] args) {
			
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		WebElement chb1=driver.findElement(By.id("checkBoxOption1"));
		chb1.click();
		System.out.println(chb1.isDisplayed());
		System.out.println(chb1.isSelected());
		
		WebElement chb2=driver.findElement(By.id("checkBoxOption2"));
		
		WebElement chb3=driver.findElement(By.id("checkBoxOption3"));
		
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
		int totalcheckboxes=checkboxes.size();
		System.out.println("Total Checkboxes Are:-"+totalcheckboxes);
		
		for(WebElement chb:checkboxes)
		{
			String value=chb.getAttribute("value");
			System.out.println(value);
			
			if(value.equals("option3"))
			{
				chb.click();
				break;
			}
		}
	}

}
