package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_Login;
	

	public void enterEmail(String emailId) {

		txt_email.sendKeys(emailId);

	}

	public void enterPassword(String password) {

		txt_password.sendKeys(password);

	}

	
	public void clickLogin() {

		btn_Login.click();

	}
	
	
	
}
