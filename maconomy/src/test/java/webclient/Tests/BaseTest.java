package webclient.Tests;

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
		//creation of object web driver
		
		String browser;
		browser = System.getProperty("Browser");
		if (System.getProperty("Browser") == "Chrome") {
			
			System.setProperty("webdriver.chrome.driver", "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/chromedriver107/chromedriver.exe");
			webDriver = new ChromeDriver();
			
		} else if (System.getProperty("Browser") == "Firefox") {
			System.setProperty("webdriver.geckodriver.driver", "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/geckodriver-v0.31.0-win64/geckodriver.exe");
			
			webDriver = new FirefoxDriver();
				
		} else if (System.getProperty("Browser") == "Edge") {
			System.out.println("nothing is setup yet for edge");
		}
		
		String URL;
		//URL = "http://10.4.8.157:20019";
		URL = System.getProperty("WebClientURL");
		
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
