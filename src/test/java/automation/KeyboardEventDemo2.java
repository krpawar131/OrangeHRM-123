package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEventDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		// send text to first textbox
		//select with ctr+a
		//copy text with ctr+c
		//move textbox2 with tab key
		//paste text in textbox2 with crt+v
		
		//KeyDown():-- is used to press key of keybord 
		//KeyUp() ;- used to release the key
		//sendkeys()
		
		driver.findElement(By.id("inputText1")).sendKeys("Automation Testing using selenium Java");
		
		Actions act=new Actions(driver);
		
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(2000);
		
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		Thread.sleep(2000);
		
		act.sendKeys(Keys.TAB).perform();
				
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
	}

}
