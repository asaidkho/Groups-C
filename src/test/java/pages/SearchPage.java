package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	@FindBy(css="div.orig > div.tile-shell > div.car-tile--images > div.save-car")
	public List<WebElement> searchedCarsSaveButton;
}
