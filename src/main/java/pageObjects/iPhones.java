package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class iPhones {
	
	
	public WebDriver driver;
	
	By button= By.xpath("//button[@class='btn-fix']");
	By proceedWithBookingList = By.xpath("//input[@value='Proceed With Booking']");
	
	
	
	
	
	
public iPhones(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
public WebElement getButton() {
		
		return (WebElement) driver.findElements(button); 
	}
	
public List<WebElement> getProceedWithBookingList() {
		
		return driver.findElements(proceedWithBookingList);
	}
	


	
	

	
	

}
