package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestionDropDown {

	public static void main(String[] args) {
			
		WebDriver driver;
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.get("https://www.google.com/");
		
		WebElement searcbox=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		searcbox.sendKeys("automation testing");
		
		List<WebElement> drpoptions=driver.findElements(By.xpath("//div[@class='mkHrUc']/div/div/ul/li"));
		wait.until(ExpectedConditions.visibilityOf(searcbox));
		System.out.println(drpoptions);
	}

}
