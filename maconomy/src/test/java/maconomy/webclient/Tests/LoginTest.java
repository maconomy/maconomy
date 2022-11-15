package maconomy.webclient.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	@Test (priority = 1)
	public void successfulLogin() {
		String URL = null;
		URL = System.getProperty("WebClientURL");
		if (URL == null) {
			URL = "http://10.4.8.157:20019";
		}
		//System.out.println("from jenkins: " + System.getProperty("WebClientURL"));
		//http://10.4.8.157:20019
		webDriver.get(URL);
		
		WebElement userNameTextBox = webDriver.findElement(By.id("username"));
		userNameTextBox.sendKeys(System.getProperty("Username"));
		WebElement passwordTextBox = webDriver.findElement(By.id("password"));
		passwordTextBox.sendKeys(System.getProperty("Password"));
		WebElement loginButton = webDriver.findElement(By.id("login"));
		loginButton.click();
	}
}
