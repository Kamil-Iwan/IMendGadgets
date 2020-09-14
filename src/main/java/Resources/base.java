package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"//Users//kamil//eclipse-workspace//IMendGadgets2//src//main//java//Resources//data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome"))

		{
			System.setProperty("webdriver.chrome.driver", "//Users//kamil//Desktop//automatedTesting//chromedriver");

			ChromeOptions options = new ChromeOptions();

			// options.addArguments("--headless");
			options.addArguments("--start-fullscreen");

			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
		}

		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"//Users//kamil//Desktop//automatedTesting//drivers//geckodriver");
			

			FirefoxOptions options = new FirefoxOptions();

			
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		else if (browserName.equals("safari")) {

			System.setProperty("webdriver.safari.driver",
					"//Users//kamil//Desktop//automatedTesting//drivers//safaridriver");
			

			SafariOptions options = new SafariOptions();

			

			driver = new SafariDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}

		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		return driver;

	}

	public String login1() {

		return "iwanowicz.ki@gmail.com";
	}

	public String password1() {

		return "Tester1234*";
	}

}
