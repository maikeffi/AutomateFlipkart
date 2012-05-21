package TestCenter;



import org.testng.SkipException;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
	    


public class TestAddItemFlipKart extends TestBaseFlipKart {
public Object[][] obj = null;	
     
	@Test(dataProvider = "getData")
	public  void addItem(String item,String price,String runmode) throws Exception {
	        if (runmode.equalsIgnoreCase("Y")){	
 			flipKartManager.getFlipKartNavigator().addItemToCart(item, price);
	        } else {
	        	throw new SkipException("Test data runmode Set to no");
	        }		
	        
		}
	
		
   @DataProvider
	public Object[][] getData(){
	
		obj = flipKartManager.flipKartDataFeed().getFlipKartData(System.getProperty("user.dir")+"\\src\\data\\Testdata.xlsx", "addItem");
//		getInstance().flipKartDataFeed().getFlipKartData("E:\\Temp\\data.xlsx", "Emp Details");	
		return obj;
		
	}
}
