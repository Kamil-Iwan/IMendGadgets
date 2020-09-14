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
import pageObjects.sampleObjects;

public class sampleTest extends base {

	@Test
	public void calendarCheck() throws IOException, InterruptedException, ParseException {

		// initialise driver
		driver = initializeDriver();
		driver.get("https://myaccount.williamhbrown.co.uk/Login?redir=%2F");

		// initialise Page Objects
		sampleObjects s = new sampleObjects(driver); 
		
		s.getPopup().click();
		
		

		
		
		
		
		//driver.quit();
	}
}
