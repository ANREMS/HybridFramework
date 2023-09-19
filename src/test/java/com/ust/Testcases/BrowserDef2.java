package com.ust.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.BrowserConfig;

public class BrowserDef2 {
	WebDriver driver;
	@Test
	public void getBrowser() {
		//to open browser
		driver=BrowserConfig.getchromeBrowser();
		//if edge->webdriver d=new EdgeDriver();
		//to navigate to website
		driver.get("https://www.amazon.com");
		//to maximize the window
		driver.manage().window().maximize();
		//to navigate to website
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");
		
	}
	
	
}
