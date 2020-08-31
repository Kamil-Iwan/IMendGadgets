package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	By fixButton=By.cssSelector(".fa-tools");
	
	
	
	
public LandingPage(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	

	
public WebElement getFixButton() {
		
		return driver.findElement(fixButton); 
	}
	
	

	
	

}
