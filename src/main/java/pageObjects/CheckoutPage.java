package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableCode;

public class CheckoutPage extends ReusableCode {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name") WebElement firstName;
	@FindBy(id="last-name") WebElement lastName;
	@FindBy(id="postal-code") WebElement codeNumber;
	@FindBy(id="continue") WebElement continueButton;
	@FindBy(name="finish") WebElement submit;
	
	public void fillTheDetails() {
		firstName.sendKeys("standard");
		lastName.sendKeys("user");
		codeNumber.sendKeys("12345");
		continueButton.click();
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}

}
