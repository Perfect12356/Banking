package com.banking.testcases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.utils.FileUtil;
import com.banking.utility.readData_configfile;


public class BaseClass 
{
	 readData_configfile read = new readData_configfile();
	 public String url =read.getUrl();
	 public String name=read.getUsername();
	 public String password=read.getPassword();
	 
	 public static WebDriver driver;
	 public Logger logger;
	 
	 
	 
	 
	 @BeforeClass
	 public void setup()
	 {
		 ChromeOptions options = new ChromeOptions();
		 //options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		 
		 driver.manage().window().maximize();
		 
		 logger = Logger.getLogger("Banking_project");
		 PropertyConfigurator.configure("C:\\Users\\Perfect IT\\eclipse-workspace\\Banking_project\\log4j.properties");
		  
	 }
	 
	 @AfterClass
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 
	 public void captureScreen(WebDriver Driver,String tname) throws IOException
	 {	logger.info("excute the screen shot method");
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File source= ts.getScreenshotAs(OutputType.FILE);
		 
		 File target=new File("screenshot/"+tname+".png");	
		 FileUtils.copyFile(source,target);
		 System.out.println("Screenshot taken");
		 logger.info("Screenshot taken");
		 
	 }
}
