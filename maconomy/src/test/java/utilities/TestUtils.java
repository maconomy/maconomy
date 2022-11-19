package utilities;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import webclient.Tests.BaseTest;

public class TestUtils extends BaseTest {

	public void getScreenshot() throws Exception {
		
		LocalDateTime currentLocalDateTime = LocalDateTime.now();
		String formatCurrentLocalDateTime = currentLocalDateTime.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + "screenshot" + formatCurrentLocalDateTime + ".png"));
		
	}


}
