package com.AppObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.AppUtilities.ConfigReader;


public class AppObjects   {
	
public WebDriver driver;
public static ConfigReader repo = new ConfigReader();




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
		
	driver.findElement(By.name(repo.getunelement())).sendKeys(un);
		
	}
		

public void getpassword(String pw) {
	driver.findElement(By.name(repo.getpwelement())).sendKeys(pw);
	
}

	public void clickloginbutton() {
		driver.findElement(By.name(repo.getbuttonelement())).click();
	}

	
public void clicksignout() {
	
	driver.findElement(By.xpath(repo.signoutelement())).click();
}

}
