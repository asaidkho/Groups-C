package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WarrantyPage extends BasePage {

	@FindBy(xpath="//span[contains(text(),'Sedan')]/parent::button")
	public WebElement sedanButton;
	
	@FindBy(xpath="//span[contains(text(),'SUV')]/parent::button")
	public WebElement suvButton;
	
	@FindBy(xpath="//span[contains(text(),'Truck')]/parent::button")
	public WebElement truckButton;
	
	
	@FindBy(xpath="(//div[@class='kmx-typography--body-3']/span)[1]")
	public WebElement estimateMin;
	
	
	
	public boolean isActiveButton(WebElement button) {
		return button.getAttribute("class").contains("filtered");
	}
	
	 
	
	
	
}
