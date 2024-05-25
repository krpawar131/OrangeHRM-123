package automation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo3 {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> price=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
		System.out.println("Total no of prices:"+price.size());
		
		List<String> array=new ArrayList<String>();
		
		int sum=0;
		for(WebElement p: price)
		{
			String value=p.getText();
			System.out.println(value);
			
			//0+30=30 ;30+25=55 
			sum=sum+Integer.parseInt(value);  // string int convert -- wrapper classes --Integer.parseInt(value)
		}
		
		System.out.println("Total sum of prices ="+ sum);
		float avg=sum/price.size();
		System.out.println("Avg of prices ="+ avg);
		
		// try to find out Max and Min no from the prices ......
		
		//System.out.println(Collections.max(null));
		
		
		for(int i=0;i<=price.size();i++)
		{
					
			
			
		}
	}

}
