package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class iPads {
	
	
	public WebDriver driver;
	
	By proceedWithBooking= By.xpath("//input[@value='Proceed With Booking']");
	By postYourDevice = By.xpath("//input[@value='Post Your Device']"); 
	By yourName = By.xpath("//input[@name=''your-name']");
	By proceedWithBooking2 = By.cssSelector(".booking-align-section .btn");

	
	
	
	
	
	
public iPads(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getProceedWithBooking() {
		
		return driver.findElement(proceedWithBooking); 
	}
	
public WebElement getPostYourDevice() {
		
		return driver.findElement(postYourDevice); 
	}

public WebElement getYourName() {
	
	return driver.findElement(yourName); 
}

public WebElement getProceedWithBooking2() {
	
	return driver.findElement(proceedWithBooking2); 
}
	


	
	

	
	

}