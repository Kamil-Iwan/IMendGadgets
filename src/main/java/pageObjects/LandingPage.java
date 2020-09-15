package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	By fixButton=By.cssSelector(".fa-tools");
	By footerLinks = By.cssSelector("footer[aria-hidden='false'] a[href]");
	By headerLinks = By.cssSelector(".container-nav a[href]");
	
	
	
	
public LandingPage(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	

	
public WebElement getFixButton() {
		
		return driver.findElement(fixButton); 
	}

public List<WebElement> getFootherLinks() {
	
	return driver.findElements(footerLinks);
}

public List<WebElement> getHeaderLinks() {
	
	return driver.findElements(headerLinks);
}
	
	
	

	
	

}
