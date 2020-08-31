package mainTests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Resources.base;
import pageObjects.Gadgets;
import pageObjects.Laptops;



public class GadgetsBooking extends base{
	
	
	
	
	@Test
	public void checkGadgetsBookingProcess() throws IOException, InterruptedException {
		
		//initialise driver
		driver = initializeDriver(); 
		
		//initialise Page Objects
		Laptops lt = new Laptops(driver);
		Gadgets g = new Gadgets(driver); 

			
		System.out.println("////////////////GADGETS TEST COMMENCING./////////////////");
		
		driver.get(prop.getProperty("gadgets"));
		
		////print a number of gadgets on the main site
		int gadgetsSize = g.getAllGadgets().size();
				
		//iterate through each gadget and check if the booking process works
		for (int i=1; i<=gadgetsSize; i++) {
			driver.get(prop.getProperty("gadgets"));
			
			//click on a gadget
			WebElement gadget = driver.findElement(By.xpath("//span[@id='gadget-selection-boxes']/span[" + i + "]"));
			
			//wait for a gadget to be clickable
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(gadget));
			
			gadget.click();
			
			//save a gadget name to a variable
			String gadgetName = driver.findElement(By.xpath("//span[@id='gadget-selection-boxes']/span[" + i + "]")).getText();
			String gadgetNameLowCase = gadgetName.toLowerCase().replaceAll("\\s", "-");
			String gadgetsCorrectName = "fillerName";
			
			if (gadgetNameLowCase.equalsIgnoreCase("samsung-galaxy-watch")) {
				
				gadgetsCorrectName = "sg-watch";
			}
			
			else {
				
				gadgetsCorrectName = gadgetNameLowCase;
				
			}
			
			/////////////////Select a random Repair Type/////////////
				
			//save number of repairs to a variable
			int repairsSize = driver.findElements(By.cssSelector("#" + gadgetsCorrectName + "-selection-boxes .wpcf7-list-item")).size();
			
		
			//random number of repairs to be generated
			int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
							
			//select a random number of random repairs
			for (int r = 1; r <=randomNumber; r++) {
				int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
				
				driver.findElements(By.cssSelector("#" + gadgetsCorrectName + "-selection-boxes .wpcf7-list-item")).get(randomRepair).click();
				
				}
				
				//click on Book Repair
				g.getBookRepair().click();
				
				//click on Post Your Device
				lt.getPostYourDevice().click();
				
				//enter Device Unlocking Code
				lt.getEnterDeviceCode().sendKeys("test unlocking code");
				
				//click Proceed With Booking
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", lt.getProceedWithBooking());
				
				
				Boolean isSubmitButtonPresent = lt.getSubmitBooking().size() > 0;
					
				
				if (isSubmitButtonPresent) {
					
					System.out.println(gadgetName + " OK");
				}
				
				else {
					
					System.out.println(gadgetName + " ERROR!!!!");
					
				}}	
	

			
			
	
}}
		
				
				
				
	
				
	

	
				
				
	

		
		
		
		
		
		
		
	
	
	


	
