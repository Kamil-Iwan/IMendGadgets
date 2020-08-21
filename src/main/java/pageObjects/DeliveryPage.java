package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryPage {
	
	
	public WebDriver driver;
	
	By repairInStore= By.cssSelector(".wpcf7-list-item.first");
	By proceedWIthBooking = By.xpath("//input[@value='Proceed With Booking']");

	
	
	
	
	
	
	
public DeliveryPage(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getRepairInStore() {
		
		return (WebElement) driver.findElement(repairInStore);
	}
	
public WebElement getProceedWithBooking() {
		
		return (WebElement) driver.findElement(proceedWIthBooking);
	}
	
	

}

