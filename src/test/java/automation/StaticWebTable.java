package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// total rows
		List<WebElement> rows =driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		int totalrow=rows.size();
		System.out.println("Total rows are:"+totalrow);
		
		//total columns 
		List<WebElement> cols =driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		int totalcols=cols.size();
		System.out.println("Total cols are:"+totalcols);
		
		// print a particular data from table
		
		String price=driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[2]/td[3]")).getText();
		System.out.println(price);
		
		// print all table data in tabular format
		System.out.println("****data of table*****");
		for(int r=2;r<=totalrow;r++)
		{
			for(int c=1;c<=totalcols;c++)
			{	
				String data=driver.findElement(By.xpath("//table[@name='courses']/tbody/tr["+r+"]/td["+c+"]")).getText();
				
				System.out.print(data+"\t");
			}
		System.out.println(" ");
		}
		
		List<WebElement> instructor=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[1]"));
		System.out.println("Total Instructors are:"+instructor.size());
		
		for(WebElement in:instructor)
		{
			String name=in.getText().toString();
			System.out.println(name);
		}
		
		
		List<WebElement> cources=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[2]"));
		System.out.println("Total Courses are:"+cources.size());
		
		for(WebElement co:cources)
		{
			String course=co.getText().toString();
			System.out.println(course);
		}
		
		
		List<WebElement> prices=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
		System.out.println("Total Prices are:"+prices.size());
		
		for(WebElement p:prices)
		{
			String price1=p.getText().toString();
			System.out.println(price1);
		}
	}

}
