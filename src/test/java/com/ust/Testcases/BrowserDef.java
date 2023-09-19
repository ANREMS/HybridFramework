package com.ust.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.BrowserConfig;

public class BrowserDef {
	WebDriver driver;
	@Test
	public void getBrowser() {
		//to open browser
		driver=BrowserConfig.getchromeBrowser();
		//if edge->webdriver d=new EdgeDriver();
		//to navigate to website
		driver.get("https://www.google.com");
		//to maximize the window
		driver.manage().window().maximize();
		//to navigate to website
		driver.navigate().to("https://www.mycontactform.com");
		//navigational methods
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		String title=driver.getTitle();
		String url=driver.getCurrentUrl();
		System.out.println(title);
		System.out.println(url);
		
	}
	
	
}
