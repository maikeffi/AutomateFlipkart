package TestCenter;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeSuite;

import FlipKart.FlipKartManager;



public class TestBaseFlipKart {
	
	protected static FlipKartManager flipKartManager;
	
	@BeforeClass
	public void setUp() throws Exception{
		flipKartManager = FlipKartManager.getInstance();
	
	} 
	
	@AfterSuite
	public void shutDown() throws Exception{
		flipKartManager.kill();
	
	}
	

}
