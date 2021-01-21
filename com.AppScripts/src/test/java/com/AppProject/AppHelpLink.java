package com.AppProject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppObjects.WebLinks;
import com.AppUtilities.BrowserFactory;
import com.AppUtilities.ConfigReader;

public class AppHelpLink {
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static ConfigReader config;
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
	
	
	@Test
  public void verifyHelpButton() {
	  
		weblinks=new WebLinks(driver);
		weblinks.verifyhelplink();
		System.out.println("verify home link");
		
	  
	  
  }
}
