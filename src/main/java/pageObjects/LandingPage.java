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

/*
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	
	public WebDriver driver;
	
	By signin = By.xpath("//ul[contains(@class,'ib-link')]//a[text() = 'Sign In']");
	By welcome = By.cssSelector(".ib-welcome");
	By women = By.xpath("//a[contains(@class,'mm-link') and contains(text(),'Women')]");
	By sneakers = By.xpath("//a[contains(@class, 'sub-category-link') and contains(text(), 'Sneakers')]");
	
	
	
			
	*/