package pageObjects;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarPage {
	
	
	public WebDriver driver;
	
	By inStore= By.xpath("//input[@value='Repair In Store']");
	By calendar = By.cssSelector("#booking-date");
	By year = By.cssSelector(".xdsoft_year"); 
	By month = By.cssSelector(".xdsoft_month");
	By allYears = By.cssSelector(".xdsoft_yearselect");
	By allMonths = By.cssSelector(".xdsoft_monthselect");
	By allDays = By.xpath("//td/data-date/");
	By calendarText = By.cssSelector(".wpcf7-form-control-wrap .booking-date");

	
	Calendar cal = Calendar.getInstance();
	int currentYear = cal.get(Calendar.YEAR);
	
	public int targetYear = 2020;
	public String targetMonth1 = "October";
	public int targetDay = 25; 
	public String targetTime = "16:30";
	public String targetDateString = "30/08/2020 16:30";
	
	
public CalendarPage(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getInStore() {
		
		return driver.findElement(inStore); 
	}
	
public WebElement getCalendar() {
		
		return driver.findElement(calendar); 
	}

public WebElement getCalendarWE() {
	
	return (WebElement) driver.findElements(calendar); 
}



public WebElement getYear() {
	
	return driver.findElement(year); 
}

public WebElement getAllYears() {
	
	return (WebElement) driver.findElements(allYears); 
}

public WebElement getAllMonths() {
	
	return (WebElement) driver.findElements(allMonths); 
}

public WebElement getAllDays() {
	
	return (WebElement) driver.findElements(allDays); 
}

public WebElement getMonth() {
	
	return driver.findElement(month); 
}

public WebElement getCalendarText() {
	
	return driver.findElement(calendarText); 
}

	
	


 
	

	
	

}

