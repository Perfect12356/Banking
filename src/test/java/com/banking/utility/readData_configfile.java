package com.banking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readData_configfile 
{
	Properties prop;
	public readData_configfile()
	{
		
		try
		{
			File src = new File("./Configuration/config.properties");
			
			FileInputStream  file = new FileInputStream(src);
			prop = new Properties();
			prop.load(file);	
		}
		catch(Exception e)
		{
			System.out.println("Exception :"+e.getMessage());
	
		}
	}
	
	public String getUrl()
	{
		String url=prop.getProperty("url");
		return url;
	}

	
	public String getUsername()
	{
		String name=prop.getProperty("name");
		return name;
	}

	
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}

	public String custname()
	{
		String cname = prop.getProperty("cname");
		return cname;
	}
}
