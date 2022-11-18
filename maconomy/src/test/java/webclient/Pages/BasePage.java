package webclient.Pages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	public WebDriver webDriver;
	public WebDriverWait webDriverWait;
	
	public BasePage(WebDriver newWebDriver) {
		// TODO Auto-generated constructor stub
		this.webDriver = newWebDriver;
		webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
	}
	
	public void waitVisibility(By elementBy) {
		webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}
	
	public void click(By elementBy) {
		waitVisibility(elementBy);
		webDriver.findElement(elementBy).click();		
	}
	
	public void setText(By elementBy, String text) {
		waitVisibility(elementBy);
		webDriver.findElement(elementBy).sendKeys(text);
	}
	
	public String getText(By elementBy) {
		waitVisibility(elementBy);
		return webDriver.findElement(elementBy).getText();
		
	}
	
	public void verifyExists(By elementBy) {
		
	}
	
	public void verifyTextContains(By elementBy, String text) {
		waitVisibility(elementBy);
		if (getText(elementBy).contains(text) == true) {
			System.out.println("Match found");
		} else {
			System.out.println("Match not found");
			Assert.assertFalse(true);
		}
		
	}
	
	public boolean checkIfElementExists(By ElementBy) {
		waitVisibility(ElementBy);
		if (webDriver.findElement(ElementBy) == null) {
			return false;
		} else {
			return true;
		}
		
	}
}
 