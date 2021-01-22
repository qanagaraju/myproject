package com.AppProject;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppObjects.AppObjects;
import com.AppObjects.WebLinks;
import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ConfigReader;
import com.AppUtilities.ScreenCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class AppLoginTest {
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static ConfigReader config;
	public static AppObjects Apploginpage;
	public static WebLinks weblinks;
	public static ScreenCapture capture;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static Logger logger = Logger.getLogger(AppLoginTest.class);
	
	
	@BeforeSuite
	public void AppSuite() {
		browser=new BrowserFactory();
		config=new ConfigReader();
		capture = new ScreenCapture();
		 extent = new ExtentReports("./extent/report.html", true);
		PropertyConfigurator.configure("./myfiles/log4j.properties");
		
	}
	
	
@BeforeTest
public void launchBrowser() {
	
	
	 driver=BrowserFactory.getBrowser(config.getbrowsername(),config.getbrowserurl());
	 System.out.println("launching browser");
}
	
@Test(priority=1,description="Verify valid login")
public void verifyvalidlogin() {
	
	Apploginpage=new AppObjects(driver);
	test = extent.startTest("login test");
	
	Apploginpage.getusername(config.getusername());
	System.out.println("Verify user name");
	Reporter.log("verify user name");
	logger.info("verify user name");
	//capture.screencapture(driver, "username");
	
	 String screenShotPath = capture.screencapture(driver,"verify user name");
     String screen1 = test.addScreenCapture(screenShotPath);
     test.log(LogStatus.FAIL, "Snapshot below: "+screen1);
	
	
	
	Apploginpage.getpassword(config.getpassword());
	System.out.println("verify password");
	logger.info("verify password");
	//capture.screencapture(driver, "password");
	test.log(LogStatus.INFO, "verify password");
	
	 String screenShotPath2 = capture.screencapture(driver,"verify password");
     String screen2 = test.addScreenCapture(screenShotPath2);
     test.log(LogStatus.FAIL, "Snapshot below: "+screen2);
	
	
	Apploginpage.clickloginbutton();
	System.out.println("verify button");
	logger.info("verify button");
	test.log(LogStatus.INFO, "verify button");
	//capture.screencapture(driver, "button");
	
try {
		
		Apploginpage.clicksignout();
		System.out.println("Verify signout button");
		logger.info("verify sign out");
		//capture.screencapture(driver, "signout");
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
	logger.info("verify home link");
	//capture.screencapture(driver, "home link");
}





@AfterTest
public void closeBrowser() {
	
	extent.flush();
	
	browser.closebrowser();
	System.out.println("Closing browser");
	logger.info("closing browser");
}

	
}
