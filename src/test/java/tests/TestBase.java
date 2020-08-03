package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
//import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.BrowserUtilities;
import utilities.ConfigReader;
import utilities.Driver;

public abstract class TestBase {

	protected WebDriver driver;
	protected Actions actions;

	protected static ExtentReports reporter;
	protected static ExtentSparkReporter htmlReporter;
	protected static ExtentTest logger;

	@BeforeSuite(alwaysRun = true)
	public void setUpSuite() {

		reporter = new ExtentReports();
		htmlReporter = new ExtentSparkReporter("test-output/ExtentReports/index.html");
		reporter.attachReporter(htmlReporter);

		htmlReporter.config().setReportName(ConfigReader.getProperty("testReportName"));

		reporter.setSystemInfo("groupName", ConfigReader.getProperty("groupName"));
		reporter.setSystemInfo("ENV", ConfigReader.getProperty("environment"));
		reporter.setSystemInfo("OS", System.getProperty("os.name"));
		reporter.setSystemInfo("browser", ConfigReader.getProperty("browser"));



	}

	@BeforeMethod(alwaysRun = true)
	@Parameters ("browser")
	public void setUpMethod(@Optional String browser) {

		driver = Driver.getDriver(browser);
		actions = new Actions(driver);



		driver.get(ConfigReader.getProperty("url"));
		deleteBadCookies();	

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(
				ConfigReader.getProperty("implicitwait")), TimeUnit.SECONDS);


		driver.manage().window().maximize();


	}



	@AfterMethod(alwaysRun = true)
	public void tearDownMethod(ITestResult testResult) throws IOException {

		if (testResult.isSuccess()) {
			logger.pass("PASSED: " + testResult.getName());
		} else if(testResult.getStatus() == ITestResult.SKIP) {
			logger.skip("SKIPPED: " + testResult.getName());
			logger.skip(testResult.getThrowable());
		} else if(testResult.getStatus() == ITestResult.FAILURE) {			
			logger.fail("FAILED: " + testResult.getName());
			logger.fail(testResult.getThrowable());

			String path = BrowserUtilities.getScreenshot(testResult.getName());
			logger.addScreenCaptureFromPath(path);
		}


		Driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDownSuite() {
		reporter.flush();
	}
	
	public void deleteBadCookies() {
		driver = Driver.getDriver();
		driver.manage().deleteCookieNamed("ai_user");
		driver.manage().deleteCookieNamed("ai_session");		
		driver.manage().deleteCookieNamed("ak_bmsc");
	}


}

