package FlipKart;

import Utils.Xls_Reader;


public class FlipKartDataFeed extends FlipKartActionBase {
	

	public FlipKartDataFeed(FlipKartManager flipKartManager) {
		super(flipKartManager);
		// TODO Auto-generated constructor stub
	}
	
	public Object[][] getFlipKartData(String path,String sheet){
		Xls_Reader xl = new Xls_Reader(path);		
		if(! xl.isSheetExist(sheet)){
			xl=null;
			return new Object[1][0];
		}
	    int i = xl.getRowCount(sheet);
	    int j = xl.getColumnCount(sheet);
	    
	    if (i == 1 ){
	    	xl=null;
			return new Object[1][0];
	    }
	    if (j == 0 ){
	    	xl=null;
			return new Object[1][0];    	
	    }
			    
	    Object[][] obj = new Object[i-1][j];
	    for (int x=2; x<=i; x++){
	    	for(int y =0; y <j ; y++){
	    	 obj[x-2][y] = xl.getCellData(sheet, y, x);	
	    	}
	    	
	    }
	    xl = null;
	    return obj;
		
	}
		
}
