package selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class DependencyTest {

	@Test
	public void openApp()
	{
		AssertJUnit.assertTrue(true);
		System.out.println("openApp method");
	}
	
	@Test
	public void login()
	{
		AssertJUnit.assertTrue(true);
		System.out.println("login method");
	}
	
	@Test
	public void search()
	{
		AssertJUnit.assertTrue(true);
		System.out.println("search method");
	}
	
	@Test
	public void advanceSearch()
	{
		AssertJUnit.assertTrue(true);
		System.out.println("advanceSearch method");
	}
	
	@Test
	public void logout()
	{
		AssertJUnit.assertTrue(true);
		System.out.println("logout method");
	}
}
