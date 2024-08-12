package com.banking.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobject.LoginPage;


public class Tc_login_testcase extends BaseClass
{
	
	@Test
	public void loginTestCase() throws IOException, Exception
	{
		driver.get(url);
		logger.info("url open");
		LoginPage login = new LoginPage(driver);
		
		login.setUsername(name);
		logger.info("Set Username and Password");
		
		login.setPassword(password);
		
		login.clickButton();
		Thread.sleep(3000);
		if(driver.getTitle().equals("GTPL Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			captureScreen(driver,"login Test");
			Assert.assertFalse(false);
			logger.info("Test Case Failed");
		}
		
		logger.info("Open Home Page");
	}

	
}
