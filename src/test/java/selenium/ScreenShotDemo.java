package selenium;

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

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demo.nopcommerce.com/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src1=ts.getScreenshotAs(OutputType.FILE);
		File target1=new File("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\ScreenShots\\screenshot1.png");
		FileUtils.copyFile(src1, target1);
		System.out.println("ScreenShot1 taken successfully...........");
		
		Thread.sleep(5000);
		
		WebElement element=driver.findElement(By.xpath("//div[@class='category-grid home-page-category-grid']"));
		File src2=element.getScreenshotAs(OutputType.FILE);
		File target2=new File("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\ScreenShots\\screenshot2.png");
		FileUtils.copyFile(src2, target2);
		System.out.println("ScreenShot2 taken successfully...........");
	}

}
