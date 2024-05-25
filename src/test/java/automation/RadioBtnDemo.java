package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioBtnDemo {

	public static void main(String[] args) {

/*
 * first stored xpath of all radio btn in single webelement
 * check particular radio btn is selected or not
 * apply comaparision among radio btns to click on particular btn
 *  
 */
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		List<WebElement> radio=driver.findElements(By.xpath("//div[@id='radio-btn-example']//label/input"));
		int size=radio.size();
		System.out.println("Total Radio btns are:"+size);
		
		//driver.findElement(By.xpath("//input[@value='radio3']")).click();
		
		for(int i=0;i<size;i++)
		{
			if(!radio.get(i).isSelected() && radio.get(i).getAttribute("value").equals("radio3"))
			{
				radio.get(i).click();
				break;
			}
			
			else
			{
				System.out.println("Radio btn is already selected");
				break;
			}
		}
		
		 
	}

}
