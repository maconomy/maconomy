package webclient.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import webclient.utilities.Data;

public class LoginPage extends BasePage{
	public Data data = new Data();
	public LoginPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		super(webDriver);
	}

	//find elements
	public By usernameLabel = By.xpath("//label[@for='username']");
	public By passwordLabel = By.xpath("//label[@for='password']");
	public By forgotYourPasswordLink = By.xpath("//a[@for='password']");
	public By usernameTextBox = By.id("username");
	public By passwordTextBox = By.id("password");
	public By loginButton = By.id("login");
	
	public void login() {
		setText(usernameTextBox, data.username);
		System.out.println("set username: " + data.username);
		setText(passwordTextBox, data.password);
		System.out.println("set password: " + data.password);
		click(loginButton);
		System.out.println("clicked login button");
		
	}

	
	public void clickForgotYourPassword() {
		click(forgotYourPasswordLink);
	}
	
	public void changeLanguageTo(String newLanguage) {
	
	}
	
	
}
