package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebtableDemo {

	public static void main(String[] args) throws InterruptedException {

		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> company=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("Total no of prices:"+company.size());
		Thread.sleep(3000);
		
		
		System.out.println("Company Names are before refresh :");
		
		for(WebElement co:company)
		{
			String value=co.getText().toString();
			System.out.println(value);
		}
		
		
		driver.navigate().to("https://demo.guru99.com/test/web-table-element.php");
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		List<WebElement> company1=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("****************************************************************");
		System.out.println("Company Names are After refresh :");
		
		for(WebElement co:company1)
		{
			String value=co.getText().toString();
			System.out.println(value);
		}
	}

}
