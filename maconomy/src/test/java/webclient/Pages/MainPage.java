package webclient.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

	public MainPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	//elements
	By menuButton = By.xpath("//a[contains(@dm-data-id,'menu-link')]");
	By sideBar = By.xpath("//dm-tree");
	By settingsButton = By.xpath("//a[@title='Settings']");
	By settingsAboutButton = By.xpath("//a[@dm-data-id='dm-about-iaccess-link']");
	By settingsChangePasswordButton = By.xpath("//a[@dm-data-id='dm-change-password-link']");
	By settingsMySettingsButton = By.xpath("//a[@dm-data-id='dm-my-settings-link']");
	
	//methods
	
	public void openMenu() {
		
		if (checkIfElementExists(menuButton) == true) {
			System.out.println("Menu already open");
		} else {
			click(menuButton);
			System.out.println("Open Menu");
			
		}
	}
	
	public void closeMenu() {
		if (checkIfElementExists(menuButton) == true) {
			click(menuButton);
			System.out.println("Closed Menu");
		} else {
			System.out.println("Menu already closed");
			
		}
	}
	
	public void clickSettings() {
		click(settingsButton);
	}
	
	public void openAboutDialog() {
		clickSettings();
		click(settingsAboutButton);
	}


}
