package com.AppObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.AppUtilities.ConfigReader;
import com.AppUtilities.ScreenCapture;


public class AppObjects   {
	
public WebDriver driver;
public static ConfigReader repo = new ConfigReader();
public static ScreenCapture cap;

public static WebElement uname,pword,lbutton,signoutbutton;

/*
	@FindBy(name="unrepo")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;

	@FindBy(name="btnSubmit")
	WebElement button;
	*/
	
	
	public AppObjects(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
public void getusername(String un) {
		
	cap = new ScreenCapture();
	uname=driver.findElement(By.name(repo.getunelement()));
	uname.sendKeys(un);
	//cap.screencapture(driver, uname, "username");	
	
	}
		

public void getpassword(String pw) {
	pword=driver.findElement(By.name(repo.getpwelement()));
	pword.sendKeys(pw);
	//cap.screencapture(driver, pword, "Password");
}

	public void clickloginbutton() {
		lbutton=driver.findElement(By.name(repo.getbuttonelement()));
		lbutton.click();
		//cap.screencapture(driver, lbutton, "Login Button");
	}

	
public void clicksignout() {
	
	signoutbutton=driver.findElement(By.xpath(repo.signoutelement()));
	signoutbutton.click();
	//cap.screencapture(driver, signoutbutton, "SignOutButton");
}

}
