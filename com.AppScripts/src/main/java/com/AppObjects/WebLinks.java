package com.AppObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.AppUtilities.ConfigReader;

public class WebLinks {
	
	public  WebDriver driver;
	public static ConfigReader repo = new ConfigReader();
	
	public WebElement homebutton;
	
	public WebLinks(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public void verifyhelplink() {
		homebutton = driver.findElement(By.xpath(repo.getHomeLinkelement()));
		if(homebutton.isEnabled()) {
			homebutton.click();
			System.out.println("Home button performed successfully");
		}
		else
		{
			System.out.println("Does not performed");
		}
	}
	

}
