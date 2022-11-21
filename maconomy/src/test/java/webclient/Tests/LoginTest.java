package webclient.Tests;

import static org.testng.Assert.fail;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.annotations.Test;

import webclient.Pages.LoginPage;
import webclient.Pages.MainPage;
import webclient.utilities.Data;

public class LoginTest extends BaseTest {

	Data data = new Data();
	
	@Test(priority = 2)
	public void successfulLogin() throws Exception {
		LoginPage loginPage = new LoginPage(webDriver);
		MainPage mainPage = new MainPage(webDriver);
		
		loginPage.login();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainPage.openMenu();
		mainPage.closeMenu();
		successRun();
	}
	
	@Test(priority = 1)
	public void verifyLoginPage() throws Exception {
		System.out.println("Start verifying login page");
		LoginPage loginPage = new LoginPage(webDriver);
		
		loginPage.verifyTextContains(loginPage.usernameLabel, data.usernameLabel);
		loginPage.verifyExists(loginPage.usernameTextBox);
		loginPage.verifyTextContains(loginPage.passwordLabel, data.passwordLabel);
		loginPage.verifyExists(loginPage.passwordTextBox);
		loginPage.verifyExists(loginPage.loginButton);
		successRun();
	}
	
	//successful message
	public void successRun() {
		System.out.println("Successful run: " + Thread.currentThread().getStackTrace()[2].getMethodName());
	}
}

