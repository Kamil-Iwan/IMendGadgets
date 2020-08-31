package mainTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.CalendarPage;
import pageObjects.DeliveryPage;
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ServicePage;
import pageObjects.iPhones;


public class calendar extends base{
	
	
	
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		
		//initialise driver
		driver = initializeDriver(); 
		driver.get(prop.getProperty("url"));
		
		//initialise Page Objects
		LandingPage l = new LandingPage(driver);
		PopUp p = new PopUp(driver);
		ServicePage sp = new ServicePage(driver);
		PhoneRepairs pr = new PhoneRepairs(driver);
		iPhones ip = new iPhones(driver);
		ProductPage pp = new ProductPage(driver);
		CalendarPage c = new CalendarPage(driver);
		DeliveryPage dp = new DeliveryPage(driver);
		
	
		//close popup
		p.getExitPopup().click();
		
	
		//Fix my device
		l.getFixButton().click();
		
		//click Phones
		sp.getPhones().click();
		
		
		//click Apple
		pr.getApple().click();
	
		
		//number of phones
		List<WebElement> iButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
		int iphoneSize = iButtons.size();
		//System.out.println("Number of iPhones: " + iphoneButtons);
		
		
		//click on a random phone
		int randomiPhone = ThreadLocalRandom.current().nextInt(0, iphoneSize);
		iButtons.get(randomiPhone).click();
		
		//save phone name to a variable
		String phoneName = 	pp.getPhone().getText();
		phoneName = phoneName.replaceAll("Repairs", "");
	
		//save number of repairs to a variable
		int repairsSize = pp.getAllRepairs().size();
		
		//random number of repairs to be generated
		int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
		System.out.println("The random number of repairs to be selected:" + randomNumber);
		
		
		//select a random number of random repairs
		for (int i = 1; i <=randomNumber; i++) {
			
			int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
			System.out.println("Clicking on repair number: " + randomRepair);
			pp.getAllRepairs().get(randomRepair).click();
			
			
		}
		
		//click Book Repair Now
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", pp.getBookRepair());
		
		//click on Repair In Store
		c.getInStore().click();
		
		//click on Calendar
		c.getCalendar().click();
		
		//click on a target year
		c.getYear().click();
		driver.findElement(By.xpath("//div[@data-value='" + c.targetYear + "']")).click();
		
		//click on a target month
		c.getMonth().click();
		driver.findElement(By.xpath("//div[text()='" + c.targetMonth1 + "']")).click();
		
		//click on a target day
		
		try {
			driver.findElement(By.xpath("//td[@data-date='25']")).click();
		}
		
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
		
			driver.findElement(By.xpath("//td[@data-date='25']")).click();
		}
		
		
		//click on a target hour
		try {
			driver.findElement(By.xpath("//div[text()='" + c.targetTime + "']")).click();
			
		}
		
		catch(org.openqa.selenium.StaleElementReferenceException ex) {

			driver.findElement(By.xpath("//div[text()='" + c.targetTime + "']")).click();
			
		}
	
		//click on Proceed With Booking
		executor.executeScript("arguments[0].click();", dp.getProceedWithBooking());
															
		//check if Select Delivery Option page is present
		Boolean isProceedWithBookingPresent = driver.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;
							
		if (isProceedWithBookingPresent) {
							
			//click on Repair In Store
			dp.getRepairInStore().click();
							
			//click on Proceed With Booking
			executor.executeScript("arguments[0].click();", dp.getProceedWithBooking());
																		
			//check if `Submit Booking` button is present
			Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector("input[value='Submit Booking']")).size() > 0;
							
			if (isSubmitBookingPresent) {
								
				System.out.println(phoneName+"Calendar - OK");
								
				}
					
				else {
									
					System.out.println(phoneName+ "- Submit Booking on Page 3 is missing - ERROR!!!!!!");
					}}
								
												
			else {
								
				System.out.println(phoneName + "- BOOKING STEP 2 PAGE ERROR!!!!!");
								
				}
			
			
		driver.quit();

	
	
	
		
	}
}

	
	

		
		
		
		
		
	
			
			
			
		
			
			
	
				
		
		
		
		
		
		
	
	
	


	
