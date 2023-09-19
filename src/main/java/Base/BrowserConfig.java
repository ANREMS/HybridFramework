package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserConfig {

	static WebDriver driver;
	
	public static WebDriver getchromeBrowser() {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Anna Automation\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}
	//firefox
	//edge
}
