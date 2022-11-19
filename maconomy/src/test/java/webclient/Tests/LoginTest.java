package webclient.Tests;

import org.testng.annotations.Test;

import webclient.Pages.LoginPage;
import webclient.Pages.MainPage;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void successfulLogin() {
		LoginPage loginPage = new LoginPage(webDriver);
		MainPage mainPage = new MainPage(webDriver);
		
		loginPage.login();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainPage.openMenu();
		mainPage.closeMenu();

	}
	
	@Test(priority = 2)
	public void verifyLoginPage() {
		LoginPage loginPage = new LoginPage(webDriver);
		
		loginPage.verifyTextContains(loginPage.usernameLabel, "user");
	}
}

