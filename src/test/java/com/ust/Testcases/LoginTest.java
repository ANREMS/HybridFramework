package com.ust.Testcases;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BrowserConfig;

public class LoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set the path of the ChromeDriver executable
    	driver=BrowserConfig.getchromeBrowser();
		driver.navigate().to("https://www.mycontactform.com");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "loginData")
    public void positiveLoginTest(String username, String password, String expectedText) {
        login(username, password);

        // TestNG assertions
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Assert.assertEquals(driver.findElement(By.id("welcomeMessage")).getText(), "Welcome!");
        
        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));
            
           
            // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
            softAssertions.assertThat(driver.findElement(By.xpath("//*[contains(text(), '" + expectedText + "')]")).isDisplayed());
            // Verify button Log out is displayed on the new page
            softAssertions.assertThat(driver.findElement(By.id("logoutButton")).isDisplayed());
        });
    } 

    @Test(dataProvider = "loginData")
    public void negativeUsernameTest(String username, String password, String expectedText) {
        login(username, password);

        // Verify error message is displayed
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(driver.findElement(By.className("error-message")).isDisplayed()	);
            // Verify error message text is Your username is invalid!
        });
        // Verify error message text is Your username is invalid!
        Assertions.assertThat(driver.findElement(By.className("error-message")).getText()).isEqualTo("Your username is invalid!");

    }

    @Test(dataProvider = "loginData")
    public void negativePasswordTest(String username, String password, String expectedText) {
        login(username, password);

        // Verify error message is displayed
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(driver.findElement(By.className("error-message")).isDisplayed());
            // Verify error message text is Your password is invalid!
     
        });
        Assertions.assertThat(driver.findElement(By.className("error-message")).getText()).isEqualTo("Your username is invalid!");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    public void login(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }
}