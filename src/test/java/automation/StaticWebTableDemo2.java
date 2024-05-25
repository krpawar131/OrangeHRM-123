package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableDemo2 {

	public static void main(String[] args) {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// storing all price in list webelement
		
		List<WebElement> price =driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
		
		for(int r=2;r<=price.size();r++)
		{
			
			String price1=driver.findElement(By.xpath("//table[@name='courses']/tbody/tr["+r+"]/td[3]")).getText();
			if(price1.equals("25"))
			{
				String instructor =driver.findElement(By.xpath("//table[@name='courses']/tbody/tr["+r+"]/td[1]")).getText();
				String cource=driver.findElement(By.xpath("//table[@name='courses']/tbody/tr["+r+"]/td[2]")).getText();
				
				System.out.println("Name of the Insrtuctor and cousrce for the price"+" "+price1+" "+"are:");
				System.out.println("Insrtuctor Name="+instructor);
				System.out.println("Cource Name="+cource);
			}
			System.out.println("--------------------------------------------------------------------------");
		}
	}

}
