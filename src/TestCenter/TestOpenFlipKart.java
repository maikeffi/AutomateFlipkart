package TestCenter;

import org.testng.annotations.Test;

public class TestOpenFlipKart extends TestBaseFlipKart {
    @Test   	
    public static void openBrowser(){
    	flipKartManager.getFlipKartNavigator().goToMainPage("http://www.flipkart.com/");    	
         
     }
}
