package mainTests;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Resources.JSExecutor;
import Resources.base;
import pageObjects.CalendarPage;
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ServicePage;
import pageObjects.sampleObjects;

public class sampleTest extends base {

	@Test
	public void calendarCheck() throws IOException, InterruptedException, ParseException {

		// initialise driver
		driver = initializeDriver();
		driver.get("https://www.williamhbrown.co.uk/");

		
		
		
		Actions a = new Actions(driver);	
		a.moveToElement(driver.findElement(By.xpath("//div[@class='nav-part nav-part-2']/ul/li[2]"))).build().perform();


		
		
		
		
		//driver.quit();
	}
}
