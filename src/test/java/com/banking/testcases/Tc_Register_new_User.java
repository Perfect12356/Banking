package com.banking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageobject.LoginPage;
import com.banking.pageobject.CreateNewUser;
public class Tc_Register_new_User extends BaseClass{

	@Test
	public void Register_new_User_TestCase() throws IOException, Exception
	{
		driver.get(url);
		logger.info("url open");
		LoginPage login = new LoginPage(driver);
		
		login.setUsername(name);
		logger.info("Set Username and Password");
		
		login.setPassword(password);
		
		login.clickButton();
		Thread.sleep(3000);
		
		CreateNewUser user_new = new CreateNewUser(driver);
		user_new.click_CreateNewUser();
		user_new.setUserName("Akash Jadhav");
		
		/*if(driver.getTitle().equals("GTPL Manager HomePage"))
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
		*/
	}

}
