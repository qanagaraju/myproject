package com.AppProject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppObjects.AppObjects;
import com.AppObjects.WebLinks;
import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ConfigReader;





public class AppLoginTest {
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static ConfigReader config;
	public static AppObjects Apploginpage;
	public static WebLinks weblinks;
	
	
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
	
@Test(priority=1,description="Verify valid login")
public void verifyvalidlogin() {
	
	Apploginpage=new AppObjects(driver);
	
	Apploginpage.getusername(config.getusername());
	System.out.println("Verify user name");
	Reporter.log("verify user name");
	
	Apploginpage.getpassword(config.getpassword());
	System.out.println("verify password");
	
	Apploginpage.clickloginbutton();
	System.out.println("verify button");
	
	
try {
		
		Apploginpage.clicksignout();
		System.out.println("Verify signout button");
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}finally
	{
		System.out.println("login pass");
	}
	
	
	
}
	
@Test(priority=2,description="Verify invalid login")
public void verifyinvalidlogin() {
	
	Apploginpage=new AppObjects(driver);
	
	Apploginpage.getusername(config.getinvalidusername());
	System.out.println("Verify user name");
	
	Apploginpage.getpassword(config.getpassword());
	System.out.println("verify password");
	
	Apploginpage.clickloginbutton();
	System.out.println("verify button");
	
	try {
		
		Apploginpage.clicksignout();
		System.out.println("Verify signout button");
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}finally
	{
		System.out.println("login fail");
	}
	
	
}


@Test(priority=3,description="Verify HomeLin")
public void verifyhomelink() {
	weblinks=new WebLinks(driver);
	weblinks.verifyhelplink();
	System.out.println("verify home link");
}


@AfterTest
public void closeBrowser() {
	browser.closebrowser();
	System.out.println("Closing browser");
}

	
}
