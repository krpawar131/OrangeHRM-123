package com.automationbatch1.testcases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automationbatch1.baseclass.BaseClass;
import com.automationbatch1.pageobjects.LoginPage;
import com.automationbatch1.utilities.ExcelUtils;


public class LoginTest extends BaseClass{
    
	 public LoginPage lp;
    
       
    @Test(dataProvider = "login_Data")
    public void testLogin(String username,String password)
    {
    	lp=new LoginPage(driver);
    	lp.setUsername(username);
    	log.info("Username is entered successfully");
    	lp.setPassword(password);
    	log.info("password is entered successfully");
    	lp.selectAdminRadioBtn();
    	log.info("Admin radio btn is selected successfully");
    	lp.selectValueFromDrp();
    	log.info("Value is selected from dropdown is successfuly");
    	lp.clickOnChbox();
    	log.info("Clicked on Checkbox successfully");
    	lp.clickOnSigin();
    	log.info("Clicked on sign btn successfully");
    	boolean  label=lp.verifyShopName();
    	if(label==true)
    	{
    		log.info("test passed....");
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		log.info("test failed......");
    		Assert.fail();
    	}
    }
    
    
   @DataProvider(name="login_Data")
   public String [][] getData() throws Exception
   {
	   String filepath="./TestData/LoginData.xlsx";
	   
	   int totalrows=ExcelUtils.getTotalRows(filepath, "Sheet1");
	   int totalcells=ExcelUtils.getTotalColumns(filepath, "Sheet1",0);
	   	   
	   String data[][]=new String[totalrows][totalcells];
	   
	   for(int r=1;r<=totalrows;r++)
	   {
		   for(int c=0;c<totalcells;c++)
		   {
			   data[r-1][c]=ExcelUtils.getCellData(filepath, "Sheet1", r, c);
		   }
	   }
	   
	   return data;
   }
	
}
