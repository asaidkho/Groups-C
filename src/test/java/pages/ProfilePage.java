package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
	
	
	//Profile Update Form: 
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="addressLine1")
	public WebElement addressLine1;
	
	@FindBy(id="zipCode")
	public WebElement zipCode;
	
	@FindBy(id="state")
	public WebElement state;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="phoneNumber")
	public WebElement phoneNumber;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(xpath="//button[contains(text(), 'Update Profile')]")
	public WebElement profileSubmitButton;
	
	// End of Profile Update form
	
	
	//Communication Preferences
	
	@FindBy(id="radio-0")
	public WebElement radio0;
	
	@FindBy(id="radio-1")
	public WebElement radio1;
	
	@FindBy(id="radio-2")
	public WebElement radio2;
	
	@FindBy(xpath="//button[contains(text(), 'Update Preferences')]")
	public WebElement preferencesSubmitButton;
	
	
	
	
	
	
}
