package tests;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {
	
	
	static ExtentReports reporter;
	static ExtentSparkReporter htmlReporter;
	static ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		reporter = new ExtentReports();
		htmlReporter = new ExtentSparkReporter("test-output/ExtentReports/index.html");
		reporter.attachReporter(htmlReporter);
		
		
	}
	
	@Test
	public void test1() {
		
	}
	

}

