package pageObjects;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhoneRepairs {
	
	
	public WebDriver driver;
	
	By apple= By.xpath("//h4[contains(text(),'Apple')]");
	By samsung = By.xpath("//h4[contains(text(),'Samsung')]");
	By huawei = By.xpath("//h4[contains(text(),'Huawei')]");
	By google = By.xpath("//h4[contains(text(),'Google')]");
	
	
	ProductPage pp = new ProductPage(driver);
	
public PhoneRepairs(WebDriver driver) {
	this.driver = driver; 
	
}
	
	
	public WebElement getApple() {
		
		return driver.findElement(apple); 
	}
	
public WebElement getSamsung() {
		
		return driver.findElement(samsung); 
	}

public WebElement getHuawei() {
	
	return driver.findElement(huawei); 
}

public WebElement getGoogle() {
	
	return driver.findElement(google); 
}
	


	

	

}

