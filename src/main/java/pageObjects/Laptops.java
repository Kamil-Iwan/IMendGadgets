package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Laptops {
	
	
	public WebDriver driver;
	
	By apple = By.xpath("//input[@value='Apple']//parent::label");
	By dell = By.xpath("//input[@value='Dell']//parent::label");
	By lenovo = By.xpath("//input[@value='Lenovo']//parent::label");
	By asus = By.xpath("//input[@value='ASUS']//parent::label");
	By HP = By.xpath("//input[@value='HP']//parent::label");
	By other = By.xpath("//input[@value='Other']//parent::label");
	By appleType = By.cssSelector("div[data-id='apple'] .pd-form-label");
	By dellType = By.cssSelector("div[data-id='dell'] .pd-form-label");
	By lenovoType = By.cssSelector("div[data-id='lenovo'] .pd-form-label");
	By asusType = By.cssSelector("div[data-id='asus'] .pd-form-label");
	By HPType = By.cssSelector("div[data-id='hp'] .pd-form-label");
	By otherType = By.cssSelector("div[data-id='other'] .pd-form-label");
	By bookRepair = By.cssSelector("input[value='Book Repair']");
	By proceedWithBooking = By.xpath("//input[@value='Proceed With Booking']");
	
	
	
	
public Laptops(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	

	
public WebElement getApple() {
	
	return driver.findElement(apple); 
}

public WebElement getDell() {
	
	return driver.findElement(dell); 
}

public WebElement getLenovo() {
	
	return driver.findElement(lenovo); 
}

public WebElement getAsus() {
	
	return driver.findElement(asus); 
}

public WebElement getHP() {
	
	return driver.findElement(HP); 
}

public WebElement getOther() {
	
	return driver.findElement(other); 
}


public WebElement getAppleType() {
	
	return driver.findElement(appleType); 
}

public WebElement getDellType() {
	
	return driver.findElement(dellType); 
}

public WebElement getLenovoType() {
	
	return driver.findElement(lenovoType); 
}

public WebElement getAsusType() {
	
	return driver.findElement(asusType); 
}

public WebElement getHPType() {
	
	return driver.findElement(HPType); 
}

public WebElement getOtherType() {
	
	return driver.findElement(otherType); 
}

public WebElement getBookRepair() {
	
	return driver.findElement(bookRepair); 
}

public WebElement getProceedWithBooking() {
	
	return driver.findElement(proceedWithBooking); 
}

	
	

	
	

}

