package FlipKart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.Augmenter;

public class FlipKartDriver  {
	
	WebDriver driver = new FirefoxDriver();
	//WebDriver augmentedDriver = new Augmenter().augment(driver);
	public void dismiss(){
		driver.quit();
	}
	public WebDriver getWebDriver(){
		
		return driver;
	}
	/*public WebDriver getAugmentedDriver(){
		return augmentedDriver;
	}*/

}
