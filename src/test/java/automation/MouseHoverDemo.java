package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement desktops=driver.findElement(By.xpath("//a[text()='Desktops']"));
		
		//Mouse Hover ---> create obj of Actions
		
		Actions act=new Actions(driver);
		
     	act.moveToElement(desktops).build().perform();  // build--> create action & perform--> action perform
     	Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Mac (1)']")).click();
	}

}
