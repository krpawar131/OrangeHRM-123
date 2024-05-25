package automation;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeybordEventDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Actions act=new Actions(driver);
		
		act.sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(2000);
		
		act.sendKeys(Keys.ALT).perform();
		
		Thread.sleep(2000);
		
		act.sendKeys(Keys.TAB).perform();
		
		Thread.sleep(2000);
		
		act.sendKeys(Keys.BACK_SPACE).perform();
	}

}
