package webclient.utilities;

public class Data {
	//From Jenkins params
	public String URL = System.getProperty("WebClientURl");
	//URL = "https://www.google.com"; //"http://10.4.8.157:20019";
	public String username = System.getProperty("Username");
	public String password = System.getProperty("Password");
	public String browser = System.getProperty("Browser"); //"Edge"; 
	//Email result credentials
	public String emailAddress = System.getProperty("EmailAddress");
	public String emailAddressPassword = System.getProperty("emailAddressPassword");
	
	//direct drivers for certifications of specific browser versions
	public String chromeDriverLocation = "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/chromedriver107/chromedriver.exe";
	public String firefoxDriverLocation = "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/geckodriver-v0.31.0-win64/geckodriver.exe";
	public String edgeDriverLocation = "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/edgedriver_win32/msedgedriver.exe";
	
	//Test Result Index.html
	public String testReportHTML = "C:/Users/AlexanderReyes/git/maconomy/maconomy/TestReport.html";
}
