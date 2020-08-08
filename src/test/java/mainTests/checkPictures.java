package mainTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
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
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ServicePage;
import pageObjects.iPhones;


public class checkPictures extends base{
	
	
	
	
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
		
		
		//iPhone page - check if photos are present
		for (int i=1; i<=iphoneButtons; i++) {
			driver.get(prop.getProperty("iphone"));
			driver.findElement(By.xpath("//a[" + i + "]//button[1]")).click();
			
			if (pp.getPhoto().isDisplayed()) {
				System.out.println("Photo present for: " + pp.getPhone().getText());
				
			} else {
				System.out.println("!!!ERROR!!! Could not find a photo for: " + pp.getPhone().getText());
		
			}}
			
			System.out.println("////////////////IPHONE TEST COMPLETED./////////////////");
			
			
			
			//Samsung page - check if photos are present
			System.out.println("////////////////SAMSUNG TEST COMMENCING./////////////////");
			driver.get(prop.getProperty("samsung"));
			List<WebElement> sButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
			int samsungButtons = sButtons.size();
			System.out.println("Number of Samsung phones: " + samsungButtons);
			
			for (int s=1; s<=samsungButtons; s++) {
				driver.get(prop.getProperty("samsung"));
				driver.findElement(By.xpath("//a[" + s + "]//button[1]")).click();
				
				if (pp.getPhoto().isDisplayed()) {
					System.out.println("Photo present for: " + pp.getPhone().getText());
					
				} else {
					System.out.println("!!!ERROR!!! Could not find a photo for: " + pp.getPhone().getText());
			
				}	
			
			
			
		}
			System.out.println("////////////////SAMSUNG TEST COMPLETED./////////////////");
			
			//Huawei page - check if photos are present
			System.out.println("////////////////HUAWEI TEST COMMENCING./////////////////");
			driver.get(prop.getProperty("huawei"));
			List<WebElement> hButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
			int huaweiButtons = hButtons.size();
			System.out.println("Number of Huawei phones: " + huaweiButtons);
			
			for (int h=1; h<=huaweiButtons; h++) {
				driver.get(prop.getProperty("huawei"));
				driver.findElement(By.xpath("//a[" + h + "]//button[1]")).click();
				
				if (pp.getPhoto().isDisplayed()) {
					System.out.println("Photo present for: " + pp.getPhone().getText());
					
				} else {
					System.out.println("!!!ERROR!!! Could not find a photo for: " + pp.getPhone().getText());
			
				}
			}
			
				System.out.println("////////////////HUAWEI TEST COMPLETED./////////////////");
		
				
				
				//Google page - check if photos are present
				System.out.println("////////////////GOOGLE TEST COMMENCING./////////////////");
				driver.get(prop.getProperty("google"));
				List<WebElement> gButtons = driver.findElements(By.xpath("//button[@class='btn-fix']"));
				int googleButtons = gButtons.size();
				System.out.println("Number of Google phones: " + googleButtons);
				
				for (int g=1; g<=googleButtons; g++) {
					driver.get(prop.getProperty("google"));
					driver.findElement(By.xpath("//a[" + g + "]//button[1]")).click();
					
					if (pp.getPhoto().isDisplayed()) {
						System.out.println("Photo present for: " + pp.getPhone().getText());
						
					} else {
						System.out.println("!!!ERROR!!! Could not find a photo for: " + pp.getPhone().getText());
				
					}
				}
				
					System.out.println("////////////////GOOGLE TEST COMPLETED./////////////////");
					
		driver.quit();
		
	}
}
		
		
		
		
		
		
	
	
	


	

