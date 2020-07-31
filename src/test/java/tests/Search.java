package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.CSVUtility;

public class Search extends TestBase {
	
	
	@DataProvider (name ="file")
	public Object[][] getDataFromCSV() throws IOException{
			return CSVUtility.extractData("cars.csv");
	}
	
	@Test (dataProvider = "file")
	public void SearchByModel(String model, String make) throws Exception {
		logger = reporter.createTest("Search by Model");
		MainPage mp = new MainPage();
		
		logger.info("Entering car model");
		mp.searchBox.sendKeys(model);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		assertTrue(driver.getTitle().contains(model));
	}
	
	@Test (dataProvider = "file")
	public void SearchByMake(String model, String make) throws Exception {
		logger = reporter.createTest("Search by Make");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys(make);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(make));
		assertTrue(driver.getTitle().contains(make));
	}
	
	//@Test (dataProvider = "file")
	@Test 
	//public void limitSearchResultsByLocationAndDistance(String model, String make) {
	public void limitSearchResultsByLocationAndDistance() {
		logger = reporter.createTest("Limit Search Results by Location and Distance");
		MainPage mp = new MainPage();
		//Faker f = new Faker();
		
		logger.info("Entering car make and model");
		//mp.searchBox.sendKeys(make + " " + model);
		mp.searchBox.sendKeys("Toyota Camry");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		assertTrue(driver.getTitle().contains("Toyota Camry"));
		//assertTrue(driver.getTitle().contains(make + " " + model));
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		;
		logger.info("Entering zip code");
		//mp.zipCode.isSelected();
		mp.zipCode.clear();
		//String zip = f.address().zipCode();
		//BrowserUtilities.waitFor(2);
		//mp.zipCode.sendKeys(zip);
		mp.zipCode.sendKeys("20879");
		assertEquals(mp.zipCode.getAttribute("value"), "20879");
		driver.manage().deleteAllCookies();
		logger.info("Clicking on distance radius dropdown");
		mp.distanceRadiusDropdown.click();
		logger.info("Select the distance radius");
		mp.distanceRadius.click();
		assertEquals(mp.distanceRadiusDropdown.getText(), "75 Miles");
		
	}
	
	@Test
	public void searchByTypeFilterMake() {
		logger = reporter.createTest("Search by Type with applied filter of Make");
		MainPage mp = new MainPage();
		
		String[] type = {"SUVs","Trucks","Crossovers","Sedans","Coupes"};
		
		logger.info("Entering car type");
		mp.searchBox.sendKeys(type[2]);  //hardcoded
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		logger.info("Validate the crossovers results");
		assertTrue(driver.getTitle().contains("Crossovers"));
		
		driver.manage().deleteAllCookies();
		//not working
		logger.info("Select the Make(recomended) filter");
		//System.out.println(mp.makeFilters.getText());
		if(mp.makeFilters.getText().contains("Toyota")) {
			mp.ToyotaFilters.click();
		}
		logger.info("Verify that make filter is applyed");
		assertTrue(driver.getTitle().contains("Toyota"));
	}
	
	@Test
	public void searchByMakeFilterYear() {
		logger = reporter.createTest("Search by Make with applied filter on year");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("Lexus");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		logger.info("Validate the Make results");
		assertTrue(driver.getTitle().contains("Lexus"));
		
		logger.info("Expand Year drop-down");
		mp.Year.click();
		mp.yearFrom.clear();
		logger.info("Enter the year range to search for");
		//logger.info("From");
		mp.yearFrom.sendKeys("2015");
		assertEquals(mp.yearFrom.getAttribute("value"), "2015");
		mp.yearTo.clear();
		//logger.info("To");
		mp.yearTo.sendKeys("2019");
		assertEquals(mp.yearTo.getAttribute("value"), "2019");
		
		//assertTrue(driver.getTitle().contains("Lexus 2015-2019"));
		//assertEquals(mp.searchResultHeader.getText(), "Used Lexus 2015-2019 for Sale");
	}


	@Test
	public void searchByColor() {
		logger = reporter.createTest("Search by color");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("Audi");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		driver.manage().deleteAllCookies();
		logger.info("Extand Exterior Color drop-down");
		mp.exteriorColor.click();
		BrowserUtilities.waitFor(2);
		driver.manage().deleteAllCookies();
		assertTrue(mp.blueColor.isEnabled());
		logger.info("Select Blue color");
		mp.blueColor.click();
		BrowserUtilities.waitFor(2);
		logger.info("Validate that car results filtered by blue color");
		assertTrue(driver.getTitle().contains("Blue"));
	}

	@Test
	public void searchCompare() {
		logger = reporter.createTest("Compare the selected cars produced by search result");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("BMW");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		
		logger.info("Locate and enable compare button");
		mp.compareButton.click();
		logger.info("Select 3 cars to compare");
		for(int i=1; i<4; i++) {
			driver.findElement(By.xpath("//*[@id=\"cars-listing\"]/div[1]/article[" + 
					i + "]/a/div/div[3]/label/span[1]")).click();
		}
		driver.manage().deleteAllCookies();
		logger.info("Compare");
		mp.compareButton.click();
		logger.info("Validate");
		String actual = driver.findElement(By.xpath("//*[@id=\"compare-vehicles-mockup\"]/h1")).getText();
		assertTrue(actual.contains("Compare ") && actual.contains("3") && actual.contains(" Vehicles"));
	}
	
}
