package automation.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class GroupingTestsDemo {

	@Test(priority=1, groups= {"sanity","regression"})
	public void loginByEmail()
	{
		System.out.println("loginByEmail");
	}
	
	
	@Test(priority=2, groups= {"sanity"})
	public void loginByFacebbok()
	{
		System.out.println("loginByFacebbok");	
		
	}
	
	
	@Test(priority=3, groups= {"sachin"})
	public void loginByTwitter()
	{
		
		System.out.println("loginByTwitter");	
	}
	
	@Test(priority=4, groups= {"sanity","regression"})
	public void signupByemail()
	{
		
		System.out.println("signupByemail");	
	}
	
	
	@Test(priority=5, groups= {"regression"})
	public void signupByFacebook()
	{
		System.out.println("signupByFacebook");	
	}
	
	@Test(priority=6, groups= {"regression"})
	public void signupByTwitter()
	{
		System.out.println("signupByTwitter");	
	}
	
	@Test(priority=7, groups= {"smoke","regression"})
	public void paymentInRupees()
	{
		System.out.println("paymentInRupees");	
	}
	
	
	@Test(priority=8, groups= {"smoke"})
	public void paymentinDollar()
	{
		System.out.println("paymentinDollar");	
	}
	
	
}
