package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.WarrantyPage;

public class WarrantyTest extends TestBase {
	
	@BeforeMethod
	public void setUpMethod2() {
		
		WarrantyPage wp = new WarrantyPage();		
		actions.moveToElement(wp.moreMenuLink).click().moveToElement(wp.warrantyLink).click().build().perform();		
	}
	
	@Test
	public void test1() {
		
	}

}
