package webclient.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		super(webDriver);
	}

	//jenkin variables
	String username = "Administrator"; //System.getProperty("Username");
	String password = "123456"; //System.getProperty("Password");
	//find elements
	By usernameLabel = By.xpath("//label[@for='username']");
	By passwordLabel = By.xpath("//label[@for='password']");
	By forgotYourPasswordLink = By.xpath("//a[@for='password']");
	By usernameTextBox = By.id("username");
	By passwordTextBox = By.id("password");
	By loginButton = By.id("login");
	
	public void login() {
		setText(usernameTextBox, username);
		System.out.println("set username: " + username);
		setText(passwordTextBox, password);
		System.out.println("set password: " + password);
		click(loginButton);
		System.out.println("clicked login button");
		
	}

	
	public void clickForgotYourPassword() {
		click(forgotYourPasswordLink);
	}
	
	public void changeLanguageTo(String newLanguage) {
	
	}
	
	
}
