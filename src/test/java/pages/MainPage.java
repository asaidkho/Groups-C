package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

	//@FindBy (xpath = "//span[@class='year-make']")
		@FindBy (id= "search-results-header")
		public WebElement searchResults;
		
		@FindBy (id = "zip")
		//@FindBy (xpath = "//*[@id=\"zip\"]")
		public WebElement zipCode;
		
		@FindBy (className = "//*[@class='search-bar--form-field radius']//button/span")
		//@FindBy (css = "#search-bar-form > div > div.search-bar--fields-wrapper > div.search-bar--form-field.radius > div > button")
		public WebElement distanceRadiusDropdown;
		
		@FindBy (xpath = "/html/body/div[4]/div/div/div[1]")
		//@FindBy (className = "location-confirm-modal--close--7vQCO")
		public WebElement locationConformPopUp;
		
		@FindBy (xpath = "//*[@class='ReactModal__Content ReactModal__Content--after-open modal--content location-confirm-modal--modal--3Z9Dl']/div[1]")
		public WebElement locationConformPopUp2;
		
		//@FindBy (xpath = "//[@class='kmx-list']//ul//li[2]")  //back to this to not hardcode
		@FindBy (xpath = "//*[@id=\"search-bar-form\"]/div/div[2]/div[2]/div/div/div/ul/li[3]")
		public WebElement distanceRadius;
		
		@FindBy (xpath = "//*[@id='search-bar-form']//ul/li[9]/button")
		public WebElement distanceRadiusNationwide;
		
		@FindBy (xpath = "//*[@id=\"recommended-refinements\"]/div[2]/div/div")
		public WebElement makeFilters;
		
		//@FindBy (xpath = "//*[@id=\"recommended-refinements\"]/div[2]/div/div/a[6]")
		@FindBy (xpath = "//*[@id=\"recommended-refinements\"]/div[2]/div/div/a[6]")
		public WebElement ToyotaFilters;
		
		@FindBy (xpath = "//*[@id='YearFilter']/div[2]")
		public WebElement Year;
		
		@FindBy (xpath = "//*[@id=\"YearFilter\"]/div[3]/div/div[1]/div/div[1]/div[2]/div[1]/input")
		public WebElement yearFrom;
		
		@FindBy (xpath = "//*[@id=\"YearFilter\"]/div[3]/div/div[1]/div/div[1]/div[2]/div[2]/input")
		public WebElement yearTo;
		
		//@FindBy (xpath = "/html/body/main/div[1]/div/section/div/div[1]/div[1]/h1")
		@FindBy (xpath = "//*[@id='title']/h1")
		public WebElement searchResultHeader;
		
		@FindBy (xpath = "//*[@id=\"ExteriorColor\"]/div[2]")
		public WebElement exteriorColor;
		
		@FindBy (xpath = "//*[@id=\"ExteriorColor\"]/div[3]/div/div[4]/div")  // hardcoded - back to change flexible color selection
		public WebElement redColor;
		
		//@FindBy (xpath = "//*[@id=\"ExteriorColor\"]/div[3]/div/div[2]/span")
		@FindBy (css = "#ExteriorColor > div.drawer--content > div > div:nth-child(2)")
		public WebElement blueColor;
		
		//@FindBy (className = "kmx-typography--headline-1 options--compare-button compare-mode")
		@FindBy (xpath = "//*[@id=\"search-results-header\"]/div[3]/button[2]")
		public WebElement compareButton;
		
		@FindBy (xpath = "//*[@id=\"search-results-header\"]/div[3]/div/div/button")
		public WebElement sortBy;
		
		//@FindBy (xpath = "//*[@id=\"search-results-header\"]/div[3]/div/div/div/ul/li")
		//public WebElement sortByList;
		
		//@FindBy (xpath = "//*[@id=\"search-results-header\"]/div[3]/div/div/div/ul/li[5]/button")
		@FindBy (css = "#search-results-header > div:nth-child(3) > div > div > div > ul > li:nth-child(5) > button")
		public WebElement sortByLowestMileage;
		
		//@FindBy (xpath = "//*[@class='rc-slider-handle rc-slider-handle-1']")
		@FindBy (css = "#PriceFilter > div.drawer--content > div > div > div.tab--panels.drawer-anim-target > div.tab-panel.active-panel > div > div > div.range-slider--wrapper.price-range > div > div.rc-slider > div.rc-slider-handle.rc-slider-handle-1")
		public WebElement priceScrollRight;
		
		//@FindBy (xpath = "//*[@class='rc-slider-handle rc-slider-handle-2']")
		@FindBy (css = "#PriceFilter > div.drawer--content > div > div > div.tab--panels.drawer-anim-target > div.tab-panel.active-panel > div > div > div.range-slider--wrapper.price-range > div > div.rc-slider > div.rc-slider-handle.rc-slider-handle-2")
		public WebElement priceScrollLeft;
		
		@FindBy(xpath = "//*[@class='button-tabs--list drawer-anim-target']/button[2]")
		public WebElement monthlyPaymentButton;
		
		//@FindBy(xpath = "//*[@class='monthly-payment']/div[1]/div[2]/div[4]")
		@FindBy (css = "#PriceFilter > div.drawer--content > div > div > div.tab--panels.drawer-anim-target > div.tab-panel.active-panel > div > div:nth-child(1) > div.rc-slider > div.rc-slider-handle")
		public WebElement desiredMonthlyPaymentSlider;
		
		@FindBy(xpath = "//*[@class='monthly-payment']/div[1]/div[1]/div[2]//input")
		public WebElement desiredMonthlyPayment;
		
		//@FindBy(xpath = "//*[@class='monthly-payment']/div[2]/div[2]/div[4]")
		@FindBy (css = "#PriceFilter > div.drawer--content > div > div > div.tab--panels.drawer-anim-target > div.tab-panel.active-panel > div > div:nth-child(2) > div.rc-slider > div.rc-slider-handle")
		public WebElement downPaymentSlider;
		
		@FindBy(xpath = "//*[@class='monthly-payment']/div[2]/div[1]/div[2]//input")
		public WebElement downPayment;
		
		@FindBy(xpath = "//*[@class='monthly-payment']/div[3]/div[1]")
		public WebElement creditScore;
		
		@FindBy(xpath = "//*[@class='monthly-payment']/div[4]/div[1]")
		public WebElement terms;
		
		@FindBy (id = "PriceFilter")
		public WebElement priceFilter;
		
		@FindBy(xpath = "//*[@id=\"PriceFilter\"]/div[3]/div/div/div[2]/div[2]/div/div[5]/button[2]")
		public WebElement resetButton;
		
		@FindBy (xpath = "//*[@id='number-of-matches']/span[2]")
		public WebElement numberOfMatches;
		
		@FindBy (id = "YearFilter")
		public WebElement yearFilter;
		
		@FindBy (xpath = "//*[@class='rc-slider']/div[4]")
		public WebElement yearScrollRight;
		
		@FindBy (xpath = "//*[@class='rc-slider']/div[5]")
		public WebElement yearScrollLeft;
		
		@FindBy (id = "Types")
		public WebElement typeFilter;
		
		@FindBy (id = "MileageFilter")
		public WebElement mileageFilter;
		
		@FindBy (xpath = "//*[@class='mileagefilter']//div[4]")
		public WebElement mileageFilterSlider;
		
		@FindBy (id = "header-my-store-button")
		public WebElement headerMyStore;
		
		@FindBy (xpath = "//*[@id='header-my-store-menu']//a[.='See cars at this store']")
		public WebElement seeCarsAtThisStore;
		
		//@FindBy (xpath = "//button[@class='smooth-carousel__button smooth-carousel__button--right']")
		@FindBy (xpath = "//*[@id=\"recommended-refinements\"]/div[2]/button[2]")
		public WebElement recommendedFiltersButtonToRight;
		
}
