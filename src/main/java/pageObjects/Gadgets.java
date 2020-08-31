package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gadgets {
	
	
	public WebDriver driver;
	

	By allGadgets = By.cssSelector("#gadget-selection-boxes>span");
	By bookRepair = By.xpath("//input[@value='Book Repair']");
	
	
	
	
	
	public Gadgets(WebDriver driver) {
		this.driver = driver; 
		
	}
	

	public List<WebElement> getAllGadgets() {
		
		return driver.findElements(allGadgets);
	}

	
public WebElement getBookRepair() {
		
		return driver.findElement(bookRepair); 
	}

	
	

}
