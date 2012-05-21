package TestCenter;



import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestSearchFlipKart extends TestBaseFlipKart {

	@Test(dataProvider = "getData")
	public  void searchItem(String item,String runmode) throws Exception {
		if (runmode.equalsIgnoreCase("Y")){
		flipKartManager.getFlipKartNavigator().searchItemCount(item);
		}else {
        	throw new SkipException("Test data runmode Set to no");
        }	
			
	}
	
    @DataProvider
	public Object[][] getData(){
		Object[][] obj = null;	    
		obj = flipKartManager.flipKartDataFeed().getFlipKartData(System.getProperty("user.dir")+"\\src\\data\\Testdata.xlsx", "search");
//		getInstance().flipKartDataFeed().getFlipKartData("E:\\Temp\\data.xlsx", "Emp Details");	
		return obj;
		
	}
	 

}
