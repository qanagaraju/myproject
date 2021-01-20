package com.AppProject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppObjects.AppObjects;
import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ConfigReader;





public class AppLoginTest extends AppBaseClass {
	public static WebDriver driver;
	public static ConfigReader config;
	
	@BeforeSuite
	public void AppSuite() {
		browser=new BrowserFactory();
		config=new ConfigReader();
		
	}
	
	
@BeforeTest
public void launchBrowser() {
	 driver=BrowserFactory.getBrowser(config.getbrowsername(),config.getbrowserurl());
}
	
@Test
public void verifylogin() {
	
	Apploginpage=new AppObjects(driver);
	
	Apploginpage.getusername(config.getusername());
	Apploginpage.getpassword(config.getpassword());
	
	Apploginpage.clickloginbutton();
	
	
	
}
	


@AfterTest
public void closeBrowser() {
	browser.closebrowser();
}

	
}
