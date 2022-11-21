package webclient.utilities;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class TestReport implements IReporter {

	public void generateReport (List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for (ISuite suite : suites) {
			
			String suiteName = suite.getName();
			
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult suiteResult : suiteResults.values()) {
				ITestContext testContext = suiteResult.getTestContext();
				System.out.println("Passed Tests for suite '" + suiteName + "' is: " + testContext.getPassedTests().getAllResults().size());
				System.out.println("Failed Tests for suite '" + suiteName + "' is: " + testContext.getFailedTests().getAllResults().size());
				System.out.println("Skipped Tests for suite '" + suiteName + "' is: " + testContext.getSkippedTests().getAllResults().size());
				System.out.println("getclass: " + suite.getHost() + "Start Date: " + testContext.getStartDate() + "End Date: " + testContext.getEndDate()+ " getname: " + testContext.getName());
				
				
				
			}
		}
	}
}
