package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

	@FindBy (xpath = "//span[@class='year-make']")
	public WebElement searchResults;
	
	@FindBy (id = "zip")
	public WebElement zipCode;
	
	//@FindBy (className = "kmx-menu-button kmx-button kmx-button--tertiary")
	//@FindBy (className = "//*[@id=\"search-bar-form\"]/div/div[2]/div[2]/div/button/span")
	@FindBy (css = "#search-bar-form > div > div.search-bar--fields-wrapper > div.search-bar--form-field.radius > div > button")
	public WebElement distanceRadiusDropdown;
	
	@FindBy (xpath = "/html/body/div[4]/div/div/div[1]")
	//@FindBy (className = "location-confirm-modal--close--7vQCO")
	public WebElement locationConformPopUp;
	
	//@FindBy (xpath = "//[@class='kmx-list']//ul//li[2]")  //back to this to not hardcode
	@FindBy (xpath = "//*[@id=\"search-bar-form\"]/div/div[2]/div[2]/div/div/div/ul/li[3]")
	public WebElement distanceRadius;
	
	@FindBy (xpath = "//*[@id=\"recommended-refinements\"]/div[2]/div/div")
	public WebElement makeFilters;
	
	//@FindBy (xpath = "//*[@id=\"recommended-refinements\"]/div[2]/div/div/a[6]")
	@FindBy (xpath = "//*[@id=\"recommended-refinements\"]/div[2]/div/div/a[6]")
	public WebElement ToyotaFilters;
	
	@FindBy (xpath = "//*[@id=\"YearFilter\"]/div[2]")
	public WebElement Year;
	
	@FindBy (xpath = "//*[@id=\"YearFilter\"]/div[3]/div/div[1]/div/div[1]/div[2]/div[1]/input")
	public WebElement yearFrom;
	
	@FindBy (xpath = "//*[@id=\"YearFilter\"]/div[3]/div/div[1]/div/div[1]/div[2]/div[2]/input")
	public WebElement yearTo;
	
	//@FindBy (xpath = "/html/body/main/div[1]/div/section/div/div[1]/div[1]/h1")
	@FindBy (xpath = "//*[@id='title']")
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
}
