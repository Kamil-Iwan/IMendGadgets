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
import pageObjects.ReusableMethods;
import pageObjects.ServicePage;
import pageObjects.iPhones;


public class methodExecutionTest extends base{
	
	
	
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		
		//initialise driver
		driver = initializeDriver(); 
		//driver.get(prop.getProperty("url"));
		
		//initialise Page Objects
		LandingPage l = new LandingPage(driver);
		PopUp p = new PopUp(driver);
		ServicePage sp = new ServicePage(driver);
		PhoneRepairs pr = new PhoneRepairs(driver);
		iPhones ip = new iPhones(driver);
		ProductPage pp = new ProductPage(driver);
		CalendarPage c = new CalendarPage(driver);
		
		ReusableMethods m = new ReusableMethods(driver);
		
				
		
		m.getRandomRepairsMethod();
		
		
		
		
		
	}
}

	
	

		
		
		
		
		
	
			
			
			
		
			
			
	
				
		
		
		
		
		
		
	
	
	


	

