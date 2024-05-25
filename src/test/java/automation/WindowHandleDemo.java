package automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleDemo {

	public static void main(String[] args) throws InterruptedException {
			
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		System.out.println("You clicked on OrangeHRM, Inc link successfully.....");
		
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows);
		
		//List<String> winID=new ArrayList<String>(windows);
		
		ArrayList<String> winID=new ArrayList<String>(windows);
		
		String parentWindow=winID.get(0);
		System.out.println("Parent window Id:"+parentWindow);
		
		String childWindow=winID.get(1);
		System.out.println("Child window Id:"+childWindow);
		
		//to switch over a particular window we have to use  driver.switchTo().window(childWindow);
		
		driver.switchTo().window(childWindow);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//button[@class='btn btn-ohrm btn-contact-sales']")).click();
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent window........");
		
	}

}
