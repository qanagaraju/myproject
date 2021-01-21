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





public class AppLoginTest {
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static ConfigReader config;
	public static AppObjects Apploginpage;
	
	@BeforeSuite
	public void AppSuite() {
		browser=new BrowserFactory();
		config=new ConfigReader();
		
	}
	
	
@BeforeTest
public void launchBrowser() {
	 driver=BrowserFactory.getBrowser(config.getbrowsername(),config.getbrowserurl());
	 System.out.println("launching browser");
}
	
@Test
public void verifylogin() {
	
	Apploginpage=new AppObjects(driver);
	
	Apploginpage.getusername(config.getusername());
	System.out.println("Verify user name");
	
	Apploginpage.getpassword(config.getpassword());
	System.out.println("verify password");
	
	Apploginpage.clickloginbutton();
	System.out.println("verify button");
	
	
}
	


@AfterTest
public void closeBrowser() {
	browser.closebrowser();
	System.out.println("Closing browser");
}

	
}
