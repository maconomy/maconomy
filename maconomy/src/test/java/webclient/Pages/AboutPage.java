package webclient.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage extends BasePage {

	// constructor setup object webdriver for the about page
	public AboutPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		super(webDriver);
	}

	// elements or page objects
	By title = By.xpath("");
	By revisionLabel = By.xpath("");
	By revisionValue = By.xpath("");

	By copyrightLabel = By.xpath("//li[2][text()]");

	//methods
	
	public void verifyCopyrightContains(String text) {
		verifyTextContains(copyrightLabel, text);
	}
}
