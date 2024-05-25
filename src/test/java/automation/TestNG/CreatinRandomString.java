package automation.TestNG;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class CreatinRandomString {

	@Test
	public void randomString()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		System.out.println(str);
	}
	
	@Test
	public void randomNumber()
	{
		String num=RandomStringUtils.randomNumeric(10);
		System.out.println(num);
	}
	
	@Test
	public void randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(10);
		System.out.println(str+"_"+num+"@gmail.com");
	}
}
