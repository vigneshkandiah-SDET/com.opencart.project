package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC01_RegisterTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void registerTest() throws InterruptedException {
		logger.info("**********The Test Started*********** ");
		try {

			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickRegister();

			RegisterPage registerPage = new RegisterPage(driver);

			registerPage.entertFirstName(firstName().toUpperCase());
			logger.info("The First Name Entered Successfully");
			registerPage.enterLastName(lastName().toUpperCase());
			logger.info("The last Name Entered Successfully");
			registerPage.enterEmail(email() + "@gmail.com");

			registerPage.enterPhone(phoneNumber());

			String password = password();

			System.out.println(password);
			registerPage.enterPassword(password);
			registerPage.enterConfirmPassword(password);
			registerPage.checkAgree();
			registerPage.clcikContinue();
			String accountMessage = registerPage.getAccountMessage();
			if (accountMessage.equals("Your Account Has Been Created!")) {
				
				AssertJUnit.assertTrue(true);
				
				logger.info("The Assertion Passed");

			} else {
				logger.error("The Assertion failed");
				logger.debug("The debug logs");
				AssertJUnit.assertTrue(false);
				
			}

		} catch (Exception e) {
			
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());

		}finally {
			
			logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}

	}

}
