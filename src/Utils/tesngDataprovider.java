package Utils;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tesngDataprovider {
	

	/**
	 * @param args
	 */
	@Test(dataProvider = "getData")
	public  void test1(String empId,String name,String qua,String des,String country) {
			
			  	    
	    System.out.println(empId+"--"+name+"--"+qua+"--"+des+"--"+country);
	    


		
	}
	
	@DataProvider
	public Object[][] getData(){
		Xls_Reader xl = new Xls_Reader("E:\\Temp\\data.xlsx");		
		Object[][] obj = new Object[3][5];
		
	    int i = xl.getRowCount("Emp Details");
	    int j = xl.getColumnCount("Emp Details");
		
	    System.out.println("Row Count = " + i );
	    System.out.println("Column Count = " + j );
	  //  System.out.println(xl.getCellData("Emp Details", 0, 1));
	    
	    for (int x=2; x<=i; x++){
	    	for(int y =0; y <j ; y++){
	    	 obj[x-2][y] = xl.getCellData("Emp Details", y, x);	
	    	}
	    	
	    }
	
		
		return obj;
		
	}
	 

}
