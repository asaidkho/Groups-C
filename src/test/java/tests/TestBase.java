package tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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
	
	public static void deleteBadCookies() {
		
		Driver.getDriver().manage().deleteCookieNamed("ai_user");
		Driver.getDriver().manage().deleteCookieNamed("ai_session");		
		Driver.getDriver().manage().deleteCookieNamed("ak_bmsc");
		
		try {
			
			File file = new File("Cookies.data");
			file.createNewFile();
			BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file));
			
			List<String> goodCookies = Arrays.asList("bm_sv", "_abck", "RT",	"s_visit", "bm_mi", "KmxStore", 
					"_gat_6144a510cabc4cd086ae55f1e2df5ad8", "KmxAuthSession", "bm_sz", "mbox", 
					"KmxCurrSession_0", "QSI_HistorySession", "_uetvid", "fs_uid", "AKA_A2", "_uetsid", 
					"s_cc", "_fbp", "at_check", "AMCV_0C1038B35278345B0A490D4C%40AdobeOrg", 
					"s_sq", "KmxMyKmx_0", "KmxVisitor_0", "s_ppv", "s_ppvl", "_gid", "adobeTransID", 
					"gpv_v4", "KmxSession_0", "_ga", "_gcl_au", "AMCVS_0C1038B35278345B0A490D4C%40AdobeOrg");
			
			
			for (Cookie ck: Driver.getDriver().manage().getCookies()) {
				if (!goodCookies.contains(ck.getName())) {
					bufWriter.write(ck.getName() + " -- " + ck.getValue());
					bufWriter.newLine();
					System.out.print("\"" + ck.getName() + "\", ");
					System.out.println("");
				}
			}
			bufWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}

