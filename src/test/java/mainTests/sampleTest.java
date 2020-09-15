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
		driver.get("https://www.kcl.ac.uk/search/search#/courses?term=computer%20science&coursesPage=1");

		
		List<WebElement> allClasses = driver.findElements(By.xpath("//*[starts-with(text(),'Delivery: ')]"));
		int classesSize = allClasses.size();
		System.out.println("All classes size: "+classesSize);
		
		
//		List<WebElement> iButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
//		int iphoneButtons = iButtons.size();
		
		

		
		
		
		
		//driver.quit();
	}
}
