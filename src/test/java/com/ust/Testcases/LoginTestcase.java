package com.ust.Testcases;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseUI;
import POM.Login;
import Utilities.Excelutils;

public class LoginTestcase extends BaseUI {
	WebDriver driver;
	Login login;
	String[][] data;
	@BeforeMethod
	public void setup(){
		driver=invokebrowser();
		openBrowser("applicationURL");

	}
	@DataProvider(name = "testData")
	public Object[][] testdata(){
		data= Excelutils.testdata();
		return data;
	}
	@Test(dataProvider = "testData")
	public void loginTest(String username,String password,String expectedtext) {
		Login login=new Login(driver);
		login.userName(username);
		login.passWord(password);
		login.submit();
		if (username.equals("incorrectUser")) {
	        // Negative test case 2: Invalid username
			  // Verify error message is displayed
	        SoftAssertions.assertSoftly(softAssertions -> {
	            softAssertions.assertThat(driver.findElement(By.className("error-message")).isDisplayed()	);
	            // Verify error message text is Your username is invalid!
	        });
	        // Verify error message text is Your username is invalid!
	        Assertions.assertThat(driver.findElement(By.className("error-message")).getText()).isEqualTo("Your username is invalid!");
	    } else if (password.equals("incorrectPassword")) {
	    	 // Verify error message is displayed
	        SoftAssertions.assertSoftly(softAssertions -> {
	            softAssertions.assertThat(driver.findElement(By.className("error-message")).isDisplayed());
	            // Verify error message text is Your password is invalid!
	     
	        });
	        Assertions.assertThat(driver.findElement(By.className("error-message")).getText()).isEqualTo("Your username is invalid!");
	    } else {
	        // Positive test case: Valid credentials
	    	 SoftAssertions.assertSoftly(softAssertions -> {
		            softAssertions.assertThat(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));
		            
		           
		            // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
//		            softAssertions.assertThat(driver.findElement(By.xpath("//*[contains(text(), '" + expectedText + "')]")).isDisplayed());
		            // Verify button Log out is displayed on the new page
		            softAssertions.assertThat(driver.findElement(By.id("logoutButton")).isDisplayed());
		        });
	    }
	}

	
//	@AfterTest
//	public void teardown() {
//		driver.close();
//	}
}
