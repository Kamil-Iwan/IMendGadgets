package mainTests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Resources.JSExecutor;
import Resources.base;
import pageObjects.LandingPage;
import pageObjects.PopUp;

public class urlTesterLandingPage extends base {

	@Test
	public void calendarCheck() throws IOException, InterruptedException, ParseException {

		// initialise driver
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		// initialise Page Objects
		PopUp p = new PopUp(driver);
		LandingPage lp = new LandingPage(driver);
		JSExecutor js = new JSExecutor(driver);

		js.JSExecutor(p.getExitPopup());

		// p.getExitPopup().click();

		// check header links
		System.out.println("Checking header links.");

		for (WebElement link : lp.getHeaderLinks()) {

			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int httpCode = conn.getResponseCode();
			System.out.println(httpCode);

			if (httpCode >= 400) {

				System.out.println("Broken link: " + link.getText() + " /// " + link.getAttribute("value") + " /// "
						+ link.getAttribute("textContent") + " /// " + link.getAttribute("innerText") + "/// "
						+ link.getAttribute("innerHTML") + " with code: " + httpCode);

			}
		}

		// check footer links
		System.out.println("Checking footer links.");

		for (WebElement link2 : lp.getFootherLinks()) {

			String url2 = link2.getAttribute("href");
			HttpURLConnection conn2 = (HttpURLConnection) new URL(url2).openConnection();
			conn2.setRequestMethod("HEAD");
			conn2.connect();
			int httpCode2 = conn2.getResponseCode();
			System.out.println(httpCode2);

			if (httpCode2 >= 400) {

				System.out.println("Broken link: " + link2.getText() + " /// " + link2.getAttribute("value") + " /// "
						+ link2.getAttribute("textContent") + " /// " + link2.getAttribute("innerText") + "/// "
						+ link2.getAttribute("innerHTML") + " with code: " + httpCode2);

			}
		}

		driver.quit();
	}
}
