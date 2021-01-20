package com.AppUtilities;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory extends ConfigReader  {
	
	public static WebDriver driver;
	
	
	
	public static WebDriver getBrowser(String browsername,String Appurl) {
		
		
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",prop.getProperty("browserpath"));
			 driver = new ChromeDriver();
			
		}
		else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("browserpath"));
			 driver = new FirefoxDriver();
			
		}
		else if(browsername.equals("edge")) {
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgepath"));
			 driver = new EdgeDriver();
			
		}
		
	
		
		driver.get(Appurl);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	
	public void closebrowser() {
		driver.quit();
	}
	
	
	

}
