package mainTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.DeliveryPage;
import pageObjects.ProductPage;
import pageObjects.ReusableMethods;

public class OtherPhoneBooking extends base {

	@Test
	public void GoogleiheckBookingProcess() throws IOException, InterruptedException {

		// initialise driver
		driver = initializeDriver();

		// initialise Page Objects
		ProductPage pp = new ProductPage(driver);
		DeliveryPage dp = new DeliveryPage(driver);
		ReusableMethods m = new ReusableMethods(driver);

		System.out.println("////////////////OTHER PHONE TEST COMMENCING./////////////////");
		driver.get(prop.getProperty("otherPhone"));
		pp.getInputText().sendKeys("test");

		// click on a random number of random repairs
		m.getRandomRepairsMethod();

		// click Book Repair Now
		pp.getBookRepair().click();

		Boolean isRepairInStorePresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;

		if (isRepairInStorePresent) {

			dp.getRepairInStore().click();

			// check if Select Delivery Option page is present
			Boolean isProceedWithBookingPresent = driver
					.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;

			if (isProceedWithBookingPresent) {

				// click on Repair In Store
				dp.getRepairInStore().click();

				// click on Proceed With Booking
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", dp.getProceedWithBooking());

				// check if `Submit Booking` button is present
				Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector("input[value='Submit Booking']"))
						.size() > 0;

				if (isSubmitBookingPresent) {

					System.out.println("Other Phone - OK");

				}

				else {

					System.out.println("Other Phone - Submit Booking on Page 3 is missing - ERROR!!!!!!");
				}
			}

			else {

				System.out.println("Other Phone - BOOKING STEP 2 PAGE ERROR!!!!!");

			}
		}

		driver.quit();

	}
}
