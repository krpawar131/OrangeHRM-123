package automation.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class DependencyTest {

	
	/*
	 * 1. openApp
	 * 2. login
	 * 3. search
	 * 4. logout
	 */
	
	@Test(priority=1, groups= {"regression"})
	public void openApp()
	{
		AssertJUnit.assertTrue(true);
	}
	
	@Test(priority=2,dependsOnMethods = {"openApp"}, groups= {"regression"})
	public void login()
	{
		AssertJUnit.assertTrue(true);
	}
	
	@Test(priority=3, groups= {"regression"})
	public void search()
	{
		
		AssertJUnit.assertTrue(true);
	}
	
	@Test(priority=4,dependsOnMethods = {"openApp","login","search" }, groups= {"regression"})
	public void logout()
	{
		AssertJUnit.assertTrue(true);
	}
	
}
