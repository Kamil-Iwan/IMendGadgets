package pageObjects;

import java.util.concurrent.ThreadLocalRandom;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ReusableMethods {
	
	public WebDriver driver;
	

	ProductPage pp = new ProductPage(driver);
	
	
	public void getRepairsMethod () {
		driver = initializeDriver(); 
		
		System.out.println("Test klasy kierwa.");
		
		
	//save number of repairs to a variable
		int repairsSize = pp.getAllRepairs().size();
				
		//random number of repairs to be generated
		int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
		System.out.println("The random number of repairs to be selected:" + randomNumber);
			
				
		//select a random number of random repairs
		for (int r = 1; r <=randomNumber; r++) {
		int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
		System.out.println("Clicking on repair number: " + randomRepair);
		pp.getAllRepairs().get(randomRepair).click();
		
		
}


	}


	private WebDriver initializeDriver() {
		// TODO Auto-generated method stub
		return null;
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