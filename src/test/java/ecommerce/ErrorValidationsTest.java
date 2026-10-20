package ecommerce;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductPage;
import testComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
	
	@Test(groups = {"ErrorHandling"})
	public void loginError() {
		
	    lgnPage.loginApplication("user", "sauce");
		Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", lgnPage.getErrorMsg());
		System.out.println(lgnPage.getErrorMsg());
	}
	
	@Test
	public void productError() {
		
		String productName = "Sauce Labs Bolt T-Shirt";
		ProductPage pdctPage = lgnPage.loginApplication("standard_user", "secret_sauce");
		List<WebElement> products = pdctPage.getProductList();
        pdctPage.addProductCart(productName);
        CartPage crtPage = pdctPage.goToCartPage();
        Boolean match = crtPage.verifyProductDisplay("Sauce Labs Bolt");
        Assert.assertFalse(match);
	}
}
