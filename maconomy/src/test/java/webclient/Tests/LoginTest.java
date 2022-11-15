package webclient.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

	@Test (priority = 1)
	public void successfulLogin() {
		String URL = null;
		URL = System.getProperty("WebClientURL");
		if (URL == null) {
			URL = "https://www.google.com"; //"http://10.4.8.157:20019";
		}
		String userName = System.getProperty("Username");
		String password = System.getProperty("Password");
		
		//http://10.4.8.157:20019
		webDriver.get(URL);
		System.out.println("Launched URL: " + URL);
		/*
		 * try { Thread.sleep(20); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		WebElement userNameTextBox = webDriver.findElement(By.id("username"));
		userNameTextBox.sendKeys(userName);
		System.out.println("set username: " + userName);
		WebElement passwordTextBox = webDriver.findElement(By.id("password"));
		passwordTextBox.sendKeys(password);
		System.out.println("set password: " + password);
		WebElement loginButton = webDriver.findElement(By.id("login"));
		loginButton.click();
		System.out.println("clicked login button");
	}
}
