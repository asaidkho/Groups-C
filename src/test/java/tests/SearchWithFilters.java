package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.SearchFiltersPage;

public class SearchWithFilters extends TestBase {

	@Test
	public void SearchByMakeResultTest() {
		logger = reporter.createTest("Search by Make from given Filters Menu");
		MainPage mp = new MainPage();

		logger.info("Clicking on search button");
		mp.searchButton.click();

		logger.info("Clicking on Make button from Filters");
		SearchFiltersPage sp = new SearchFiltersPage();
		sp.make.click();

		logger.info("Clicking on Audi button from Make");
		sp.Audi.click();

		logger.info("Verify matches of choosen Make");
		assertEquals(sp.Audi.getText(), "281");
		assertEquals(driver.findElement(By.xpath("//*[@id='number-of-matches']/span[2]")).getText(), "281");

	}
	@Test 
	public void sumOfResultsTest() {
	
}
	
	@Test 
	public void SortByNewestYearTest() {
	
		
		
}
	
	
	
	
	@Test 
	public void facebookLinkTest() {
	
		
		
}
	
	
	
	@Test 
	public void sorByHighestMilageTest() {
	
}
	@Test 
	public void sortByHighestPriceTets() {
	
}
	
	@Test
	
	public void productPageTest() {
	}
}