package ecommerce;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.ProductPage;
import testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	
	@Test(dataProvider = "getData", groups = {"purchase"})
	public void SubmitOrder(HashMap<String, String> input) throws IOException {
		
		//String productName = "Sauce Labs Bolt T-Shirt";
		ProductPage pdctPage = lgnPage.loginApplication(input.get("name"), input.get("password"));
        List<WebElement> products = pdctPage.getProductList();
        pdctPage.addProductCart(input.get("productName"));
        CartPage crtPage = pdctPage.goToCartPage();
        Boolean match = crtPage.verifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPage cktpPage = crtPage.goToCheckout();
        cktpPage.fillTheDetails();
        ConfirmationPage cnfrmPage = cktpPage.submitOrder();
        String confirmMessage = cnfrmPage.getConfirmMsg();
        Assert.assertEquals(confirmMessage, "Thank you for your order!");
	    System.out.println(confirmMessage);
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonDataToMap((System.getProperty("user.dir")+"\\src\\test\\java\\data\\Data.json"));
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
}
