package mainTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
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
import pageObjects.BookingStep3;
import pageObjects.CalendarPage;
import pageObjects.ContactDetailsPage;
import pageObjects.DeliveryPage;
import pageObjects.LandingPage;
import pageObjects.Laptops;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ReusableMethods;
import pageObjects.ServicePage;
import pageObjects.iPhones;


public class iPadBooking extends base{
	
	
	
	
	@Test
	public void checkPhoneBookingPage() throws IOException, InterruptedException {
		
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
		Laptops lt = new Laptops(driver);
		DeliveryPage dp = new DeliveryPage(driver);
		ContactDetailsPage cdp = new ContactDetailsPage(driver);
		BookingStep3 bs3 = new BookingStep3(driver);
		
		ReusableMethods m = new ReusableMethods(driver);
		
		
		
				
				
				/*
				//iPad - check if service page opens up
				System.out.println("////////////////IPAD TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("ipad"));
				List<WebElement> ip1Buttons = driver.findElements(By.cssSelector("#ipad-selection-boxes>span"));
				int iPadButtons = ip1Buttons.size();
				System.out.println("Number of iPads: " + iPadButtons);
				
				for (int x=1; x<=iPadButtons; x++) {
					driver.get(prop.getProperty("ipad"));
					driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipad-selection-boxes']/span[" + x + "]")).click();
								
					String ipadName = 	driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipad-selection-boxes']/span[" + x + "]/label/span")).getText();
					
					//save number of repairs to a variable
					int repairsSize = pp.getAllIpadRepairs().size();
					
				
					//random number of repairs to be generated
					int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
					//System.out.println("The random number of repairs to be selected:" + randomNumber);
					
						
					//select a random number of random repairs
						for (int r = 1; r <=randomNumber; r++) {
						int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
						//System.out.println("Clicking on repair number: " + randomRepair);
						pp.getAllIpadRepairs().get(randomRepair).click();
						}
					
						//click Book Repair Now
						pp.getIpadBookRepair().click();
						
						
						Boolean isPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
						
						if (isPresent) {
							
							System.out.println(ipadName + " OK");	
							
						}
						
						else {
							
							System.out.println(ipadName + " service page error!!!!!");
							
						}
				
				*/
	
				/*
				System.out.println("////////////////LAPTOPS TEST COMMENCING./////////////////");
				//Apple laptop test
				driver.get(prop.getProperty("laptops"));
				lt.getApple().click();
				lt.getAppleType().sendKeys("test");
				lt.getBookRepair().click();
				
				
				Boolean isApplePresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
				
				if (isApplePresent) {
					
					System.out.println("Apple laptop - OK");	
					
				}
				
				else {
					
					System.out.println("Apple laptop-  service page error!!!!!");
					
				}
				
				
				//Dell laptop test
				driver.get(prop.getProperty("laptops"));
				lt.getDell().click();
				lt.getDellType().sendKeys("test");
				lt.getBookRepair().click();
				
				
				Boolean isDellPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
				
				if (isDellPresent) {
					
					System.out.println("Dell laptop - OK");	
					
				}
				
				else {
					
					System.out.println("Dell laptop -  service page error!!!!!");
					
				}
				
				//Lenovo laptop test
				driver.get(prop.getProperty("laptops"));
				lt.getLenovo().click();
				lt.getLenovoType().sendKeys("test");
				lt.getBookRepair().click();
				
				
				Boolean isLenovoPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
				
				if (isLenovoPresent) {
					
					System.out.println("Lenovo laptop - OK");	
					
				}
				
				else {
					
					System.out.println("Lenovo laptop -  service page error!!!!!");
					
				}
				
				
				//ASUS laptop test
				driver.get(prop.getProperty("laptops"));
				lt.getAsus().click();
				lt.getAsusType().sendKeys("test");
				lt.getBookRepair().click();
				
				
				Boolean isASUSPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
				
				if (isASUSPresent) {
					
					System.out.println("ASUS laptop - OK");	
					
				}
				
				else {
					
					System.out.println("ASUS laptop -  service page error!!!!!");
					
				}
				
				//HP laptop test
				driver.get(prop.getProperty("laptops"));
				lt.getHP().click();
				lt.getHPType().sendKeys("test");
				lt.getBookRepair().click();
				
				
				Boolean isHPPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
				
				if (isHPPresent) {
					
					System.out.println("HP laptop - OK");	
					
				}
				
				else {
					
					System.out.println("HP laptop -  service page error!!!!!");
					
				}
				
				//Other laptop test
				driver.get(prop.getProperty("laptops"));
				lt.getOther().click();
				lt.getOtherType().sendKeys("test");
				lt.getBookRepair().click();
				
				
				Boolean isOtherLaptopPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
				
				if (isOtherLaptopPresent) {
					
					System.out.println("HP laptop - OK");	
					
				}
				
				else {
					
					System.out.println("HP laptop -  service page error!!!!!");
					
				}
				
				
				
		*/
				
			
				
				
				
				
				
				driver.quit();

	}
				
				
	}

		
		
		
		
		
		
		
	
	
	


	

