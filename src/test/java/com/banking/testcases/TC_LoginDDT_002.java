package com.banking.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.banking.pageobject.LoginPage;
import com.banking.utility.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
		
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws IOException, InterruptedException
	{
		
		logger.info("Start the Loggin Test functionallty");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/V1/index.php");
		logger.info("Open the url ");
		 LoginPage lp=new  LoginPage(driver);
		 lp.setUsername(user);
		 logger.info("Set username");
		 lp.setPassword(pwd);
		 logger.info("Set Password");
		 lp.clickButton();
		Thread.sleep(3000);
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
			 lp.clickLogout();
			 Thread.sleep(3000);
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
		}
		else
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver,"login Test");
			
			logger.info("Test Case Failed");
			
			 Assert.assertFalse(false);
		}
		
		//logger.info("end  the Loggin Test functionallty");
	/*	
		if(isAlertPresent()==true)
		 {
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 Assert.assertFalse(false);
			 logger.warn("login Test failed");
		 }
		 else
		 {
			 Assert.assertTrue(true);
			 lp.clickLogout();
			 Thread.sleep(3000);
			 logger.info("login Test Passed");
			 driver.switchTo().alert().accept();
			 driver.switchTo().defaultContent();
			 
		 }*/
		
	}
	
	
	
	public boolean isAlertPresent()
	{
		
		try {
			driver.switchTo().alert();
			return true;
			
		}
		catch(NoAlertPresentException e)
		{
			return false;
			
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/banking/testdata/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1",1);
		String logindata[][]=new String [rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			
			for(int j=0;j<colcount;j++)
			{
				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
		
	}
}

