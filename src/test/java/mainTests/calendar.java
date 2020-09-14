package mainTests;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Resources.JSExecutor;
import Resources.base;
import pageObjects.CalendarPage;
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ServicePage;

public class calendar extends base {

	@Test
	public void calendarCheck() throws IOException, InterruptedException, ParseException {

		// initialise driver
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		// initialise Page Objects
		LandingPage l = new LandingPage(driver);
		PopUp p = new PopUp(driver);
		ServicePage sp = new ServicePage(driver);
		PhoneRepairs pr = new PhoneRepairs(driver);
		ProductPage pp = new ProductPage(driver);
		CalendarPage c = new CalendarPage(driver);
		JSExecutor j = new JSExecutor(driver);

		// close popup
		p.getExitPopup().click();

		// Fix my device
		l.getFixButton().click();

		// click Phones
		sp.getPhones().click();

		// click Apple
		pr.getApple().click();

		// number of phones
		List<WebElement> iButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
		int iphoneSize = iButtons.size();
		// System.out.println("Number of iPhones: " + iphoneButtons);

		// click on a random phone
		int randomiPhone = ThreadLocalRandom.current().nextInt(0, iphoneSize);
		iButtons.get(randomiPhone).click();

		// save phone name to a variable
		String phoneName = pp.getPhone().getText();
		phoneName = phoneName.replaceAll("Repairs", "");

		// save number of repairs to a variable
		int repairsSize = pp.getAllRepairs().size();

		// random number of repairs to be generated
		int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);

		// select a random number of random repairs
		for (int i = 1; i <= randomNumber; i++) {

			int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
			pp.getAllRepairs().get(randomRepair).click();
		}

		// click Book Repair Now
		j.JSExecutor(pp.getBookRepair());
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click();", pp.getBookRepair());

		// click on Repair In Store
		c.getInStore().click();

		// click on Calendar
		c.getCalendar().click();

		// click on a target year
		c.getYear().click();
		driver.findElement(By.xpath("//div[@data-value='" + c.targetYear + "']")).click();

		// click on a target month
		c.getMonth().click();
		driver.findElement(By.xpath("//div[text()='" + c.targetMonth1 + "']")).click();

		// click on a target day
		try {
			driver.findElement(By.xpath("//td[@data-date='" + c.targetDay + "']")).click();
		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {

			driver.findElement(By.xpath("//td[@data-date='" + c.targetDay + "']")).click();
		}

		// click on a target hour
		// scroll up on calendar dropdown list
		for (int i = 1; i <= 10; i++) {

			c.getCalendarPrev().click();

		}

		List<WebElement> allHours = driver.findElements(By.cssSelector(".xdsoft_time"));
		int allHoursSize = allHours.size();

		// iterate through the available times and click on the target time
		for (int x = 1; x <= allHoursSize; x++) {

			WebElement selectedHour = driver
					.findElement(By.xpath("//div[@class='xdsoft_time_variant']//div[" + x + "]"));
			String selectedHourString = selectedHour.getText();

			if (selectedHourString.contains(c.targetTime)) {

				selectedHour.click();
				break;

			}

			else {

				c.getCalendarNext().click();

			}
		}

		// compare the target date with selected date
		String targetDateAndTime = c.targetDay + "/" + c.MonthAsIntegerMethod() + "/" + c.targetYear + " "
				+ c.targetTime;

		String generatedDate = c.getCheckDate().getAttribute("value");

		// System.out.println("targetDateAndTime: "+targetDateAndTime);
		// System.out.println("generatedDate: "+generatedDate);

		if (targetDateAndTime.contentEquals(generatedDate)) {

			System.out.println("The selected date is correct - TEST SUCCESSFUL!");
		}

		else {

			System.out.println("ERROR - the selected date is NOT correct!");
		}
		driver.quit();
	}
}
