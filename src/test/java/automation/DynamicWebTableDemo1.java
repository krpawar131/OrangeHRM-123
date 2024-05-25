package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableDemo1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("Total no of rows are:"+rows.size());
		
				
		List<WebElement> cols=driver.findElements(By.xpath("//table[@class='dataTable']//tr/th"));
		System.out.println("Total no of cols are:"+cols.size());

		System.out.println("data of web table before refresh----------------");
		for(WebElement r:rows)
		{
			String value=r.getText();
			System.out.println(value);
		}
		
		driver.navigate().to("https://demo.guru99.com/test/web-table-element.php");
		driver.navigate().refresh();
		Thread.sleep(6000);
		List<WebElement> rows1=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("********************************data of web table after refresh*******************************");

		for(WebElement r:rows1)
		{
			String value1=r.getText();
			System.out.println(value1);
		}
		
		List<WebElement>comp=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("Toatal no companies are:"+comp.size());
		System.out.println("**************Company Names ************************************************");
		for(WebElement c:comp)
		{
			String value=c.getText();
			System.out.println(value);
		}
		
		
	}

}
