package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import webclient.Pages.BasePage;

public class TestListenerStatus extends TestUtils implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case is starting");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getMethod().getMethodName());
		try {
			System.out.println("Taking Screenshot");
			getScreenshot();
			System.out.println("Screenshot taken for failed step");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void onSkip(ITestResult result) {
		System.out.println("Test Skipped: " + result.getMethod().getMethodName());
	}
}
