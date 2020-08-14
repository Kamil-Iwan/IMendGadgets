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
		
		
	
		//save number of repairs to a variable
		int repairsSize = pp.getAllRepairs().size();
		
		//test
		//System.out.println("Size of All Repairs is : " + repairsSize);
		
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
		pp.getBookRepair().click();
		
		//click on Repair In Store
		c.getInStore().click();
		
		//click on Calendar
		c.getCalendar().click();
		
		
		/*
		// get today's date
		
		
		int whatMonth = cal.get(Calendar.MONTH);
		int whatDay = cal.get(Calendar.DAY_OF_MONTH);
		*/
		
		//how many days displayed
		//int countDays =	c.getAllDays().siz
			
		//get current year
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
			
		//wait for calendar to appear
			
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".xdsoft_year")));
		 
		//click on year
		c.getYear().click();
		
		//how many years displayed
		
		List<WebElement> allYears2 = driver.findElements(By.cssSelector(".xdsoft_yearselect"));
		int numOfYears = allYears2.size();
		
		System.out.println("Number of years displayed: " + numOfYears);
		
		
	
		
	
		
		
				
		
		
		
		
		
	}
}

	
	

		
		
		
		
		
	
			
			
			
		
			
			
	
				
		
		
		
		
		
		
	
	
	


	
