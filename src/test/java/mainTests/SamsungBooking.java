package mainTests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Resources.base;
import pageObjects.DeliveryPage;
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ReusableMethods;
import pageObjects.ServicePage;


public class SamsungBooking extends base{
	
	
	
	
	@Test
	public void SamsungCheckBookingProcess() throws IOException, InterruptedException {
		
		//initialise driver
		driver = initializeDriver(); 
		driver.get(prop.getProperty("url"));
		
		//initialise Page Objects
		LandingPage l = new LandingPage(driver);
		PopUp p = new PopUp(driver);
		ServicePage sp = new ServicePage(driver);
		PhoneRepairs pr = new PhoneRepairs(driver);
		ProductPage pp = new ProductPage(driver);
		DeliveryPage dp = new DeliveryPage(driver);
		ReusableMethods m = new ReusableMethods(driver);
			
		
		//close popup
		p.getExitPopup().click();
		
		
		//Fix my device
		l.getFixButton().click();
		
		//click Phones
		sp.getPhones().click();
		
		
		//click Samsung
		pr.getSamsung().click();
	
		//Samsung Test
		System.out.println("////////////////SAMSUNG TEST COMMENCING./////////////////");
		
		//print a number of Samsung phones on the main site
		List<WebElement> sButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
		int samsungButtons = sButtons.size();
		//System.out.println("Number of Samsung phones: " + samsungButtons);
		
		//Samsung page - check if service page opens up for each phone
		for (int i=1; i<=samsungButtons; i++) {
			driver.get(prop.getProperty("samsung"));
			driver.findElement(By.xpath("//a[" + i + "]//button[1]")).click();
					
			//save phone name to a variable
			String phoneName = 	pp.getPhone().getText();
			phoneName = phoneName.replaceAll("Repairs", "");
					
			//click on a random number of random repairs
			m.getRandomRepairsMethod();
				
					
			//click Book Repair Now
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", pp.getBookRepair());
								
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
									
					System.out.println(phoneName+" - OK");
									
					}
						
					else {
										
						System.out.println(phoneName+ "- Submit Booking on Page 3 is missing - ERROR!!!!!!");
						}}
									
													
				else {
									
					System.out.println(phoneName + "- BOOKING STEP 2 PAGE ERROR!!!!!");
									
					}}
				
				driver.quit();

	}}

					
				


		
		
		
	
	
	


	

