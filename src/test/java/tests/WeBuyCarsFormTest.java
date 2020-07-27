package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SellPage;

public class WeBuyCarsFormTest extends TestBase {
	
	@BeforeMethod
	public void setUpMethodSellPage() {
		SellPage sp = new SellPage();
		sp.sellLink.click();
	}
	
	@Test
	public void submitFormTest() {
		logger = reporter.createTest("Submit Form for We Buy Cars");
		
		SellPage sp = new SellPage();
		
		sp.yearInput.sendKeys("2018");
		
	}

}
