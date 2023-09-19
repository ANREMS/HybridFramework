package com.ust.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.BrowserConfig;

public class Locators {
	WebDriver driver;
	@Test
	public void locators() {
		/*
		 * id 
		 * name
		 * linktext-->   <a></a>
		 * classname
		 * xpath
		 * cssSelector
		 */
		driver=BrowserConfig.getchromeBrowser();
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();

	}
}
