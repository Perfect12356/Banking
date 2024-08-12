package com.banking.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class CreateNewUser {
	WebDriver rdriver;

	String xpath_new_user = "//a[text()='New Customer']";
	
	String textFeild_new_User="name";
	
	public CreateNewUser(WebDriver driver) {
	rdriver=driver;
}

	public void click_CreateNewUser()
	{
		rdriver.findElement(By.xpath(xpath_new_user)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void setUserName(String name)
	{
		rdriver.findElement(By.name(textFeild_new_User)).sendKeys(name);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
