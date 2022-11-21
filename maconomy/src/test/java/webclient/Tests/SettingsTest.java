package webclient.Tests;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import webclient.Pages.AboutPage;
import webclient.Pages.LoginPage;
import webclient.Pages.MainPage;

public class SettingsTest extends BaseTest {
	
	@Test (description = "Verify About Page")
	public void verifyAboutPage() throws Exception {
		LoginPage loginPage = new LoginPage(webDriver);
		AboutPage aboutPage = new AboutPage(webDriver);
		MainPage mainPage = new MainPage(webDriver);
		loginPage.login();
		//Thread.sleep(1000);
		//mainPage.clickSettings();
		mainPage.openAboutDialog();
		aboutPage.verifyCopyrightContains("Copyright© 2022 Deltek, Inc. Visit Deltek at www.deltek.com");
		Assert.assertTrue(true);
		
	}

}
