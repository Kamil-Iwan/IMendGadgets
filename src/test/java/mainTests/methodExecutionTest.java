package mainTests;

import org.testng.annotations.Test;
import java.io.IOException;
import Resources.base;
import pageObjects.CalendarPage;
import pageObjects.LandingPage;
import pageObjects.PhoneRepairs;
import pageObjects.PopUp;
import pageObjects.ProductPage;
import pageObjects.ReusableMethods;
import pageObjects.ServicePage;
import pageObjects.iPhones;

public class methodExecutionTest extends base {

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {

		// initialise driver
		driver = initializeDriver();
		// driver.get(prop.getProperty("url"));

		// initialise Page Objects
		LandingPage l = new LandingPage(driver);
		PopUp p = new PopUp(driver);
		ServicePage sp = new ServicePage(driver);
		PhoneRepairs pr = new PhoneRepairs(driver);
		iPhones ip = new iPhones(driver);
		ProductPage pp = new ProductPage(driver);
		CalendarPage c = new CalendarPage(driver);

		ReusableMethods m = new ReusableMethods(driver);

		m.getRandomRepairsMethod();

	}
}
