package Testcases2;

import Base.BrowserConfig;
import POM.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    @BeforeTest
    public void setup(){
        // Set the path of the ChromeDriver executable
        driver= BrowserConfig.getchromeBrowser();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void logintest(){
        // TestNG assertions
//        Assert.assertTrue(driver.getCurrentUrl().contains("login"));// Hard assertion
//        Assert.assertTrue(driver.findElement(By.className("custom-logo-link")).isDisplayed());

        Login login = new Login(driver);
        login.userName("student");
        login.passWord("Password123");
        login.submit();
        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/
//        SoftAssertions.assertSoftly(softAssertions -> {
//            softAssertions.assertThat(driver.getCurrentUrl().contains("practicetestautomation.com/logged-in-successfully/"));


            // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
//            softAssertions.assertThat(driver.findElement(By.xpath("//*[contains(text(), '" + expectedText + "')]")).isDisplayed());
            // Verify button Log out is displayed on the new page
//            softAssertions.assertThat(driver.findElement(By.id("logoutButton")).isDisplayed());


    }

    @AfterTest
    public void close(){
//    driver.close();

    }
}
