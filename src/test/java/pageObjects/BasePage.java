package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		// The PageFactory.initElements(driver, this); call initializes the elements
		// defined in the derived classes.
		PageFactory.initElements(driver, this);

	}

}
