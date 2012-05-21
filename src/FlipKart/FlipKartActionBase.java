package FlipKart;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
//import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class FlipKartActionBase {
	protected FlipKartManager flipKartManager;
	protected WebDriver driver;
	protected Logger logs;
	protected Properties prop = null;
	
	//protected WebDriver augmentedDriver;
    
	public FlipKartActionBase (FlipKartManager flipKartManager){
		this.flipKartManager = flipKartManager;
		driver = flipKartManager.getFlipKartDriver().getWebDriver();
		//augmentedDriver = flipKartManager.getFlipKartDriver().getAugmentedDriver();
	}
	
	protected String getCurrentPageAddress() {
		return driver.getCurrentUrl();
		}
	protected WebElement findElement(String item) throws Exception{
		
		//System.out.println(prop.get(item));
        return driver.findElement(By.xpath(getItem(item)));
	} 
	public void click(String str) throws Exception{
		driver.findElement(By.xpath(getItem(str))).click();
	}
	public void clickAndWait(String str1,String str2) throws Exception{
		driver.findElement(By.xpath(getItem(str1))).click();
		new WebDriverWait(driver , 5).until(ElementIsAvailable(str2));
	}
	public void wait(String str1){
		new WebDriverWait(driver , 5).until(ElementIsAvailable(str1));
	}
     public int findElementsCount(String item) throws Exception{
		
		//System.out.println(prop.get(item));
        List<WebElement> searchResult =  driver.findElements(By.xpath(getItem(item)));
        return searchResult.size();
	}
	public void takeScreenShot(String path) throws Exception{
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(path));
	}

	public Predicate<WebDriver> ElementIsAvailable(final String item){
		return new Predicate<WebDriver>(){
			public boolean apply(WebDriver driver){
				
			try {
		       return findElement(item).isDisplayed();
			} catch (Exception e){
				
				return false;
			}
			
			}
		}; 
	
	}
	
	public boolean IsElementAvailable(String item){
		try {
		       return findElement(item).isDisplayed();
		       
			} catch (Exception e){
				
				return false;
			}
	}
	public void log(String string) throws Exception{
		try{
			
			logs = Logger.getLogger("flipkartlogger");
			logs.debug(string);
						
		}catch (Exception e){
			System.out.println("logging failed");
		}
	}
		
   public String getItem(String item) throws Exception{
	   if (prop == null){ 
			prop = new Properties();
			try {
			FileInputStream  ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\Properties\\flipElement.properties");
			prop.load(ip);
			log("Loading properties file - Successfull");
			}catch(Exception t){
				log("Error in reading properties file");
			}
			
	}
	   
	return prop.getProperty(item);
   }
	
}
