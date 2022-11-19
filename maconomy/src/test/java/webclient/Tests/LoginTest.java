package webclient.Tests;

import static org.testng.Assert.fail;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.annotations.Test;

import webclient.Pages.LoginPage;
import webclient.Pages.MainPage;

public class LoginTest extends BaseTest {

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
		System.out.println("2nd successful run " + Thread.currentThread().getId());
	}
	
	@Test(priority = 1)
	public void verifyLoginPage() throws Exception {
		System.out.println("Start verifying login page");
		LoginPage loginPage = new LoginPage(webDriver);
		
		loginPage.verifyTextContains(loginPage.usernameLabel, "User");
		System.out.println("1st successful run " + Thread.currentThread().getId());
	}
	

}

