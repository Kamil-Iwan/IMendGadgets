package pageObjects;

import java.util.concurrent.ThreadLocalRandom;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.base;



public class ReusableMethods extends base{
	
	public WebDriver driver;
	
	public ReusableMethods(WebDriver driver) {
		this.driver = driver; 
		
	}




	public void getRandomRepairsMethod() {
		ProductPage pp = new ProductPage(driver);
				
		//get the size of all available repairs
		int repairsSize = pp.getAllRepairs().size();
		
		//System.out.println(repairsSize); 
		
		//random number of repairs to be generated
		int randomNumber = ThreadLocalRandom.current().nextInt(0, repairsSize);
		//System.out.println("The random number of repairs to be selected:" + randomNumber);
					
						
		//select a random number of random repairs
		for (int r = 1; r <=randomNumber; r++) {
		int randomRepair = ThreadLocalRandom.current().nextInt(1, repairsSize);
		//System.out.println("Clicking on repair number: " + randomRepair);
		pp.getAllRepairs().get(randomRepair).click();
				
		
	}

	
	

}
}
