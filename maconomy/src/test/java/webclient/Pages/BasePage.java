package webclient.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public String getText(By ElementBy) {
		waitVisibility(ElementBy);
		return webDriver.findElement(ElementBy).getText();
		
	}
	
}
