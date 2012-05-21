package TestCenter;



import org.testng.annotations.Test;

public class TestCheckCartFlipKart extends TestBaseFlipKart {
	@Test
	public void CheckCart() throws Exception{
		flipKartManager.getFlipKartNavigator().getCartCount(); 
		flipKartManager.getFlipKartNavigator().getCartAmount();
		
		}

}
