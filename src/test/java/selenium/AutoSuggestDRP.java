package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDRP {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
				
		WebElement search=driver.findElement(By.xpath("//textarea[@name='q']"));
		search.sendKeys("Automation");
		
		Thread.sleep(3000);
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='aajZCb']//ul/li//div[@class='wM6W7d']//span"));
		System.out.println(list.size());
		
	
		for(WebElement el:list)
		{
			String value=el.getText();
			System.out.println(value);
			
		}
		
		for(WebElement el:list)
		{
			String value=el.getText();
					
			if(value.contains("automation engineer"))
			{
				el.click();
				break;
			}
		}
		
	}

}
