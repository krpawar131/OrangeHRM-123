package automation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.nopcommerce.com/");
		
		//1. create TakesScreenshot interface ref variable
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		//2. capture screenshot by using getScreenshotAs() and stored in srcfile variable of type File
		
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		
		//3. set path of targeted file and name of screenshot by creating a new File
		
		File targetfile=new File("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\ScreenShots\\screenshot.png");
		
		//4. copy the sourcefile screenshot into targeted file 
		
		FileUtils.copyFile(srcfile, targetfile);
		
		/************************************************************************************************/
		
		
		WebElement Featuredproducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File srcfile1=Featuredproducts.getScreenshotAs(OutputType.FILE);
		
		//3. set path of targeted file and name of screenshot by creating a new File
		
		File targetfile1=new File("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\ScreenShots\\screenshot1.jpg");
		
		//4. copy the sourcefile screenshot into targeted file 
		
		FileUtils.copyFile(srcfile1, targetfile1);
	}

}
