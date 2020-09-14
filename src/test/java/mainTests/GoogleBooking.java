package mainTests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.DeliveryPage;
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ReusableMethods;
import pageObjects.ServicePage;

public class GoogleBooking extends base {

	@Test
	public void GoogleiheckBookingProcess() throws IOException, InterruptedException {

		// initialise driver
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		// initialise Page Objects
		LandingPage l = new LandingPage(driver);
		PopUp p = new PopUp(driver);
		ServicePage sp = new ServicePage(driver);
		PhoneRepairs pr = new PhoneRepairs(driver);
		ProductPage pp = new ProductPage(driver);
		DeliveryPage dp = new DeliveryPage(driver);
		ReusableMethods m = new ReusableMethods(driver);

		// close popup
		p.getExitPopup().click();

		// Fix my device
		l.getFixButton().click();

		// click Phones
		sp.getPhones().click();

		// click Google
		pr.getGoogle().click();

		// Google Test
		System.out.println("////////////////GOOGLE TEST COMMENCING./////////////////");

		// print a number of phones on the main site
		List<WebElement> gButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
		int googleButtons = gButtons.size();

		// Google page - check if service page opens up for each phone
		for (int i = 1; i <= googleButtons; i++) {
			driver.get(prop.getProperty("google"));
			driver.findElement(By.xpath("//a[" + i + "]//button[1]")).click();

			// save phone name to a variable
			String phoneName = pp.getPhone().getText();
			phoneName = phoneName.replaceAll("Repairs", "");

			// click on a random number of random repairs
			m.getRandomRepairsMethod();

			// click Book Repair Now
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", pp.getBookRepair());

			// check if Select Delivery Option page is present
			Boolean isProceedWithBookingPresent = driver
					.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;

			if (isProceedWithBookingPresent) {

				// click on Repair In Store
				dp.getRepairInStore().click();

				// click on Proceed With Booking
				executor.executeScript("arguments[0].click();", dp.getProceedWithBooking());

				// check if `Submit Booking` button is present
				Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector("input[value='Submit Booking']"))
						.size() > 0;

				if (isSubmitBookingPresent) {

					System.out.println(phoneName + "- OK");

				}

				else {

					System.out.println(phoneName + "- Submit Booking on Page 3 is missing - ERROR!!!!!!");
				}
			}

			else {

				System.out.println(phoneName + "- BOOKING STEP 2 PAGE ERROR!!!!!");

			}
		}

		driver.quit();

	}
}
