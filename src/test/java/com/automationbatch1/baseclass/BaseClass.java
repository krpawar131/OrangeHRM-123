package com.automationbatch1.baseclass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automationbatch1.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Logger log;
	//public  ReadConfig readconfig=new ReadConfig();
	//public String baseURL=readconfig.getURL();
	
	public Properties prop;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		
		FileReader file=new FileReader("./Configurations/Config.properties");
		prop=new Properties();
		prop.load(file);
		
		log=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome":WebDriverManager.chromedriver().setup();
					  driver=new ChromeDriver();
					  break;
					
		case "edge":WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					break;
					
		default: System.out.println("No Matching browser found");
					return;
		
		}
	  		
		log.info("Browser is Launched successfully");
	
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("url"));
		log.info("URL is opened successfully");
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
		log.info("Browser is closed successfully");
	}
	
   public String captureScreenshot(String tname) throws IOException {
		
		String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		File sourceFile=takeScreenShot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"/Screenshots"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(sourceFile, targetFile);
		return targetFilePath;	
		
	}
	
}
