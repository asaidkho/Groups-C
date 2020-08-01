package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.WarrantyPage;
import utilities.BrowserUtilities;

public class WarrantyTest extends TestBase {
	
	@BeforeMethod
	public void setUpMethod2() {
		
		WarrantyPage wp = new WarrantyPage();		
		actions.moveToElement(wp.moreMenuLink).click().moveToElement(wp.warrantyLink).click().build().perform();		
	}
	
	@Test
	public void test1() {
		logger = reporter.createTest("Testing Warranty Calculator");
		
		WarrantyPage wp = new WarrantyPage();
		SoftAssert sa = new SoftAssert();
		
		logger.info("Clicking on SUV button");
		wp.suvButton.click();
		BrowserUtilities.waitFor(1);
		logger.info("Validating that the amount changes to the corrent one");
		sa.assertEquals(wp.estimateMin.getText(), "1,779");
		
		logger.info("Clicking on Truck button");
		wp.truckButton.click();
		BrowserUtilities.waitFor(1);
		logger.info("Validating that the amount changes to the corrent one");
		sa.assertEquals(wp.estimateMin.getText(), "1,449");
		
		logger.info("Clicking on Sedan button");
		wp.sedanButton.click();
		BrowserUtilities.waitFor(1);
		logger.info("Validating that the amount changes to the corrent one");
		sa.assertEquals(wp.estimateMin.getText(), "1,329");
		
		logger.info("Applying assert all for soft assertions");
		sa.assertAll();
	}

}
