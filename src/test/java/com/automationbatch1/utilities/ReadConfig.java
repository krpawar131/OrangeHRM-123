package com.automationbatch1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	public static Properties prop;
	
	public ReadConfig()
	{
		File file=new File("./Configurations/Config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public static String getURL()
	{
		String url=prop.getProperty("url");
		System.out.println(url);
		return url;
	}
	
}
