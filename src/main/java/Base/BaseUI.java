package Base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.FileIO;

public class BaseUI {

	public static WebDriver driver;
	public static Properties prop;
	public static String browserChoice; 
	public BaseUI() {
		prop=FileIO.initProperties();
	}
	/*****************invoke browser**************/
	public static WebDriver invokebrowser() {
		browserChoice=prop.getProperty("browserName");
		if(browserChoice.equalsIgnoreCase("chrome")) {
			driver=BrowserConfig.getchromeBrowser();
		}
		return driver;
	}
	/*****************open website url**************/
	public static void openBrowser(String websiteurl) {
		driver.get(prop.getProperty(websiteurl));
	}
	/*************check if the element is present********/
	public static boolean isElementPresent(By locator,Duration timeout) {
		try {
			new WebDriverWait(driver,timeout)
			.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	 /************** Get text of element ****************/
    public static String getText(By locator) {
        String text = null;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
            text = driver.findElement(locator).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
	/************send text to element***************/
	public static void sendtext(By locator,String text) {
		try {
			new WebDriverWait(driver,Duration.ofSeconds(15))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).sendKeys(text);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/****************click element*****************/
	public static void clickOn(By locator) {
		try {
			new WebDriverWait(driver,Duration.ofSeconds(15))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/****************get locator*******************/
	public static By getlocator(String locatorKey) {
		if (locatorKey.endsWith("_id")) {
            return By.id(prop.getProperty(locatorKey));
        }
        if (locatorKey.endsWith("_name")) {
            return By.name(prop.getProperty(locatorKey));
        }
        if (locatorKey.endsWith("_className")) {
            return (By.className(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_xpath")) {
            return (By.xpath(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_css")) {
            return (By.cssSelector(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_linkText")) {
            return (By.linkText(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_partialLinkText")) {
            return (By.partialLinkText(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_tagName")) {
            return (By.tagName(prop.getProperty(locatorKey)));
        }
		return null;
	}
	
}
