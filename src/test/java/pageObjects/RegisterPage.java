package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	
	public RegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtPhone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement lnkConfirm;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkedAgree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement lnkContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void entertFirstName(String firstname) {

		txtFirstName.sendKeys(firstname);

	}

	public void enterLastName(String lastname) {

		txtLastName.sendKeys(lastname);

	}

	public void enterEmail(String email) {

		txtEmail.sendKeys(email);

	}
	
	public void enterPhone(String phone) {

		txtPhone.sendKeys(phone);

	}
	

	public void enterPassword(String password) {

		txtPassword.sendKeys(password);

	}

	public void enterConfirmPassword(String cPassword) {

		lnkConfirm.sendKeys(cPassword);

	}

	public void checkAgree() {
		chkedAgree.click();

	}

	public void clcikContinue() {

		lnkContinue.click();

	}

	public String getAccountMessage() {

		try {

			return (msgConfirmation.getText());

		} catch (Exception e) {

			return (e.getMessage());
		}

	}

}
