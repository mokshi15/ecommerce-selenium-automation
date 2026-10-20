package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableCode;

public class LoginPage extends ReusableCode {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button") WebElement login;
	@FindBy(css="h3[data-test='error']") WebElement errorMsg;
	
	
	public ProductPage loginApplication(String name, String pwd) {
		userName.sendKeys(name);
		password.sendKeys(pwd);
		login.click();
		ProductPage pdctPage = new ProductPage(driver);
		return pdctPage;
	}
	
	public String getErrorMsg() {
		
		return errorMsg.getText();
	}
	
	public void goTo() {
		driver.get("https://www.saucedemo.com/");
	}

}
