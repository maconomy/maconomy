package webclient.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
	//this declaration will allow this driver to be used on pages that will extend this BaseTest class, but eventually we will not be calling webdrivers in our test pages, instead only methods from respective pages
	public static WebDriver webDriver;
	
	@BeforeMethod (description = "creation of web driver object")
	public void BeforeClass() {
		//creation of object web driver
		try {
			String browser = "Firefox"; //System.getProperty("Browser");
			if (browser == "Chrome") {
				
				System.setProperty("webdriver.chrome.driver", "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/chromedriver107/chromedriver.exe");
				webDriver = new ChromeDriver();
				
			} else if (browser == "Firefox") {
				System.setProperty("webdriver.gecko.driver", "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/geckodriver-v0.31.0-win64/geckodriver.exe");
				
				webDriver = new FirefoxDriver();
					
			} else if (browser == "Edge") {
				System.out.println("nothing is setup yet for edge");
			}
			System.out.println("successful browser declaration");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unsuccessful browser declaration");
		}
		
		
		try {
			String URL;
			URL = "http://10.4.8.157:20019";
			//URL = System.getProperty("WebClientURL");
						
			webDriver.get(URL);
			System.out.println("Successful Launched URL: " + URL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Unable to launch URL");
		}
		
		
	}
	
	@AfterMethod
	public void AfterClass() {
		
		webDriver.close();
		System.out.println("Closed Browser");
	}
	
	@AfterTest
	public void generateReport() {
		
	}
}
