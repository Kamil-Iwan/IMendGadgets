package mainTests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Resources.base;
import pageObjects.Laptops;
import pageObjects.ProductPage;
import pageObjects.ReusableMethods;
import pageObjects.iPads;


public class iPadBooking extends base{
	
	
	
	@Test
	public void checkiPadBookingPage() throws IOException, InterruptedException {
		
		//initialise driver
		driver = initializeDriver(); 
			
		//initialise Page Objects
		ProductPage pp = new ProductPage(driver);
		iPads ipd = new iPads(driver); 
		ReusableMethods m = new ReusableMethods(driver);
		Laptops lt = new Laptops(driver);
		
		
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
					String ipadNameNoSpace = ipadName.replaceAll("\\s", "");
					//test
					//System.out.println(ipadNameNoSpace); 
					
					//save number of repairs to a variable
					int repairsSize = pp.getAllIpadRepairs().size();
					
				
					//random number of repairs to be generated
					int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
										
					//select a random number of random repairs
					for (int r = 1; r <=randomNumber; r++) {
						int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
						
						
						if (x == 1) {
							
							pp.getAllIpadRepairs().get(randomRepair).click();
						}
						
						else {
						
						driver.findElements(By.cssSelector("." + ipadNameNoSpace + " .wpcf7-list-item")).get(randomRepair).click();
								
					
						}}
					
						
						//click Book Repair Now
						WebElement bookRepairDynamic = driver.findElement(By.cssSelector("div[data-id='" + ipadNameNoSpace + "'] .btn"));
								
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", bookRepairDynamic);
						
						
						//click on Post Your Device
						ipd.getPostYourDevice().click();
						
						//click Proceed With Booking
						executor.executeScript("arguments[0].click();", ipd.getProceedWithBooking());
							
						//test if Submit Button is present
						Boolean isPresent = driver.findElements(By.cssSelector("input[name='your-name']")).size() > 0;
								
						
						if (isPresent) {
							
							System.out.println(ipadName + " OK");	
							
						}
						
						else {
							
							System.out.println(ipadName + " service page error!!!!!");
							
						}}
				
				
				//iPadMini - check if service page opens up
				System.out.println("////////////////IPAD MINI TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("ipadmini"));
				
				List<WebElement> ipmButtons = driver.findElements(By.cssSelector("#ipad-mini-selection-boxes>span"));
				int iPadMiniButtons = ipmButtons.size();
				System.out.println("Number of iPads Mini: " + iPadMiniButtons);
				
				//iterate through all iPads in the category and follow the booking process
				for (int z=1; z<=iPadMiniButtons; z++) {
					driver.get(prop.getProperty("ipadmini"));
					driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipad-mini-selection-boxes']/span[" + z + "]")).click();
								
					String ipadMiniName = driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipad-mini-selection-boxes']/span[" + z + "]/label/span")).getText();
					String ipadMiniNameNoSpace = ipadMiniName.replaceAll("\\s", "");	
					String ipadMiniNameCorrectFormat = "iPadmini"+ipadMiniNameNoSpace.charAt(8);
	
					
					//save number of repairs to a variable
					List<WebElement> iPadMiniAllRepairs = driver.findElements(By.cssSelector("#" + ipadMiniNameCorrectFormat + "-selection-boxes .wpcf7-list-item"));
					int repairsSize = iPadMiniAllRepairs.size();
					
					//random number of repairs to be generated
					int randomNumberMini = ThreadLocalRandom.current().nextInt(0, repairsSize);
					
					//select a random number of random repairs
					for (int y = 1; y <=randomNumberMini; y++) {
						int randomRepairMini = ThreadLocalRandom.current().nextInt(1, repairsSize);
						
						
						driver.findElements(By.cssSelector("." + ipadMiniNameCorrectFormat + " .wpcf7-list-item")).get(randomRepairMini).click();
						}
						
						//run a correct script depending whether the xpath link is written as 'iPadMini' or 'iPadmini'
						List <WebElement> bookRepairCapitalM = driver.findElements(By.cssSelector("div[data-id='" + ipadMiniNameNoSpace + "'] .btn"));
											
						if (bookRepairCapitalM.size() > 0) {
							
						WebElement bookRepairDynamic = driver.findElement(By.cssSelector("div[data-id='" + ipadMiniNameNoSpace + "'] .btn"));
							
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();", bookRepairDynamic);
							
						}
						
						else {
							
							WebElement bookRepairDynamic = driver.findElement(By.cssSelector("div[data-id='" + ipadMiniNameCorrectFormat + "'] .btn"));
							
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();", bookRepairDynamic);
							
						}
						
						//click on Post Your Device
						ipd.getPostYourDevice().click();
						
						//enter Device Unlocking Code
						lt.getEnterDeviceCode().sendKeys("test unlocking code");
						
						//click Proceed With Booking
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", lt.getProceedWithBooking());

						//test if Submit Button is present
						Boolean isSubmitButtonPresent = lt.getSubmitBooking().size() > 0;
							
						
						if (isSubmitButtonPresent) {
							
							System.out.println(ipadMiniName + " OK");
						}
						
						else {
							
							System.out.println(ipadMiniName + " ERROR!!!!");
							
						}}	
				
				
				
				//iPadAir - check if service page opens up
				System.out.println("////////////////IPAD AIR TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("ipadair"));
				
				List<WebElement> ipaButtons = driver.findElements(By.cssSelector("#ipadair-selection-boxes>span"));
				int iPadAirButtons = ipaButtons.size();
				System.out.println("Number of iPads Air: " + iPadAirButtons);
				
				//iterate through all iPads in the category and follow the booking process
				for (int a=1; a<=iPadAirButtons; a++) {
					driver.get(prop.getProperty("ipadair"));
					driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipadair-selection-boxes']/span[" + a + "]")).click();
								
					String ipadAirName = driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipadair-selection-boxes']/span[" + a + "]/label/span")).getText();
					String ipadAirNameNoSpace = ipadAirName.replaceAll("\\s", "");	
							
					//save number of repairs to a variable
					List<WebElement> iPadMiniAllRepairs = driver.findElements(By.cssSelector("#" + ipadAirNameNoSpace + "-selection-boxes .wpcf7-list-item"));
					int repairsSize = iPadMiniAllRepairs.size();
					
					//random number of repairs to be generated
					int randomNumberMini = ThreadLocalRandom.current().nextInt(0, repairsSize);
					
					//select a random number of random repairs
					for (int y = 1; y <=randomNumberMini; y++) {
						int randomRepairMini = ThreadLocalRandom.current().nextInt(1, repairsSize);
						
						
						driver.findElements(By.cssSelector("." + ipadAirNameNoSpace + " .wpcf7-list-item")).get(randomRepairMini).click();
						}
											
						//click on Book Repair					
						WebElement bookRepairDynamic = driver.findElement(By.cssSelector("div[data-id='" + ipadAirNameNoSpace + "'] .btn"));
							
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", bookRepairDynamic);
							
						//click on Post Your Device
						ipd.getPostYourDevice().click();
						
						//enter Device Unlocking Code
						lt.getEnterDeviceCode().sendKeys("test unlocking code");
						
						//click Proceed With Booking
						executor.executeScript("arguments[0].click();", lt.getProceedWithBooking());
						//lt.getProceedWithBooking().click();
						
						//test if Submit Button is present
						Boolean isSubmitButtonPresent = lt.getSubmitBooking().size() > 0;
							
						
						if (isSubmitButtonPresent) {
							
							System.out.println(ipadAirName + " OK");
						}
						
						else {
							
							System.out.println(ipadAirName + " ERROR!!!!");
							
						}}	
				
				
				
				//iPadPro - check if service page opens up
				System.out.println("////////////////IPAD PRO TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("ipadpro"));
				
				List<WebElement> ippButtons = driver.findElements(By.cssSelector("#ipadpro-selection-boxes>span"));
				int iPadProButtons = ippButtons.size();
				System.out.println("Number of iPads Pro: " + iPadProButtons);
				
				
				for (int p=1; p<=iPadProButtons; p++) {
					driver.get(prop.getProperty("ipadpro"));
					driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipadpro-selection-boxes']/span[" + p + "]")).click();
								
					String ipadProName = driver.findElement(By.xpath("//span[@class='wpcf7-form-control wpcf7-radio ipadpro-selection-boxes']/span[" + p + "]/label/span")).getText();
					String ipadProNameNoSpace = ipadProName.replaceAll("\\s", "").replace(".", "").replace("gen", "");
										
					//save number of repairs to a variable
					List<WebElement> iPadMiniAllRepairs = driver.findElements(By.cssSelector("#" + ipadProNameNoSpace + "-selection-boxes .wpcf7-list-item"));
					int repairsSize = iPadMiniAllRepairs.size();
					
					//random number of repairs to be generated
					int randomNumberMini = ThreadLocalRandom.current().nextInt(0, repairsSize);
					
					
					//select a random number of random repairs
					for (int y = 1; y <=randomNumberMini; y++) {
						int randomRepairPro = ThreadLocalRandom.current().nextInt(1, repairsSize);
					
						driver.findElements(By.cssSelector("." + ipadProNameNoSpace + " .wpcf7-list-item")).get(randomRepairPro).click();
						}
						
						
						//click on Book Repair					
						WebElement bookRepairDynamic = driver.findElement(By.cssSelector("div[data-id='" + ipadProNameNoSpace + "'] .btn"));
							
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", bookRepairDynamic);
						
						//click on Post Your Device
						ipd.getPostYourDevice().click();
						
						//enter Device Unlocking Code
						lt.getEnterDeviceCode().sendKeys("test unlocking code");
						
						//click Proceed With Booking
						executor.executeScript("arguments[0].click();", ipd.getProceedWithBooking2());
						
						//test if Submit Button is present
						Boolean isSubmitButtonPresent = lt.getSubmitBooking().size() > 0;
							
						
						if (isSubmitButtonPresent) {
							
							System.out.println(ipadProName + " OK");
						}
						
						else {
							
							System.out.println(ipadProName + " ERROR!!!!");
							
				}}	
				
				
					
				
				driver.quit();
				
			
	
	}}
		
		
		
		
		
		
		
	
	
	


	
