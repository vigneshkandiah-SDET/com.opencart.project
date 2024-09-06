package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_LoginDataDrivenTest extends BaseClass {
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
	public void loginTest(String email, String password, String exp) {

		logger.info("**************The Login test Started ");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.enterEmail(email);
			lp.enterPassword(password);
			lp.clickLogin();
			
			Thread.sleep(2000);
			
			System.out.println(email);
			
			System.out.println(password);

			MyAccountPage mp = new MyAccountPage(driver);

			boolean verifyMyAccMsg = mp.verifyMyAccMsg();

			if (exp.equalsIgnoreCase("Valid")) {

				if (verifyMyAccMsg == true) {
					mp.clickLogout();

					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);

				}
			}
				if (exp.equalsIgnoreCase("InValid")) {

					if (verifyMyAccMsg == true) {
						mp.clickLogout();

						Assert.assertTrue(false);

					} else {

						Assert.assertTrue(true);
					}

				}

				

			
		} catch (Exception e) {

			Assert.fail();

		}
		
		logger.info("**************The Login Test Completed ");
	}
}
