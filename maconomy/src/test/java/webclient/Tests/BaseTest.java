package webclient.Tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import webclient.utilities.Data;

public class BaseTest {
	// this declaration will allow this driver to be used on pages that will extend
	// this BaseTest class, but eventually we will not be calling webdrivers in our
	// test pages, instead only methods from respective pages
	public Data data = new Data();
	public static WebDriver webDriver;
	

	public int indexSI = 0;
	
	@BeforeMethod (description = "Creation of web driver object")
	public void BeforeClass() {
		System.out.println("from jenkins::::::" + data.browser + data.URL + data.chromeDriverLocation);
		// creation of object web driver

		switch (data.browser) {
		case "Chrome":
			System.out.println("Selected Chrome Browser...");
			System.setProperty("webdriver.chrome.driver", data.chromeDriverLocation);
			webDriver = new ChromeDriver();
			System.out.println("Instantiated Chrome driver...");
			
			break;

		case "Firefox":
			System.out.println("Selected Firefox Browser...");
			System.setProperty("webdriver.gecko.driver", data.firefoxDriverLocation);
			webDriver = new FirefoxDriver();
			System.out.println("Instantiated Firefox driver...");
			
		case "Edge":
			System.out.println("Selected Edge Browser...");
			System.setProperty("webdriver.edge.driver", data.edgeDriverLocation);
			webDriver = new EdgeDriver();
			System.out.println("Instantiated Edge driver...");
			
		default:
			System.out.println("Browser driver instantiation Failed");
			break;
		}
		/*
		 * try { if (System.getProperty("Browser") == "Chrome") {
		 * System.out.println("Selected Chrome Browser...");
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:/Users/AlexanderReyes/git/maconomy/maconomy/src/test/java/maconomy/maconomy/Utilities/Drivers/chromedriver107/chromedriver.exe"
		 * ); webDriver = new ChromeDriver();
		 * 
		 * } else if (data.browser == "Firefox") {
		 * System.out.println("Selected Firefox Browser...");
		 * System.setProperty("webdriver.gecko.driver", data.firefoxDriverLocation);
		 * webDriver = new FirefoxDriver();
		 * 
		 * } else if (data.browser == "Edge") {
		 * System.out.println("Selected Edge Browser...");
		 * System.setProperty("webdriver.edge.driver", data.edgeDriverLocation);
		 * webDriver = new EdgeDriver(); }
		 * System.out.println("successful browser declaration"); } catch (Exception e) {
		 * e.printStackTrace();
		 * 
		 * }
		 */

		try {

			webDriver.get(data.URL);
			System.out.println("Successful Launched URL: " + data.URL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Unable to launch URL");
		}

	}

	/*
	 * @BeforeTest public void beforeTest() {
	 * System.out.println("-----Before Test-----"); }
	 */

	/*
	 * @AfterClass public void AfterClass() throws Exception {
	 * 
	 * }
	 */

	@AfterMethod(alwaysRun = true)
	public void afterTest(ITestResult testResult) throws Exception {
		webDriver.close();
		System.out.println("Closed Browser");
		System.out.println("-----starting after test-----");
		indexSI++;
		System.out.println("index number: " + indexSI);
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			updateResult(testResult.getTestClass().getName(), indexSI, testResult.getName(), "Passed");
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			updateResult(testResult.getTestClass().getName(), indexSI, testResult.getName(), "Failed");
		} else {
			updateResult(testResult.getTestClass().getName(), indexSI, testResult.getName(), "Others");
		}
		//emailTestReport();
	}
	
	//For creation and update of TestReport.html
	public void updateResult(String className, int index, String methodName, String testStatus) throws Exception {
		LocalDateTime currentLocalDateTime = LocalDateTime.now();

		String resultFile = data.testReportHTML;

		File file = new File(resultFile);
		System.out.println(file.exists());
		// only if TestReport.html does not exist will then if condition will run, else
		// will not.
		if (file.exists() == false) {
			System.out.println("creating index.html...");
			// file.createNewFile();
			System.out.println(file.getName());
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			bufferWriter.write("<html>" + "\n");
			bufferWriter.write("<head><title>" + "Test Execution Report" + "</title></head>" + "\n");
			bufferWriter.write("<body>");
			bufferWriter.write("<h1 align='center'> Test Execution Report </h1>");
			bufferWriter.flush();
			bufferWriter.close();
		}

		BufferedWriter bufferWriter1 = new BufferedWriter(new FileWriter(file, true));
		// Create table
		if (indexSI == 1) {
			// SPACING
			bufferWriter1.write("<table align='center' border='0' width='70%' height='10'>");
			bufferWriter1.write("<tr><td width='70%'></td></tr>");
			bufferWriter1.write("<table align='center' border='1' width='70%' height='47'>");
			// TABLE COLUMN HEADERS
			bufferWriter1.write("<tr>");
			bufferWriter1.write("<td colspan='1' align='center'> <b> Script Name: " + "Script Name" + "</b> </td>");
			bufferWriter1
					.write("<td colspan='1' align='center'> <b> Start Time: " + currentLocalDateTime + "</b> </td>");
			bufferWriter1.write("</tr>");
			// TABLE COLUMN DETAIL
			bufferWriter1.write("<tr>");
			bufferWriter1.write("<td align='center'><b>" + "No." + "</b></td>");
			bufferWriter1.write("<td align='center'><b>" + "Class Name" + "</b></td>");
			bufferWriter1.write("<td align='center'><b>" + "Test Name" + "</b></td>");
			bufferWriter1.write("<td align='center'><b>" + "Test Status" + "</b></td>");
			bufferWriter1.write("</tr>");
		}

		// append result details
		bufferWriter1.write("<tr>");
		bufferWriter1.write("<td align='center'><b>" + index + "</b></td>");
		bufferWriter1.write("<td align='center'><b>" + className + "</b></td>");
		bufferWriter1.write("<td align='center'><b>" + methodName + "</b></td>");
		bufferWriter1.write("<td align='center'><b>" + testStatus + "</b></td>");
		bufferWriter1.write("</tr>");
		bufferWriter1.write("</body></html>");
		bufferWriter1.flush();
		bufferWriter1.close();
	}

	public void emailTestReport() throws EmailException {

		// attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(data.testReportHTML);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of John");
		attachment.setName("John");

		// create email
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(data.emailAddress, data.emailAddressPassword));
		email.setSSLOnConnect(true);
		email.setFrom("alexanderreyes@deltek.com");
		email.setSubject("Daily Test Result");
		email.setMsg("Kindly see test result attachment");
		email.addTo("alexanderreyes@deltek.com");
		email.send();
	}
}
