package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUp {
	
	
	public WebDriver driver;
	
	By exitPopup= By.cssSelector(".popmake-close");
	
	
	
	
public PopUp(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getExitPopup() {
		
		return driver.findElement(exitPopup); 
	}

}
