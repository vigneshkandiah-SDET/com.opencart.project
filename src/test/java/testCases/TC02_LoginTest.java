package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_LoginTest extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void loginTest() {
		try {
			logger.info("**************The Login test Started ");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.enterEmail(prop.getProperty("email"));
			lp.enterPassword(prop.getProperty("password"));
			lp.clickLogin();

			MyAccountPage mp = new MyAccountPage(driver);

			boolean verifyMyAccMsg = mp.verifyMyAccMsg();

			AssertJUnit.assertEquals(verifyMyAccMsg, true);

			logger.info("**************The Login Test Completed ");

		} catch (Exception e) {

			Assert.fail();

		}

	}
}
