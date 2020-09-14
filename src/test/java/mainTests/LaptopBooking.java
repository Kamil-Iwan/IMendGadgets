package mainTests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.Laptops;

public class LaptopBooking extends base {

	@Test
	public void checkLaptopBookingProcess() throws IOException, InterruptedException {

		// initialise driver
		driver = initializeDriver();

		// initialise Page Objects
		Laptops lt = new Laptops(driver);

		System.out.println("////////////////LAPTOPS TEST COMMENCING./////////////////");

		driver.get(prop.getProperty("laptops"));

		//// print a number of laptops on the main site
		List<WebElement> laptops = driver.findElements(By.xpath("//span[@id='laptop-selection-boxes']/span"));
		int laptopsSize = laptops.size();
		System.out.println("Number of laptops: " + laptopsSize);

		// iterate through each laptop and check if the booking process works
		for (int i = 1; i <= laptopsSize; i++) {
			driver.get(prop.getProperty("laptops"));

			// click on a laptop
			WebElement laptop = driver.findElement(By.xpath("//span[@id='laptop-selection-boxes']/span[" + i + "]"));

			// wait for laptop to be clickable
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(laptop));

			laptop.click();

			// save a laptop name to a variable
			String laptopName = driver.findElement(By.xpath("//span[@id='laptop-selection-boxes']/span[" + i + "]"))
					.getText();
			String laptopNameLowCase = laptopName.toLowerCase();

			// send text
			driver.findElement(By.cssSelector("div[data-id='" + laptopNameLowCase + "'] input[type='text']")).click();

			driver.findElement(By.cssSelector("div[data-id='" + laptopNameLowCase + "'] input[type='text']"))
					.sendKeys("test");

			// 'Other' laptop test
			if (laptopNameLowCase.equalsIgnoreCase("other")) {

				///////////////// Select a random Repair Type/////////////

				// save number of repairs to a variable
				int repairsSize = driver
						.findElements(
								By.cssSelector("#" + laptopNameLowCase + "-laptops-selection-boxes .wpcf7-list-item"))
						.size();

				// random number of repairs to be generated
				int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);

				// select a random number of random repairs
				for (int r = 1; r <= randomNumber; r++) {
					int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);

					driver.findElements(
							By.cssSelector("#" + laptopNameLowCase + "-laptops-selection-boxes .wpcf7-list-item"))
							.get(randomRepair).click();

				}

				// click on Book Repair
				lt.getBookRepair().click();

				// click on Post Your Device
				lt.getPostYourDevice().click();

				// enter Device Unlocking Code
				lt.getEnterDeviceCode().sendKeys("secret unlocking code");

				// click Proceed With Booking
				// lt.getProceedWithBooking().click();
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", lt.getProceedWithBooking());

				Boolean isSubmitButtonPresent = lt.getSubmitBooking().size() > 0;

				if (isSubmitButtonPresent) {

					System.out.println(laptopName + " OK");
				}

				else {

					System.out.println(laptopName + " ERROR!!!!");

				}
			}

			// all laptops apart from the 'Other' laptop
			else {

				///////////////// Select a random Repair Type/////////////
				int repairsSize = driver
						.findElements(By.cssSelector("#" + laptopNameLowCase + "-selection-boxes .wpcf7-list-item"))
						.size();

				// random number of repairs to be generated
				int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
				// System.out.println("The random number of repairs to be selected:" +
				// randomNumber);

				// select a random number of random repairs
				for (int r = 1; r <= randomNumber; r++) {
					int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);

					driver.findElements(By.cssSelector("#" + laptopNameLowCase + "-selection-boxes .wpcf7-list-item"))
							.get(randomRepair).click();

				}

				// click on Book Repair
				lt.getBookRepair().click();

				// click on Post Your Device
				lt.getPostYourDevice().click();

				// enter Device Unlocking Code
				lt.getEnterDeviceCode().sendKeys("test unlocking code");

				// click Proceed With Booking
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", lt.getProceedWithBooking());

				Boolean isSubmitButtonPresent = lt.getSubmitBooking().size() > 0;

				if (isSubmitButtonPresent) {

					System.out.println(laptopName + " OK");
				}

				else {

					System.out.println(laptopName + " ERROR!!!!");

				}
			}
		}

	}
}
