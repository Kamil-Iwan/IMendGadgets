package pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	By calendarPrev = By.cssSelector(".xdsoft_timepicker .xdsoft_prev");
	By calendarNext = By.cssSelector(".xdsoft_timepicker .xdsoft_next");
	By checkDate = By.cssSelector(".wpcf7-form-control-wrap .booking-date");
	

	
	public int targetYear = 2020;
	public String targetMonth1 = "November";
	public int targetDay = 15; 
	public String targetTime = "16:00";
	
	int monthAsInteger;
	
	
	public int MonthAsIntegerMethod() throws ParseException {
	Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(targetMonth1);
	 Calendar cal = Calendar.getInstance();
	 cal.setTime(date);
	 return monthAsInteger = cal.get(Calendar.MONTH)+1;
	}
	

	
	
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

public WebElement getCalendarPrev() {
	
	return driver.findElement(calendarPrev); 
}

public WebElement getCalendarNext() {
	
	return driver.findElement(calendarNext); 
}

public WebElement getCheckDate() {
	
	return driver.findElement(checkDate); 
}

	
	


 
	

	
	

}