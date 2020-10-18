package pageObjects;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.base;

public class ReusableMethods extends base {

	public WebDriver driver;

	public ReusableMethods(WebDriver driver) {
		this.driver = driver;

	}

	public void getRandomRepairsMethod() {
		ProductPage pp = new ProductPage(driver);

		// get the size of all available repairs
		int repairsSize = pp.getAllRepairs().size();

		// random number of repairs to be generated
		int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
		// System.out.println("Number of repairs to be selected: "+randomNumber);

		// select a random number of random repairs
		for (int r = 1; r <= randomNumber; r++) {
			int randomRepair = ThreadLocalRandom.current().nextInt(0, repairsSize);
			pp.getAllRepairs().get(randomRepair).click();

			// System.out.println("Clicking repair number: "+randomRepair);
		}

	}

	public void getCalendarMethod() {

		CalendarPage c = new CalendarPage(driver);

		// SELECT A TARGET DATE FROM THE CALENDAR
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
		for (int z = 1; z <= 10; z++) {

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

	}
}
