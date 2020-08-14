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
import pageObjects.CalendarPage;
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ReusableMethods;
import pageObjects.ServicePage;
import pageObjects.iPhones;


public class checkBookingPage extends base{
	
	
	
	
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
		ReusableMethods rm = new ReusableMethods(); 
		
		
		//close popup
		p.getExitPopup().click();
		
	
		//Fix my device
		l.getFixButton().click();
		
		//click Phones
		sp.getPhones().click();
		
		
		//click Apple
		pr.getApple().click();
	
		System.out.println("////////////////IPHONE TEST COMMENCING./////////////////");
		
		//number of phones
		List<WebElement> iButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
		int iphoneButtons = iButtons.size();
		System.out.println("Number of iPhones: " + iphoneButtons);
		
		
		//iPhone page - check if service page opens up
		for (int i=1; i<=iphoneButtons; i++) {
			driver.get(prop.getProperty("iphone"));
			driver.findElement(By.xpath("//a[" + i + "]//button[1]")).click();
			
			//save phone name to a variable
			
		String phoneName = 	pp.getPhone().getText();
			
		//save number of repairs to a variable
		int repairsSize = pp.getAllRepairs().size();
		
	
		//random number of repairs to be generated
		int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
		//System.out.println("The random number of repairs to be selected:" + randomNumber);
		
			
		//select a random number of random repairs
			for (int r = 1; r <=randomNumber; r++) {
			int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
			//System.out.println("Clicking on repair number: " + randomRepair);
			pp.getAllRepairs().get(randomRepair).click();
			}
		
			//click Book Repair Now
			pp.getBookRepair().click();
			
			
			Boolean isPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
			
			if (isPresent) {
				
				System.out.println(phoneName + " OK");	
				
			}
			
			else {
				
				System.out.println(phoneName + " service page error!!!!!");
				
			}
			
			
					
			
		}
		
				
			
			//Samsung page - check if service page opens up
			System.out.println("////////////////SAMSUNG TEST COMMENCING./////////////////");
			driver.get(prop.getProperty("samsung"));
			List<WebElement> sButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
			int samsungButtons = sButtons.size();
			System.out.println("Number of Samsung phones: " + samsungButtons);
			
			for (int s=1; s<=samsungButtons; s++) {
				driver.get(prop.getProperty("samsung"));
				driver.findElement(By.xpath("//a[" + s + "]//button[1]")).click();
				
				String phoneName = 	pp.getPhone().getText();
				
				//save number of repairs to a variable
				int repairsSize = pp.getAllRepairs().size();
				
			
				//random number of repairs to be generated
				int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
				//System.out.println("The random number of repairs to be selected:" + randomNumber);
				
					
				//select a random number of random repairs
					for (int r = 1; r <=randomNumber; r++) {
					int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
					//System.out.println("Clicking on repair number: " + randomRepair);
					pp.getAllRepairs().get(randomRepair).click();
					}
				
					//click Book Repair Now
					pp.getBookRepair().click();
					
					
					Boolean isPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
					
					if (isPresent) {
						
						System.out.println(phoneName + " OK");	
						
					}
					
					else {
						
						System.out.println(phoneName + " service page error!!!!!");
						
					}
			
			
			
		}

			
			//Huawei page - check if service page opens up
			System.out.println("////////////////HUAWEI TEST COMMENCING./////////////////");
			driver.get(prop.getProperty("huawei"));
			List<WebElement> hButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
			int huaweiButtons = hButtons.size();
			System.out.println("Number of Huawei phones: " + huaweiButtons);
			
			for (int h=1; h<=huaweiButtons; h++) {
				driver.get(prop.getProperty("huawei"));
				driver.findElement(By.xpath("//a[" + h + "]//button[1]")).click();
				
				String phoneName = 	pp.getPhone().getText();
				
				//save number of repairs to a variable
				int repairsSize = pp.getAllRepairs().size();
				
			
				//random number of repairs to be generated
				int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
				//System.out.println("The random number of repairs to be selected:" + randomNumber);
				
					
				//select a random number of random repairs
					for (int r = 1; r <=randomNumber; r++) {
					int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
					//System.out.println("Clicking on repair number: " + randomRepair);
					pp.getAllRepairs().get(randomRepair).click();
					}
				
					//click Book Repair Now
					pp.getBookRepair().click();
					
					
					Boolean isPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
					
					if (isPresent) {
						
						System.out.println(phoneName + " OK");	
						
					}
					
					else {
						
						System.out.println(phoneName + " service page error!!!!!");
						
					}

			
		}
				
				
				
				
				//Google page - check if service page opens up
				System.out.println("////////////////GOOGLE TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("google"));
				List<WebElement> gButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
				int googleButtons = gButtons.size();
				System.out.println("Number of Google phones: " + googleButtons);
				
				for (int g=1; g<=googleButtons; g++) {
					driver.get(prop.getProperty("google"));
					driver.findElement(By.xpath("//a[" + g + "]//button[1]")).click();
								
					String phoneName = 	pp.getPhone().getText();
					
					//save number of repairs to a variable
					int repairsSize = pp.getAllRepairs().size();
					
				
					//random number of repairs to be generated
					int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
					//System.out.println("The random number of repairs to be selected:" + randomNumber);
					
						
					//select a random number of random repairs
						for (int r = 1; r <=randomNumber; r++) {
						int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
						//System.out.println("Clicking on repair number: " + randomRepair);
						pp.getAllRepairs().get(randomRepair).click();
						}
					
						//click Book Repair Now
						pp.getBookRepair().click();
						
						
						Boolean isPresent = driver.findElements(By.cssSelector("#booking-date")).size() > 0;
						
						if (isPresent) {
							
							System.out.println(phoneName + " OK");	
							
						}
						
						else {
							
							System.out.println(phoneName + " service page error!!!!!");
							
						}
			}	
			
	
				
				
				
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
				
				driver.quit();

	}
				
				
	}

		
		
		
		
		
		
		
	
	
	


	

