package webclient.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		super(webDriver);
	}

	//jenkin variables
	public String username = System.getProperty("Username");
	public String password = System.getProperty("Password");
	//find elements
	public By usernameLabel = By.xpath("//label[@for='username']");
	public By passwordLabel = By.xpath("//label[@for='password']");
	public By forgotYourPasswordLink = By.xpath("//a[@for='password']");
	public By usernameTextBox = By.id("username");
	public By passwordTextBox = By.id("password");
	public By loginButton = By.id("login");
	
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
