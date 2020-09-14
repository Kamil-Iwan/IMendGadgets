package pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class sampleObjects {
	
	
	public WebDriver driver;
	
	By popup = By.cssSelector(".cc-dismiss");
	By inputField = By.cssSelector("#courseSearchInput");

	
	
	
	
	

	
	
public sampleObjects(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	

public WebElement getPopup() {
	
	return driver.findElement(popup); 
}


public WebElement getInputField() {
	
	return driver.findElement(inputField); 
}

	
	


 
	

	
	

}