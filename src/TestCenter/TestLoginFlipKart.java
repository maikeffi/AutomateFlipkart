package TestCenter;



import org.testng.annotations.Test;

public class TestLoginFlipKart extends TestBaseFlipKart {
	@Test
	public void clikLogin() throws Exception{
		flipKartManager.getFlipKartGate().login("******", "*****"); //give in your user name and password
		
		
		}

}
