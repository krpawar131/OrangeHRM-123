package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionDropDown {

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
		System.out.println("Total list in dropdown:"+list.size());
		
		for(WebElement op:list)
		{
			String value=op.getText();
			System.out.println(value);
		}
		
		for(WebElement op:list)
		{
			String value=op.getText();

			if(value.equals("automation engineer"))
			{
				System.out.println("You have clicked on"+" "+op.getText()+" "+"successfully");
				op.click();
				break;
			}
		}
		
	}

}
