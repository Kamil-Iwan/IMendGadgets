package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingStep3 {
	
	
	public WebDriver driver;
	
	By submitBooking= By.xpath("//input[@value='Submit Booking']");
	
	public BookingStep3(WebDriver driver) {
		this.driver = driver; 
		
	}



public WebElement getSubmitBooking() {
	
	return driver.findElement(submitBooking); 
}
		
	

}