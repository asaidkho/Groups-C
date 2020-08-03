package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecificCarPage extends BasePage {

	@FindBy(css="button.kmx-icon-toggle-wrapper")
	public WebElement saveCarButton;
	
	@FindBy(css="button.slick-gallery__hud--new__360-cta")
	public WebElement open360Button;
	
	
	@FindBy(css="div.slick-slider>button")
	public List<WebElement> slideButtons;
	
}
