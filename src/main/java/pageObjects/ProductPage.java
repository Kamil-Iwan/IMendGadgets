package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	
	
	public WebDriver driver;
	
	By photo= By.cssSelector(".mission-img");
	By phone = By.xpath("//div[@class='mission']//h1");
	By allRepairs= By.className("wpcf7-list-item");
	By bookRepair= By.xpath("//input[@type='submit']");
	By ipadAllRepairs = By.xpath("//span[@class='wpcf7-form-control wpcf7-checkbox iPad6-selection-boxes']/span");
	By ipadBookRepair = By.xpath("//*[@id=\"wpcf7-f1412-p396-o1\"]/form/div[4]/div/div/p[3]");
	By inputText = By.xpath("//input[@type='text']");
	
	
	
	
	
	
	
public ProductPage(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getPhoto() {
		
		return (WebElement) driver.findElement(photo);
	}
	
public WebElement getPhone() {
		
		return (WebElement) driver.findElement(phone);
	}
public List<WebElement> getAllRepairs() {
	
	return driver.findElements(allRepairs);
}

	
public WebElement getBookRepair() {
	
	return (WebElement) driver.findElement(bookRepair);
}

public List<WebElement> getAllIpadRepairs() {
	
	return driver.findElements(ipadAllRepairs);
}

public WebElement getIpadBookRepair() {
	
	return (WebElement) driver.findElement(ipadBookRepair);

		
}

public WebElement getInputText() {
	
	return (WebElement) driver.findElement(inputText);

		
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