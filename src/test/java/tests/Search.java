package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import utilities.BrowserUtilities;
import utilities.CSVUtility;
import utilities.Driver;

public class Search extends TestBase {
	
	@DataProvider (name ="file")
	public Object[][] getDataFromCSV() throws IOException{
			return CSVUtility.extractData("cars.csv");
	}

	@Test (dataProvider = "file", enabled = false)  
	public void SearchByModel(String model, String make) {
		logger = reporter.createTest("Search by Model");
		MainPage mp = new MainPage();
		
		logger.info("Entering car model");
		mp.searchBox.sendKeys(model);
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		//assertTrue(mp.searchResults.getText().contains(make));
		assertTrue(driver.getTitle().contains(model));
	}
	
	@Test (dataProvider = "file", enabled = false) 
	public void SearchByMake(String model, String make) {
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
	@Test(groups="smoke", enabled = false) 
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
		//assertTrue(mp.searchResults.getText().contains("Toyota Camry"));
		//assertTrue(driver.getTitle().contains(make + " " + model));
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		driver.manage().deleteAllCookies();
		logger.info("Entering zip code");
		mp.zipCode.click();
		mp.zipCode.sendKeys("20879");
		BrowserUtilities.waitFor(2);
		assertEquals(mp.zipCode.getAttribute("value"), "20879");
		driver.manage().deleteAllCookies();
		logger.info("Clicking on distance radius dropdown");
		mp.distanceRadiusDropdown.click();
		logger.info("Select the distance radius");
		mp.distanceRadius.click();
		assertEquals(mp.distanceRadiusDropdown.getText(), "75 Miles");	
	}

