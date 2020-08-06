package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecificCarPage extends BasePage {

	@FindBy(css="button.kmx-icon-toggle-wrapper")
	public WebElement saveCarButton;
	
	@FindBy(css="button.kmx-icon-toggle-wrapper > span > span.fave")
	public WebElement saveCarButtonFave;
	
	@FindBy(css="button.slick-gallery__hud--new__360-cta")
	public WebElement open360Button;
	
	
	@FindBy(css="div.slick-slider>button")
	public List<WebElement> slideButtons;
	
	@FindBy(xpath="//div[@class='interior-exterior-toggle kmx-typography--body-1']/span[.='Exterior']")
	public WebElement exteriorButton;
	
	@FindBy(xpath="//div[@class='interior-exterior-toggle kmx-typography--body-1']/span[.='Interior']")
	public WebElement interiorButton;
	
	@FindBy(className = "price-mileage__car-title__year-make")
	public WebElement carTitle;
	
	@FindBy(css="span.value")
	public WebElement carPrice;
	
	
}
