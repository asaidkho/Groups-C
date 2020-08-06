package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPage extends BasePage {
	
	
    //trucksFilterTests
	
	
	// drawer label
	@FindBy(id = "mpghighway")
	public WebElement MPGHighway;

	// slider
	@FindBy(xpath = "//*[@id=\"mpghighway\"]/div[3]/div/div/div[2]/div[4]")
	public WebElement sliderHandle;

	// inputBox
	@FindBy(xpath = "//input[@type='tel']")
	public WebElement inputBox;
	// @FindBy(className = "slider-input__text")
	
	// Features
	@FindBy(id = "Features")
	public WebElement features;

	// seeAllFromFeatures
    @FindBy(xpath = "//*[@id=\"Features\"]/div[3]/ul/button")
	public WebElement seeAll;
	
	// @FindBy(className ="facet--curated-show-more kmx-button kmx-button--secondary
		// visible");
		// @FindBy(xpath="//button[.='See All']");
    
    
     //Filter tests
    
    
    
	// clear filter
	@FindBy(className = "sidebar-header--action clear--link")
	public WebElement clear;
	
	// https://www.carmax.com/cars/all
	// id="search-results-header"

	// drop down
	@FindBy(className = "kmx-menu-button kmx-button kmx-button--tertiary")
	public WebElement DropDown;

	@FindBy(id = "header-helpful-links-button")
	public WebElement moreButton;

	// nationwide
	@FindBy(xpath = "//*[@id=\"search-bar-form\"]/div/div[2]/div[2]/div/div/div/ul/li[9]/button")
	public WebElement nationwide;

	@FindBy(xpath = "//*[@id=\"header-helpful-links-menu\"]/ul/li[3]/a")
	public WebElement WhyCarMax;

	@FindBy(xpath = "/html/body/div[4]/div/div/div[1]")
	public WebElement locationConformPopUp;
}


	
	
	
	
	

