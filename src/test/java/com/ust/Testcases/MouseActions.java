package com.ust.Testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.BrowserConfig;

public class MouseActions {
	WebDriver driver;
	@Test
	public void locators() throws IOException {
		/*
		 * id 
		 * name
		 * linktext-->   <a></a>
		 * classname
		 * xpath
		 * cssSelector
		 */
		driver=BrowserConfig.getchromeBrowser();
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement f1=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(f1);
		
		WebElement src=driver.findElement(By.id("draggable"));
		
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));
		WebElement dest=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		a.clickAndHold(src).moveToElement(dest).release(dest).build().perform();
		
		//convert webdriver object to takescreenshot
		TakesScreenshot src1=(TakesScreenshot) driver;
		//call getscreenShotAs method to create image file
		File src2=src1.getScreenshotAs(OutputType.FILE);
		//Move the image file to destination
		FileUtils.copyFile(src2, new File("D:\\Workspaces\\UST SDET Wave 3\\SeleniumDemos\\screenshots\\aa.jpg"));
		
		
	}
}
