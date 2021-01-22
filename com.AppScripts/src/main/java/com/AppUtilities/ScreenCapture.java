package com.AppUtilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenCapture {

	
	
public static WebDriver driver;
	
	
	
	public  String screencapture(WebDriver driver,String screenname) {
	
		try {
			
		TakesScreenshot screen = (TakesScreenshot)driver;
		File file = screen.getScreenshotAs(OutputType.FILE);
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = "./screens/"+screenname+".png";
		File dest = new File(destination);
		FileUtils.copyFile(file, dest);
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			System.out.println("Captured screen");
		}
		
		
		
		
		return screenname;
		
		
		
		
		
		
	}
	
	
}
