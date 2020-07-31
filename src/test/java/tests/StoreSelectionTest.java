package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SellPage;
import pages.StorePage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class StoreSelectionTest extends TestBase {

	@BeforeMethod
	public void setUpMethod2() {
		
		SellPage sp = new SellPage();
		sp.sellLink.click();
		//BrowserUtilities.waitFor(2);
		Driver.getDriver().manage().deleteAllCookies();		
		sp.changeStoreLink.click();
		
	}
	
	//@Test
	public void inStorePickPageTest() {
		assertTrue(Driver.getDriver().getCurrentUrl().equals("https://www.carmax.com/stores"));
	}
	
	@Test
	public void numberOfStoresTest() {
		SellPage sp = new SellPage();		
		
		logger = reporter.createTest("Testing number of stores");
		StorePage stp = new StorePage();
		int totalStoreCount = 0;
		for (int i = 0; i < stp.states.size(); i++) {
			int countByState = Integer.parseInt(stp.countByState.get(i).getText().replaceAll("\\D", ""));
			stp.states.get(0).click();
			for (int j = 0; j < stp.cities.size(); j++) {
				int countByCity = Integer.parseInt(stp.countByCity.get(j).getText().replaceAll("\\D", ""));
				totalStoreCount += countByCity;
			} 
		}
		System.out.println(totalStoreCount);
	}
}
