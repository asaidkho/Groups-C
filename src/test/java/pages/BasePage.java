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

}
