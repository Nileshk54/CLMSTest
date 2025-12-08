package listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseTest.BaseTest;

public class TestNGListener extends BaseTest implements ITestListener {

	private org.apache.logging.log4j.Logger log = LogManager.getLogger(TestNGListener.class);

	public void onTestStart(ITestResult result) {
		log.debug(" ******** " + result.getName() + " Listener Started " + " ******** ");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.debug(" ******** " + result.getName() + " Listener Success " + " ******** ");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.debug(" ******** " + result.getName() + " Listener Failed " + " ******** ");
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
		String filePath = "D:\\Git\\CLMSTest\\CLMSTest\\ScreenShots\\" + result.getName() + "_" + timeStamp +".png";
		System.out.println(filePath);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.debug(" ******** " + result.getName() + " Listener Skipped " + " ******** ");
	}

}
