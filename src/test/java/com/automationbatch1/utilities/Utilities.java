package com.automationbatch1.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date; 

public class Utilities {

	
	
	public void clickOnElement(WebDriver driver, WebElement element)
	{
		try 
		{
			focusOnElement(driver, element);
			element.click();
		}
		catch(Exception e)
		{
			Assert.fail("Click on element failed"+ element + " "+ e.getMessage());
		}
	}
	
	
	public void JavaScriptClickOnElement(WebDriver driver,WebElement element)
	{
		try
		{
			focusOnElement(driver, element);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",element);
		}
		catch(Exception e)
		{
			Assert.fail("Click on element failed"+ element + " "+ e.getMessage());
		}
	}
	
	
	public void sendText(WebDriver driver,WebElement element,String text)
	{
		element.sendKeys(text);
	}
	
	
	public void javascriptScroll(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		try
		{
			if(element.isDisplayed())
			{
				js.executeScript("arguments[0].scrollIntoView();", element);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public boolean isElementDisplayed(WebElement element)
	{
		try 
		{
			return element.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public static void getScreenShot(WebDriver driver, String testCaseName, String validationStep)
	{
		try
		{
			File file=new File("Screenshots");
			if(!file.exists())
			{
				file.mkdir();
			}
			 
		SimpleDateFormat simpledate=new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
		String time=simpledate.format(new Date());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getenv("user.dir")+"/Screenshots"+ testCaseName+"/validation_Step_"+validationStep+"_T"+time +".png";
		File destination =new File(path);
		FileUtils.copyFile(src, destination);
		
		}
		catch(IOException e)
		{
		   System.out.println(e.getMessage());
		}
	
	}
	
	public void deleteCookies(WebDriver driver)
	{
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	
	public void focusOnElement(WebDriver driver, WebElement element)
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		catch(NoSuchElementException e)
		{
			Assert.fail("Element not found"+ element + " "+ e.getMessage());
		}
	}
	
	
	
}
