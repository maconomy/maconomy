package archive.version1.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	//this declaration will allow this driver to be used on pages that will extend this BaseTest class, but eventually we will not be calling webdrivers in our test pages, instead only methods from respective pages
	public WebDriver webDriver;
	
	@BeforeClass (description = "creation of web driver object")
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/chromedriver107/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/geckodriver-v0.31.0-win64/geckodriver.exe");
		
		//creation of object chromedriver
		webDriver = new ChromeDriver();
		//webDriver = new FirefoxDriver();
		
		String URL;
		URL = "http://10.4.8.157:20019"; //System.getProperty("WebClientURL");
		if (URL == null) {
			System.out.println("no URL fetched from jenkins.");
		}
		
		//http://10.4.8.157:20019
		webDriver.get(URL);
		System.out.println("Launched URL: " + URL);
	}
	
	@AfterClass
	public void AfterClass() {
		webDriver.close();
	}
}
