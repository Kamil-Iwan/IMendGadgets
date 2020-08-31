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


public class allPhonesBooking extends base{
	
	
	
	
	@Test
	public void allPhonesBookingProcess() throws IOException, InterruptedException {
		
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
		
		
		//close popup
		p.getExitPopup().click();
		
		
		//Fix my device
		l.getFixButton().click();
		
		//click Phones
		sp.getPhones().click();
		
		
		//click Apple
		pr.getApple().click();
	
		System.out.println("////////////////IPHONE TEST COMMENCING./////////////////");
		
		////print a number of iPhones on the main site
		List<WebElement> iButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
		int iphoneButtons = iButtons.size();
		System.out.println("Number of iPhones: " + iphoneButtons);
		
		
		//iPhone page - check if service page opens up for each phone
		for (int i=1; i<=iphoneButtons; i++) {
			driver.get(prop.getProperty("iphone"));
			driver.findElement(By.xpath("//a[" + i + "]//button[1]")).click();
			
			//save phone name to a variable
			String phoneName = 	pp.getPhone().getText();
			
			//click on a random number of random repairs
			m.getRandomRepairsMethod();
		
			//click Book Repair Now
			pp.getBookRepair().click();
			
			
			Boolean isRepairInStorePresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
			
			if (isRepairInStorePresent) {
					
				dp.getRepairInStore().click();
				
				//check if Proceed With Booking button is present
				Boolean isProceedWithBookingPresent = driver.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;
				
				if (isProceedWithBookingPresent) {
					
				dp.getProceedWithBooking().click();
				
					//check if `Submit Booking` button is present
					Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
				
					if (isSubmitBookingPresent) {
					
						System.out.println(phoneName+" - booking process OK.");
					
					}
					else {
						
						System.out.println(phoneName+ " - Submit Booking is missing - ERROR!!!!!!");
					}}
					
				else {
					System.out.println(phoneName+ " - Proceed With Booking is missing - ERROR!!!!!!");
					
				}}
									
			else {
					
					System.out.println(phoneName + " - service page error!!!!!");
					
				}}
		
		
		
				
			
			//Samsung Test
			System.out.println("////////////////SAMSUNG TEST COMMENCING./////////////////");
			driver.get(prop.getProperty("samsung"));
			
			//print a number of Samsung phones on the main site
			List<WebElement> sButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
			int samsungButtons = sButtons.size();
			System.out.println("Number of Samsung phones: " + samsungButtons);
			
			//iterate through each phone booking process
			for (int s=1; s<=samsungButtons; s++) {
				driver.get(prop.getProperty("samsung"));
				driver.findElement(By.xpath("//a[" + s + "]//button[1]")).click();
				
				String phoneName = 	pp.getPhone().getText();
						
				//click on a random number of random repairs
				m.getRandomRepairsMethod();
				
				//click Book Repair Now
				pp.getBookRepair().click();
					
				//check if Repair in Store button present and click if yes
				Boolean isRepairInStorePresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
					
				if (isRepairInStorePresent) {
						
					dp.getRepairInStore().click();
					
					//check if Proceed With Booking button is present
					Boolean isProceedWithBookingPresent = driver.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;
					
					if (isProceedWithBookingPresent) {
						
					dp.getProceedWithBooking().click();
					
						//check if `Submit Booking` button is present
						Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
					
						if (isSubmitBookingPresent) {
						
							System.out.println(phoneName+" - booking process OK.");
						
						}
						else {
							
							System.out.println(phoneName+ " - Submit Booking is missing - ERROR!!!!!!");
						}}
						
					else {
						System.out.println(phoneName+ " - Proceed With Booking is missing - ERROR!!!!!!");
						
					}}
										
				else {
						
						System.out.println(phoneName + " - service page error!!!!!");
						
					}}
						
					
		

			
			//Huawei test
			System.out.println("////////////////HUAWEI TEST COMMENCING./////////////////");
			driver.get(prop.getProperty("huawei"));
			
			//print a number of Huawei phones on the main site
			List<WebElement> hButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
			int huaweiButtons = hButtons.size();
			System.out.println("Number of Huawei phones: " + huaweiButtons);
			
			for (int h=1; h<=huaweiButtons; h++) {
				driver.get(prop.getProperty("huawei"));
				driver.findElement(By.xpath("//a[" + h + "]//button[1]")).click();
				
				String phoneName = 	pp.getPhone().getText();
				
				//click on a random number of random repairs
				m.getRandomRepairsMethod();
				
				//click Book Repair Now
				pp.getBookRepair().click();
					
					
				Boolean isRepairInStorePresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
					
				if (isRepairInStorePresent) {
							
					dp.getRepairInStore().click();
						
					//check if Proceed With Booking button is present
					Boolean isProceedWithBookingPresent = driver.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;
						
						if (isProceedWithBookingPresent) {
							
						dp.getProceedWithBooking().click();
						
							//check if `Submit Booking` button is present
							Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
						
							if (isSubmitBookingPresent) {
							
								System.out.println(phoneName+" - booking process OK.");
							
							}
							else {
								
								System.out.println(phoneName+ " - Submit Booking is missing - ERROR!!!!!!");
							}}
							
						else {
							System.out.println(phoneName+ " - Proceed With Booking is missing - ERROR!!!!!!");
							
						}}
											
				else {
							
						System.out.println(phoneName + " - service page error!!!!!");
							
					}}
				
				
				
				
				//Google page - check if service page opens up
				System.out.println("////////////////GOOGLE TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("google"));
				
				//print a number of Google phones on the main site
				List<WebElement> gButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
				int googleButtons = gButtons.size();
				System.out.println("Number of Google phones: " + googleButtons);
				
				for (int g=1; g<=googleButtons; g++) {
					driver.get(prop.getProperty("google"));
					driver.findElement(By.xpath("//a[" + g + "]//button[1]")).click();
								
					String phoneName = 	pp.getPhone().getText();
					
					//click on a random number of random repairs
					m.getRandomRepairsMethod();
					
					//click Book Repair Now
					pp.getBookRepair().click();
						
						
					Boolean isRepairInStorePresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
					
					if (isRepairInStorePresent) {
								
						dp.getRepairInStore().click();
							
						//check if Proceed With Booking button is present
						Boolean isProceedWithBookingPresent = driver.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;
							
							if (isProceedWithBookingPresent) {
								
							dp.getProceedWithBooking().click();
							
								//check if `Submit Booking` button is present
								Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
							
								if (isSubmitBookingPresent) {
								
									System.out.println(phoneName+" - booking process OK.");
								
								}
								else {
									
									System.out.println(phoneName+ " - Submit Booking is missing - ERROR!!!!!!");
								}}
								
							else {
								System.out.println(phoneName+ " - Proceed With Booking is missing - ERROR!!!!!!");
								
							}}
												
					else {
								
							System.out.println(phoneName + " - service page error!!!!!");
								
						}}
			
				
				System.out.println("////////////////OTHER PHONE TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("otherPhone"));
				pp.getInputText().sendKeys("test");
				
				
				//click on a random number of random repairs
				m.getRandomRepairsMethod();
				
				//click Book Repair Now
				pp.getBookRepair().click();
				
				Boolean isRepairInStorePresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
				
				if (isRepairInStorePresent) {
							
					dp.getRepairInStore().click();
						
					//check if Proceed With Booking button is present
					Boolean isProceedWithBookingPresent = driver.findElements(By.xpath("//input[@value='Proceed With Booking']")).size() > 0;
						
						if (isProceedWithBookingPresent) {
							
						dp.getProceedWithBooking().click();
						
							//check if `Submit Booking` button is present
							Boolean isSubmitBookingPresent = driver.findElements(By.cssSelector(".wpcf7-list-item.first")).size() > 0;
						
							if (isSubmitBookingPresent) {
							
								System.out.println("Other Phone - booking process OK.");
							
							}
							else {
								
								System.out.println("Other Phone - Submit Booking is missing - ERROR!!!!!!");
							}}
							
						else {
							System.out.println("Other Phone - Proceed With Booking is missing - ERROR!!!!!!");
							
						}}
											
				else {
							
						System.out.println("Other Phone - service page error!!!!!");
							
					}
	
			
				driver.quit();

	}
				
				
	}

		
		
		
		
		
		
		
	
	
	


	

