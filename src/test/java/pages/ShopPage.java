package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {

		@FindBy(id = "header-mobile-drawer-focus-start")
		public WebElement shopButton;
		
		
		// ShopByType
		@FindBy (css = "#shop-by-type__slides-item1 > a")
		public WebElement trucks;
		
		// shopByBrand
		@FindBy(xpath = "//*[@id=\"shop-by-brand\"]/div[1]/a[1]")
		public WebElement toyota;
		
		
		
		@FindBy (xpath = "/html/body/div[4]/div/div/div[1]")
		public WebElement locationConformPopUp;
		
		
		
		// shop by price Under $10,000   
		@FindBy(xpath = "//*[@id=\"shop-by-price\"]/div[1]/div[1]/a[1]/span")
		public WebElement byPrice;

		@FindBy(id = "shop-by-lifestyle-commuter")
		public WebElement commuter;

		@FindBy(className = "shop-local-cars-cta kmx-button kmx-button--primary")
		public WebElement localCars;

	}


