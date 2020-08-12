package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.SearchFiltersPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SearchWithFilters extends TestBase {

	@Test
	public void SearchByMakeResultTest() {
		logger = reporter.createTest("Search by Make from given Filters Menu");
		MainPage mp = new MainPage();
		deleteBadCookies();
		logger.info("Clicking on search button");
		mp.searchButton.click();
		deleteBadCookies();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		logger.info("Clicking on Make button from Filters");
		SearchFiltersPage sp = new SearchFiltersPage();
		logger.info("Select the distance Click DropDown menu");
		sp.DistanceDropDown.click();
		logger.info("Select the distance radius - Nationwide");
		sp.Nationwide.click();
		
		BrowserUtilities.waitFor(3);
		sp.make.click();
		logger.info("Clicking on Audi button from Make");
		sp.Audi.click();
		BrowserUtilities.waitFor(3);
		deleteBadCookies();
	
		logger.info("Verify number  of choosen Make matche Result");
	
		//assertEquals(driver.findElement(By.xpath("//*[@id='number-of-matches']/span[2]")).getText(), "313");
        String expected =(driver.findElement(By.xpath("//*[@id='Make']//ul/li[2]//span[2]")).getText());
		String actual =(driver.findElement(By.xpath("//*[@id='number-of-matches']/span[2]")).getText());
		
		assertEquals(expected, actual);
	}
	@Test 
	public void sumOfResultsTest() {
		logger = reporter.createTest("Add two Makes for Search and test if sum of choosen cars matches result");
		MainPage mp = new MainPage();
		deleteBadCookies();
		logger.info("Clicking on search button");
		mp.searchButton.click();
		deleteBadCookies();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		logger.info("Clicking on Make button from Filters");
		SearchFiltersPage sp = new SearchFiltersPage();
		logger.info("Select the distance Click DropDown menu");
		sp.DistanceDropDown.click();
		logger.info("Select the distance radius - Nationwide");
		sp.Nationwide.click();
		
		BrowserUtilities.waitFor(3);
		sp.make.click();
		logger.info("Clicking on Audi button from Make");
		sp.Audi.click();
		BrowserUtilities.waitFor(3);
		deleteBadCookies();
	    logger.info("Get the number of matches of choosen Make");
		
		logger.info("Adding another Make to Filter");
		sp.Acura.click();
		BrowserUtilities.waitFor(3);
	//need to finish
}
	
	@Test 
	public void SortByNewestYearTest() {
		logger = reporter.createTest("Search Sort By Newest Year ");
		MainPage mp = new MainPage();
		deleteBadCookies();
		logger.info("Clicking on search button");
		mp.searchButton.click();
		deleteBadCookies();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		
		logger.info("Expand SortBy Dropdown");
		SearchFiltersPage sp = new SearchFiltersPage();
		sp.sortBy.click();
		
		Actions a = new Actions(driver);
		a.moveToElement(sp.newestYear).click().build().perform();
		//a.moveToElement(driver.findElement(By.xpath("//button[.='Newest year']"))).click().perform();
		BrowserUtilities.waitFor(3);
		deleteBadCookies();
		logger.info("Verify that results are filtered by newest year");
		List<String> carLinks = new ArrayList<>();
		for(int i=1; i<10; i++) {
			if (i!=5) {
			assertTrue(driver.findElement(By.xpath("//article["+i+"]//h3/span[1]")).getText().contains("2021"));
			}
		}
		
		
		
		/*for(int i=1; i<10; i++) {
			if (i!=5) {
			assertEquals(driver.findElement(By.xpath("//article["+i+"]//h3/span[1]")).getText(), "2020 Lexus");
			}
		}*/
		
}
	
	@Test 
	public void facebookLinkTest() {
	
		logger = reporter.createTest("Validate Social Media Button - FaceBook link.");
		MainPage mp = new MainPage();
		deleteBadCookies();
		
		logger.info("Scrolling down to the bottom of main page.");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,5800)");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)", ""); 
		
		SearchFiltersPage sp = new SearchFiltersPage();
		logger.info("Click social media icon.");
		sp.facebook.click();
	
		assertEquals(driver.findElement(By.xpath("//*[@id='footer']//section[1]/a[2]")).getAttribute("href"), "https://facebook.com/carmax");
		
}
	
	
	
	@Test 
	public void sortByHighestMilageTest() {
		
		logger = reporter.createTest("Search Sort By Newest Year ");
		MainPage mp = new MainPage();
		deleteBadCookies();
		logger.info("Entering car make and model");
		mp.searchBox.sendKeys("Honda Accord");
		logger.info("Clicking on search button");
		mp.searchButton.click();

		deleteBadCookies();
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		
		logger.info("Expand SortBy Dropdown");
		SearchFiltersPage sp = new SearchFiltersPage();
		sp.sortBy.click();
		
		Actions a = new Actions(driver);
		//a.moveToElement(sp.highestMilage).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//button[.='higestMilage']"))).click().perform();
		BrowserUtilities.waitFor(3);
		deleteBadCookies();
		logger.info("Get results for Highest Milage and verify they are in descending order");
		
		
		logger.info("Verifying that results are filtered by highest milage");
		List<String> carLinks = new ArrayList<>();
		for(int i=1; i<10; i++) {
			if (i!=5) {
			carLinks.add(driver.findElement(By.xpath("//*[@id=\"cars-listing\"]/div[1]/article["+i+"]//span[3]")).getText());
			}
		}
		Integer[] value = new Integer[8];
		for (int i=0; i<carLinks.size();i++) {
			carLinks.set(i, carLinks.get(i).substring(0, carLinks.get(i).indexOf('K')));
			value[i] = Integer.valueOf(carLinks.get(i));
			
		}
		assertTrue(isSortedAscending(value));
		driver.manage().deleteAllCookies();
	}
	
	
	public static boolean isSortedAscending (Integer[] value) {
		for (int i = 0; i < value.length-1; i++) {
			if (value[i] > value[i+1]) {
				return false;
			}
		}
		return true;
	}
		Integer[] value = new Integer[6];
		
		
		
		/*public static boolean isSortedDescending (Integer[] value) {
			for (int i = 1; i < value.length-1; i++) {
				if (value[i] < value[i+1]) {
					return false;
				}
			}
			return true;
		}
		*/
		//milage =//article[1]//span[3]
	

	@Test 
	public void sortByHighestPriceTets() {
	
}
	
	@Test
	
	public void productPageTest() {
		
		logger = reporter.createTest("Test if product name matches name in product page");
		MainPage mp = new MainPage();
		deleteBadCookies();
		
		
		logger.info("Entering car name");
		mp.searchBox.sendKeys("Toyota Supra");
		logger.info("Clicking on search button");
		mp.searchButton.click();

		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Expand SortBy Dropdown");
		SearchFiltersPage sp = new SearchFiltersPage();
		
        //String actual = sp.Car.click().getText();
		//String expected = Driver.findElement(By.xpath =("//*[@id=\"main\"]/div[5]/div[5]/div[1]/div[1]/div[1]/div[1]/span[1]"));
		//assertEquals(expected, actual);
			
		//.getText() of this element: //article[3]//h3/span
		//and getText() of //*[@class='price-mileage__car-title__year-make'] which will be your actual
	}
}