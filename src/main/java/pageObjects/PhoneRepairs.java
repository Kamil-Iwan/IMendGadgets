package pageObjects;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhoneRepairs {
	
	
	public WebDriver driver;
	
	By apple= By.xpath("//h4[contains(text(),'Apple')]");
	
	
	
	ProductPage pp = new ProductPage(driver);
	
public PhoneRepairs(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getApple() {
		
		return driver.findElement(apple); 
	}
	


	

	

}

