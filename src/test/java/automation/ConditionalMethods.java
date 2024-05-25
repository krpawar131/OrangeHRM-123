package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {

	public static void main(String[] args) {
		
	//1. isSelected()
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		WebElement radio1=driver.findElement(By.name("radiooptions"));
		radio1.click();
		boolean value=radio1.isSelected();
		System.out.println(value);
		
		if(radio1.isSelected())
		{
			System.out.println("Radio btn is selected");
		}
		else
		{
			System.out.println("Radio btn is not selected");
		}
		
		
		//2. isDisplayed()
		
		WebElement address=driver.findElement(By.xpath("//label[text()='Address']"));
		System.out.println(address.getText());
		boolean add=address.isDisplayed();
		System.out.println(add);
		
		if(address.isDisplayed())
		{
			System.out.println("Address element is present");
		}
		else
		{
			System.out.println("Address element is not present");
		}
		
		//3. isEnabled()
		
		WebElement btn=driver.findElement(By.id("submitbtn"));
		boolean b=btn.isEnabled();
		System.out.println(b);
	}

}
