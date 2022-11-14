package maconomy.webclient.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

	@Test (priority = 1)
	public void successfulLogin() {
		System.getProperty("webdriver.chrome.driver", "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/chrome106/chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		
		webDriver.get("http://10.4.8.157:20019");
		
		webDriver.close();
	}
}
