package selenium;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaits {

	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
				
		List<WebElement> radio=driver.findElements(By.xpath("//div[@id='radio-btn-example']//label/input"));
		System.out.println("Total Radio Buttons are:"+radio.size());
		
		for(int i=0;i<radio.size();i++)
		{
			//radio.get(i).click();
			String value=radio.get(i).getAttribute("value");
			System.out.println(value);
			if(value.equals("radio2"))
			{
				radio.get(i).click();
				break;
			}
		}
		
		for(WebElement e:radio)
		{
			String value=e.getAttribute("value");
			System.out.println(value);
			if(value.equals("radio3"))
			{
				e.click();
				break;
			}
		}
		Thread.sleep(2000);
		
		WebElement textbox=driver.findElement(By.xpath("//input[@id='autocomplete']"));
		
		wait.until(ExpectedConditions.visibilityOf(textbox));
		textbox.sendKeys("Selenium");
		
	}

}
