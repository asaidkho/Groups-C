package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	@FindBy(xpath="//article//div[@class='save-car']")
	public List<WebElement> searchedCarsSaveButton;
}
