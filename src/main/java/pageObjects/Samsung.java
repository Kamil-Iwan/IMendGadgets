package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Samsung {
	
	
	public WebDriver driver;
	
	By button= By.xpath("//button[@class='btn-fix']");
	
	
	
	
	
	
public Samsung(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getButton() {
		
		return (WebElement) driver.findElements(button); 
	}
	


	
	

	
	

}
