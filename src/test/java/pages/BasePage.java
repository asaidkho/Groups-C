package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public abstract class BasePage {
	
	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="header-mobile-drawer-focus-start")
	public WebElement shopLink;
	
	@FindBy(linkText="Sell")
	public WebElement sellLink;
	
	@FindBy(linkText="Finance")
	public WebElement financeLink;
	
	@FindBy(id="header-inventory-search")
	public WebElement searchBox;
	
	@FindBy(id="header-search-button")
	public WebElement searchButton;
	
	@FindBy(xpath="//span[.='More']")
	public WebElement moreMenuLink;
	
	@FindBy(xpath="//a[@href='/car-buying-process/maxcare-service-plans']")
	public WebElement warrantyLink;
	
	@FindBy(id="header-my-profile-button")
	public WebElement profileButton;
	
	@FindBy(linkText="Sign In")
	public WebElement signInButton;
	
	@FindBy(linkText="My Profile")
	public WebElement myProfileButton;
	
	@FindBy(linkText="Saved Cars")
	public WebElement savedCarsButton;
	
	@FindBy(linkText="Sign Out")
	public WebElement logoutButton;
	
	@FindBy(linkText="Saved Searches")
	public WebElement savedSearchesButton;
	
	@FindBy(xpath="//*[@id='search-results-header']//h1")
	public WebElement searchResultsHeader;
	
	
	
}
