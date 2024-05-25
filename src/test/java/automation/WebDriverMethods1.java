package automation;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMethods1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\src\\test");
//		ChromeDriver driver=new ChromeDriver();   

		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();   						 		// this method is used to maximize the browser window
		
		System.out.println("Title of the page:"+driver.getTitle());
		String url=driver.getCurrentUrl();
		System.out.println("Ciurrent URL of the WebPage is :"+url);
		
		//String pagesource=driver.getPageSource();
		//System.out.println("Page source :-"+pagesource);
		
		String window=driver.getWindowHandle();
		System.out.println("Window Id:"+window);
		
		
		
		driver.close();                          							//this method is used to close current window of browser
		
	}

}
