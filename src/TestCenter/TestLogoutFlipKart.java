package TestCenter;

import org.testng.annotations.Test;

public class TestLogoutFlipKart extends TestBaseFlipKart{
	@Test
	public void clikLogOut(){
			
		flipKartManager.getFlipKartGate().logout();
		
	}

}
