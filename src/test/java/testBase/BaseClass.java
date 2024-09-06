package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public Logger logger;
	public static WebDriver driver;
	public Properties prop;

	@Parameters({ "os", "browser" })
	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	public void setup(String os, String browser) throws IOException {

		FileReader file = new FileReader("./src/test/resources/config.properties");

		prop = new Properties();

		prop.load(file);
		logger = LogManager.getLogger(this.getClass());

		if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (os.equalsIgnoreCase("MAC")) {

				capabilities.setPlatform(Platform.MAC);

			} else if (os.equalsIgnoreCase("windows")) {

				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("linux")) {

				capabilities.setPlatform(Platform.LINUX);
			} else {

				System.out.println("The os is invalid");
			}

			switch (browser.toLowerCase()) {

			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;
			case "safari":
				capabilities.setBrowserName("safari");
				break;
			case "MicrosoftEdge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("The Browser is invalid");
				return;

			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		}

		if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (browser.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				System.out.println(" Choosed Invalid Browser");
				return;
			}

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("AppURL"));
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {

		driver.quit();
	}

	public String firstName() {

		String firstname = RandomStringUtils.randomAlphabetic(5);

		return firstname;
	}

	public String lastName() {

		String lastName = RandomStringUtils.randomAlphabetic(5);

		return lastName;
	}

	public String email() {

		String email = RandomStringUtils.randomAlphabetic(5);

		return email;
	}

	public String phoneNumber() {

		String phone = RandomStringUtils.randomNumeric(7);

		return phone;
	}

	public String password() {

		String number = RandomStringUtils.randomNumeric(7);

		String text = RandomStringUtils.randomAlphabetic(5);

		return text + "@" + number;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "//screenshots//" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
