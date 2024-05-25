package com.automationbatch1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationbatch1.utilities.Utilities;

public class LoginPage {

	public WebDriver driver;
	public Utilities utility=new Utilities();	
	
	
	//1. constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
			
	//2. webelements
	
	@FindBy(xpath="//input[@name='username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;
		
	@FindBy(xpath="//input[@value='admin']")
	WebElement rbtn_admin;
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement drp;
	
	@FindBy(xpath="//input[@id='terms']")
	WebElement chbx;
	
	@FindBy(xpath="//input[@id='signInBtn']")
	WebElement btn_signIn;
	
	@FindBy(xpath="//h1[text()='Shop Name']")
	WebElement lable_shopName;
	
	//3. action methods
	
	public void setUsername(String username)
	{
		utility.focusOnElement(driver, txt_username);
		txt_username.sendKeys(username);
	}
		
	public void setPassword(String password)
	{
		utility.focusOnElement(driver, txt_password);
		txt_password.sendKeys(password);
	}
	
	public void selectAdminRadioBtn()
	{
		utility.clickOnElement(driver, rbtn_admin);
		//rbtn_admin.click();
	}
	
	public void selectValueFromDrp()
	{
		utility.focusOnElement(driver, drp);
		Select sl=new Select(drp);
		sl.selectByIndex(0);
	}
	
	public void clickOnChbox()
	{
		utility.clickOnElement(driver, chbx);
		//chbx.click();
	}
	
	public void clickOnSigin()
	{
		utility.clickOnElement(driver, btn_signIn);
		//btn_signIn.click();
	}
	
	public boolean verifyShopName()
	{
		utility.focusOnElement(driver, lable_shopName);
		boolean lable=lable_shopName.isDisplayed();
		return lable;
		
	}
}
