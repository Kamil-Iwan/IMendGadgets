package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactDetailsPage {
	
	
	public WebDriver driver;
	
	By yourName= By.xpath("//input[@name='your-name']");
	
	

	
	
	
	
	
	
	
public ContactDetailsPage(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getYourName() {
		
		return (WebElement) driver.findElement(yourName);
	}
	

	
	

}

