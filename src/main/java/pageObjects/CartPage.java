package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableCode;

public class CartPage extends ReusableCode {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cart_list .inventory_item_name") private List<WebElement> ProductTitles;
	@FindBy(id="checkout") WebElement checkoutButton;
	
	
	public Boolean verifyProductDisplay(String productName) {
		 Boolean match = ProductTitles.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		 return match;
	}
	
	public  CheckoutPage goToCheckout() {
		checkoutButton.click();
		CheckoutPage cktpPage = new CheckoutPage(driver);
		return cktpPage;
	}


}

