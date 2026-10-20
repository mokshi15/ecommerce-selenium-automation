package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableCode;

public class ProductPage extends ReusableCode {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item") List<WebElement> products;
	
	By productsBy = By.cssSelector(".inventory_item");
	By addToCart = By.cssSelector(".pricebar button");

	public List<WebElement> getProductList() {
		
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String productName) {
		
		 WebElement prod = getProductList().stream().filter(product-> product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals(productName)).findFirst().orElse(null);
		 return prod;
	}
	
	public void addProductCart(String productName) {
		
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click();
	}
	
	

}
