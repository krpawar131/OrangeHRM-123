package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * JavascriptExecutor is an Interface which used to execute the java statement
		 * ExecuteScript()
		 * 
		 * Syntax - JavascriptExecutor js=driver;
		 */

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.nopcommerce.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		// to send text 
		WebElement serach=driver.findElement(By.id("small-searchterms"));
		js.executeScript("arguments[0].setAttribute('value','selenium')",serach );
		
		Thread.sleep(3000);
		
		//to click()
		//WebElement btn=driver.findElement(By.xpath("//button[text()='Search']"));
		//js.executeScript("arguments[0].click();", btn);
		
		//scroll by pixel
		
		//js.executeScript("window.scrollBy(1000,0)");
		
		// scroll to particular element
		
		WebElement news=driver.findElement(By.xpath("//div[@class='news-list-homepage']/div[@class='title']/strong"));
		js.executeScript("arguments[0].scrollIntoView();", news);
		
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

}
