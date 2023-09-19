package POM;

import Base.BaseUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BaseUI{
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	By username=getlocator("username_name");
	By password=getlocator("password_name");
	By submit=getlocator("submit_id");
	//elements as methods
	public void userName(String user) {
		sendtext(username, user);
	}
	public void passWord(String pass) {
		sendtext(password, pass);
	}
	public void submit() {
		clickOn(submit);

	}
			
}
