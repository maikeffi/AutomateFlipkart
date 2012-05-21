package FlipKart;

public class FlipKartManager {
	private static FlipKartManager flipKartManager;
	private FlipKartDriver flipKartDriver;
	private FlipKartNavigator flipKartNavigator;
	private FlipKartGate flipKartGate;
	private FlipKartDataFeed flipKartDataFeed;
	
	
	public static FlipKartManager getInstance(){
		 if (flipKartManager == null)
			 flipKartManager = new FlipKartManager();
		 return flipKartManager;
	}
	
	public FlipKartDriver getFlipKartDriver(){
		if (flipKartDriver == null){ 
				flipKartDriver = new FlipKartDriver();
		}
		return flipKartDriver;
	}
	
	public FlipKartNavigator getFlipKartNavigator(){
		if (flipKartNavigator == null){
			flipKartNavigator = new FlipKartNavigator(this);
		}
		return flipKartNavigator; 
	}
	
	public FlipKartDataFeed flipKartDataFeed(){
		if (flipKartDataFeed == null){
			flipKartDataFeed = new FlipKartDataFeed(this);
		}
		return flipKartDataFeed; 
	}
	
	public FlipKartGate getFlipKartGate(){
		if (flipKartGate == null){
			flipKartGate = new FlipKartGate(this);
		}
		return flipKartGate; 
	}
	
	
	public void kill(){
		if (flipKartDriver != null){ 
			flipKartDriver.dismiss();
     	}
		
	}

}