	@Test (enabled = false) 
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
		if(mp.makeFilters.getText().contains("Toyota")) {
			mp.ToyotaFilters.click();
		}
		logger.info("Verify that make filter is applyed");
		assertTrue(driver.getTitle().contains("Toyota"));
		//assertTrue(mp.searchResults.getText().contains("Toyota"));
	}
	
	@Test (enabled = false) 
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
		BrowserUtilities.waitFor(2);
		assertEquals(mp.yearTo.getAttribute("value"), "2019");
		
		//assertTrue(driver.getTitle().contains("Lexus 2015-2019"));
		//assertTrue(mp.searchResults.getText().contains("Lexus 2015-2019"));
		//assertEquals(mp.searchResultHeader.getText(), "Used Lexus 2015-2019 for Sale");
	}


	@Test(groups="smoke", enabled = false) 
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
		//assertTrue(mp.searchResults.getText().contains("Blue"));
	}

	@Test(groups="smoke", enabled = false) 
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
		//assertTrue(actual.contains("Compare ") && actual.contains("3") && actual.contains(" Vehicles"));
		//BrowserUtilities.waitFor(2);
		assertTrue(actual.contains("Compare ") && actual.contains(" Vehicles"));
	}

	
	//TODO Sprint 2: new test cases

	@Test (groups = "smoke2", enabled = false)
	public void SearchWithSortByLowesMiliage() {
		logger = reporter.createTest("Search with applying Sort By (drop-down): Lowest Mileage");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make and model");
		mp.searchBox.sendKeys("BMW X6");
		logger.info("Clicking on search button");
		mp.searchButton.click();

		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		logger.info("Clicking on distance radius dropdown");
		mp.distanceRadiusDropdown.click();
		logger.info("Select the distance radius - Nationwide");
		mp.distanceRadiusNationwide.click();
		assertEquals(mp.distanceRadiusDropdown.getText(), "Nationwide");
		BrowserUtilities.waitFor(5);
		logger.info("Sort By Lowest Mileage");
		mp.sortBy.click();
		BrowserUtilities.waitFor(2);
			
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//button[.='Lowest mileage']"))).click().perform();
		BrowserUtilities.waitFor(5);

		logger.info("Verifying that cars got filtered");
		List<String> carLinks = new ArrayList<>();
		//Compare mileage of first 6 search result
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
	
	@Test (enabled = false) 
	public void SearchWithSortByNewArrivals() {
		logger = reporter.createTest("Search with applying Sort By (drop-down): New arrivals");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("BMW");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		logger.info("Sort By New arrivals");
		mp.sortBy.click();
		driver.findElement(By.xpath("//button[.='New arrivals']")).click();
		BrowserUtilities.waitFor(4);
		//Note: flexible to improve to go through few search results
		assertEquals(driver.findElement(By.xpath("//*[@id=\"cars-listing\"]//article[1]/a/div[2]")).getText(), "NEW ARRIVAL");
	}
	
/** Price / Monthly Payment Filter*/
	
	@Test (groups = "smoke2", enabled = false) //-Filter by Price with applying Actions class
	public void SearchWithPriceFilter() {
		logger = reporter.createTest("Search with applying Price Filter from Price / Monthly Payment Filter drop-down");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("Lexus");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Scroll down the page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		logger.info("Sort By Price Filter");
		mp.priceFilter.click();
		BrowserUtilities.waitFor(3);
		//driver.findElement(By.xpath("//*[@class='tab kmx-typography--body-1 active-tab']//button")).getText()
		assertTrue(driver.findElement(By.xpath("//*[@class='range-slider--histogram-avg kmx-typography--headline-1']")).isDisplayed());
		deleteBadCookies();
		Actions action = new Actions(driver);
		action.clickAndHold(mp.priceScrollLeft).perform();
		action.moveByOffset(-55, 0).perform();
		action.release().perform();
		//BrowserUtilities.waitFor(2);
		//assertEquals(driver.findElement(By.xpath("//*[@class='range-slider__inputs']//div[2]//input")).getAttribute("value"), "38,000");
		//assertEquals(driver.findElement(By.xpath("//*[@class='selected-refinements']//button[2]")).getText(), "Under $38,000");
		
		action.clickAndHold(mp.priceScrollRight).perform();
		action.moveByOffset(60, 0).perform();
		action.release().perform();
		BrowserUtilities.waitFor(4);
		//assertEquals(driver.findElement(By.xpath("//*[@class='range-slider__inputs']//div[1]//input")).getAttribute("value"), "17,500");
		
		assertEquals(driver.findElement(By.xpath("//*[@class='selected-refinements']//button[2]")).getText(), "$17,500-$38,000");
		driver.manage().deleteAllCookies();
	}
	

	@Test (groups = "smoke2", enabled = false) //-Filer by Monthly Payment with applying Actions class and Apply button
	public void SearchWithMonthlyPaymentFilter() {
		logger = reporter.createTest("Search with applying Monthly Payment from Price / Monthly Payment Filter drop-down");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("Lexus");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		logger.info("Scroll down the page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		logger.info("Price / Monthly Payment Filter drop-down");
		mp.priceFilter.click();
		BrowserUtilities.waitFor(3);
		logger.info("Sort by Monthly Payment");
		mp.monthlyPaymentButton.click();
		deleteBadCookies();
		logger.info("Desired Monthly Payment");
		//mp.desiredMonthlyPayment.clear();
		//mp.desiredMonthlyPayment.sendKeys("400");
		Actions action = new Actions(driver);
		//action.moveToElement(mp.desiredMonthlyPaymentSlider).perform();
		js.executeScript("window.scrollBy(0,500)");
		deleteBadCookies();
		action.clickAndHold(mp.desiredMonthlyPaymentSlider).perform();
		action.moveByOffset(-100, 0).perform();
		action.release().perform();
		BrowserUtilities.waitFor(3);
		assertEquals(mp.desiredMonthlyPayment.getAttribute("value"), "400");
		logger.info("Down Payment");
		//mp.downPayment.clear();
		//mp.downPayment.sendKeys("5000");
		action.moveToElement(mp.downPaymentSlider).perform();
		action.clickAndHold(mp.downPaymentSlider).perform();
		action.moveByOffset(52, 0).perform();
		action.release().perform();
		BrowserUtilities.waitFor(2);
		assertEquals(mp.downPayment.getAttribute("value"), "5,000");
		deleteBadCookies();
		js.executeScript("window.scrollBy(0,150)");
		BrowserUtilities.waitFor(3);
		logger.info("Credit score");
		mp.creditScore.click();
		driver.findElement(By.xpath("//*[@class='monthly-payment']/div[3]/div[1]//li[2]")).click();
		BrowserUtilities.waitFor(2);
		driver.findElement(By.xpath("//*[@class='monthly-payment']/div[3]/div[1]//span")).isEnabled();
		assertEquals(driver.findElement(By.xpath("//*[@class='monthly-payment']/div[3]/div[1]//span")).getText(), "very good");
		logger.info("Terms");
		mp.terms.click();
		driver.findElement(By.xpath("//*[@class='monthly-payment']/div[4]/div[1]//li[2]")).click();
		BrowserUtilities.waitFor(2);
		assertEquals(driver.findElement(By.xpath("//*[@class='monthly-payment']/div[4]/div[1]//span/span")).getText(), "60 month");
		//driver.findElement(By.xpath("//*[@id='PriceFilter']//button[.='APPLY']")).click();
		BrowserUtilities.waitFor(2);
		driver.findElement(By.xpath("//*[@id=\"PriceFilter\"]/div[3]/div/div/div[2]/div[2]/div/div[5]/button[1]")).click();	
		BrowserUtilities.waitFor(4);
		
		/*
		// Validate that the monthly payment values are below 400$	
		List<String> carLinks = new ArrayList<>();
		//get links
		for(int i=1; i<8; i++) {
			if (i!=5) {
			carLinks.add(driver.findElement(By.xpath("//*[@id='cars-listing']/div[1]/article["+i+"]//p[2]")).getText());
			}
		}
		Integer[] mothlyPayment = new Integer[7];
		//get links monthly payment values
		for (int i=0; i<carLinks.size();i++) {
			carLinks.set(i, carLinks.get(i).substring(1, 4));
			mothlyPayment[i] = Integer.valueOf(carLinks.get(i));
		}
		Arrays.sort(mothlyPayment);
		//validation	
		assertTrue(monthlyPaymentValidation(mothlyPayment)); 
		*/
	}
	
	public boolean monthlyPaymentValidation(Integer[] mothlyPayment) {
		if (mothlyPayment[mothlyPayment.length-1] <= 400) {
			return true;
		} else {
			return false;
		} 
	}
	
	
	@Test (enabled = false)
	public void resetSearchWithMonthlyPaymentFilter() {
		logger = reporter.createTest("Reset button");
		MainPage mp = new MainPage();
		SearchWithMonthlyPaymentFilter();
		mp.resetButton.click();
		BrowserUtilities.waitFor(2);
		assertEquals(mp.searchResultsHeader.getText(), "Used Lexus for Sale");
		driver.manage().deleteAllCookies();
	}
	
	@Test (enabled = false) 
	public void SearchWithSortByLowestPrice() {
		logger = reporter.createTest("Search with applying Sort By (drop-down): Lowest Price");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make and model");
		mp.searchBox.sendKeys("Ford Mustang");
		logger.info("Clicking on search button");
		mp.searchButton.click();

		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Sort By Lowest Price");
		mp.sortBy.click();
		BrowserUtilities.waitFor(2);
			
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//button[.='Lowest price']"))).click().perform();
		BrowserUtilities.waitFor(5);

		logger.info("Verifying that cars got filtered");
		List<String> carLinks = new ArrayList<>();
		//Compare mileage of first 6 search result
		for(int i=1; i<10; i++) {
			if (i!=5) {
			carLinks.add(driver.findElement(By.xpath("//*[@id='cars-listing']/div[1]/article["+i+"]//div[2]/p[1]//span[1]")).getText());
			}
		}
		Integer[] value = new Integer[8];
		for (int i=0; i<carLinks.size();i++) {
			carLinks.set(i, carLinks.get(i).substring(1,3).concat(carLinks.get(i).substring(4,7)));
			value[i] = Integer.valueOf(carLinks.get(i));
		}
		System.out.println(carLinks);
		assertTrue(isSortedAscending(value));
		driver.manage().deleteAllCookies();
	}
	
	
	//TODO Sprint 3: new test cases
	
	@Test (groups="smoke3")//(enabled = false) //(groups = "smoke3")
	public void SearchWithRecommendedFiltersNumber() {
		logger = reporter.createTest("Search with applying Recommended Filters - validate the search result list number of cars equal the number Recommended Filters model selection");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("Land Rover");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		BrowserUtilities.waitFor(1);
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Select 'Discovery Sport' in the list of Recommended Filters");
		String expected = driver.findElement(By.xpath("//*[@id='recommended-refinements']/div[2]//a[contains(.,'Discovery Sport')]/span")).getText();
		driver.findElement(By.xpath("//*[@id='recommended-refinements']/div[2]//a[contains(.,'Discovery Sport')]")).click();
		BrowserUtilities.waitFor(2);
		String actual = "("+ mp.numberOfMatches.getText() +")";
		assertEquals(expected, actual);
		driver.manage().deleteAllCookies();
	}
	
	@Test (groups="smokeA")//(enabled = false)
	public void SearchWithRecommendedFiltersModel() {
		logger = reporter.createTest("Search with applying Recommended Filters - validate the search result list of cars contains only the selected model");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("Dodge");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		BrowserUtilities.waitFor(1);
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Select 'Challenger' in the list of Recommended Filters");
		driver.findElement(By.xpath("//*[@id='recommended-refinements']/div[2]//a[contains(.,'Challenger')]")).click();
		BrowserUtilities.waitFor(3);

		for (int i=1; i<= Integer.parseInt(mp.numberOfMatches.getText()); i++) {
			if (i!=5 || i!=10) {
				assertTrue(driver.findElement(By.xpath("//article["+i+"]//h3/span[1]")).getText().contains("Dodge"));
				assertTrue(driver.findElement(By.xpath("//article["+i+"]//h3/span[2]")).getText().contains("Challenger"));
			}
		}
		driver.manage().deleteAllCookies();
	}
	
	@Test (groups="smoke3")//(enabled = false) //(groups = "smoke3")
	public void SearchWithYearFilterSlider() {
		logger = reporter.createTest("Search with applying with years range using the slider from Year Filter drop-down");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make and model");
		mp.searchBox.sendKeys("Honda Pilot");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		BrowserUtilities.waitFor(1);
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Expand Year drop-down filter");
		mp.yearFilter.click();
		BrowserUtilities.waitFor(2);
		deleteBadCookies();
		Actions action = new Actions(driver);
		action.clickAndHold(mp.yearScrollRight).moveByOffset(110, 0).release().build().perform();
		assertEquals(mp.yearScrollRight.getAttribute("aria-valuenow"), "2015");
		action.clickAndHold(mp.yearScrollLeft).moveByOffset(-30, 0).release().build().perform();
		assertEquals(mp.yearScrollLeft.getAttribute("aria-valuenow"), "2018");
		BrowserUtilities.waitFor(2);
		assertEquals(driver.findElement(By.xpath("//*[@class='selected-refinements']//button[3]")).getText(), "2015-2018");
		assertTrue(mp.searchResultHeader.getText().contains("Honda Pilot 2015-2018"));
		driver.manage().deleteAllCookies();
	}
	
	/**Note: test cases is not stable since the number for the type changes with delay on the web-site*/
	@Test (enabled = false)//(groups="smokeA")//(enabled = false)
	public void SearchWithTypeFilter() {
		logger = reporter.createTest("Search with applying with Type Filter drop-down and validate number of matches");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make");
		mp.searchBox.sendKeys("Infiniti");
		logger.info("Clicking on search button");
		mp.searchButton.click();
		BrowserUtilities.waitFor(1);
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Expand Type drop-down filter");
		mp.typeFilter.click();
		BrowserUtilities.waitFor(2);
		deleteBadCookies();
		logger.info("Scroll down the page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		BrowserUtilities.waitFor(2);
		logger.info("Select SUVs type");
		//String expected = driver.findElement(By.xpath("//*[@id='Types']//div[.='SUVs']//span")).getText();
		String expected = driver.findElement(By.xpath("//*[@id='Types']//div[5]//div[2]")).getText();   // hardcoded - not flexible
		driver.findElement(By.xpath("//*[@id='Types']//div[.='SUVs']")).click();
		BrowserUtilities.waitFor(2);
		String actual = "(" + mp.numberOfMatches.getText() + ")";
		assertEquals(expected, actual);
		
		assertEquals(driver.findElement(By.xpath("//*[@class='selected-refinements']//button[2]")).getText(), "SUVs");
		assertTrue(mp.searchResultHeader.getText().contains("Infiniti SUVs"));
		driver.manage().deleteAllCookies();
	}
	
	/** The slider moves different in Opera  browser giving the 35000, but good for Chrome and Edge*/
	@Test (enabled = false)//(groups="smokeA")//(enabled = false)
	public void SearchWithMileageFilterSlider() {
		logger = reporter.createTest("Search with applying mileage range limit using the slider from Mileage Filter drop-down");
		MainPage mp = new MainPage();
		
		logger.info("Entering car make and model");
		mp.searchBox.sendKeys("Dodge Charger");
		logger.info("Clicking on search button");
		mp.searchButton.click();

		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Expand Mileage drop-down filter");
		mp.mileageFilter.click();
		BrowserUtilities.waitFor(2);
		deleteBadCookies();
		logger.info("Select the miles range limit using the slider");
		Actions action = new Actions(driver);
		action.clickAndHold(mp.mileageFilterSlider).moveByOffset(-160, 0).release().build().perform();
		BrowserUtilities.waitFor(2);
		assertEquals(mp.mileageFilterSlider.getAttribute("aria-valuenow"), "30000");
		
		assertEquals(driver.findElement(By.xpath("//*[@class='selected-refinements']//button[3]")).getText(), "Miles: Under 30K");
		assertTrue(mp.searchResultHeader.getText().contains("Dodge Charger Under 30K Miles"));
		driver.manage().deleteAllCookies();
	}
	
	/**good for Edge and opera*/
	@Test (enabled = false)
	public void SearchWithSeeCarsAtThisStoreAndCompare() {
		logger = reporter.createTest("Search with 'SEE CARS AT THIS STORE', select mmake and model, and compare search results");
		MainPage mp = new MainPage();
		
		logger.info("Expand Your Nearest store drop-down with the name of the city on the menu");
		mp.headerMyStore.click();
		logger.info("Click on 'SEE CARS AT THIS STORE'");
		mp.seeCarsAtThisStore.click();
		BrowserUtilities.waitFor(1);
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		}
		deleteBadCookies();
		
		logger.info("Select car make in the Recommended Filters list");
		driver.findElement(By.xpath("//*[@id='recommended-refinements']//div[2]//a[contains(text(),'Ford')]")).click();
		BrowserUtilities.waitFor(2);
		assertTrue(mp.searchResultHeader.getText().contains("Ford"));
		BrowserUtilities.waitFor(1);
		if (mp.locationConformPopUp2.isEnabled()) {
			mp.locationConformPopUp2.click();
		}
		deleteBadCookies();
		 
		logger.info("Scroll the Recommended Filters list by button");
		mp.recommendedFiltersButtonToRight.click();
		BrowserUtilities.waitFor(3);
		mp.recommendedFiltersButtonToRight.click();
		BrowserUtilities.waitFor(2);
		deleteBadCookies();
		logger.info("Select 'Automatic Transmission' in the Recommended Filters list");
		driver.findElement(By.xpath("//*[@id='recommended-refinements']//div[2]//a[contains(text(),'Automatic Transmission')]")).click();
		deleteBadCookies();
		assertTrue(mp.searchResultHeader.getText().contains("Ford With Automatic Transmission"));
		BrowserUtilities.waitFor(1);
		if (mp.locationConformPopUp.isEnabled()) {
			mp.locationConformPopUp.click();
		} 
		deleteBadCookies();
		
		logger.info("Select the model in the Recommended Filters list");
		driver.findElement(By.xpath("//*[@id='recommended-refinements']//div[2]//a[contains(text(),'Edge')]")).click();	
		assertTrue(mp.searchResultHeader.getText().contains("Ford Edge With Automatic Transmission"));
		deleteBadCookies();
		
		logger.info("Compare the results of the search");
		mp.compareButton.click();
		String numberOfMatches = mp.numberOfMatches.getText();
		for(int i=1; i<=Integer.parseInt(numberOfMatches); i++) {
			driver.findElement(By.xpath("//*[@id=\"cars-listing\"]/div[1]/article[" + 
					i + "]/a/div/div[3]/label/span[1]")).click();
		}
		deleteBadCookies();
		mp.compareButton.click();

		String actual = driver.findElement(By.xpath("//*[@id='compare-vehicles-mockup']/h1")).getText();
		assertTrue(actual.contains("Compare ") && actual.contains(numberOfMatches) && actual.contains(" Vehicles"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		BrowserUtilities.waitFor(5);
		js.executeScript("window.scrollBy(0,300)");
		
		driver.manage().deleteAllCookies();
	}

}
