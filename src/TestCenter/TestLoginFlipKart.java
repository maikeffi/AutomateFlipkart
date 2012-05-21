package TestCenter;



import org.testng.annotations.Test;

public class TestLoginFlipKart extends TestBaseFlipKart {
	@Test
	public void clikLogin() throws Exception{
		flipKartManager.getFlipKartGate().login("maikeffi@gmail.com", "Axshan@2"); //give in your user name and password
		
		
		}

}
