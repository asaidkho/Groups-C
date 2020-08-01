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
		
		wp.suvButton.click();
		BrowserUtilities.waitFor(1);
		sa.assertEquals(wp.estimateMin.getText(), "1,779");
		
		wp.truckButton.click();
		BrowserUtilities.waitFor(1);
		sa.assertEquals(wp.estimateMin.getText(), "1,449");
		
		wp.sedanButton.click();
		BrowserUtilities.waitFor(1);
		sa.assertEquals(wp.estimateMin.getText(), "1,329");
		
		sa.assertAll();
	}

}
