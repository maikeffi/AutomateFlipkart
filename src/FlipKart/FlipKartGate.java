package FlipKart;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;




public class FlipKartGate extends FlipKartActionBase {
	
	public FlipKartGate(FlipKartManager flipKartManager) {
		super(flipKartManager);
		// TODO Auto-generated constructor stub
	}
	public void login(String usr,String pwd) throws Exception{
		
		
		try{
			findElement("loginLink").click();
			findElement("emailText").sendKeys(usr);
			findElement("passText").sendKeys(pwd);	
			findElement("loginButton").click();
			new WebDriverWait(driver , 15).until(ElementIsAvailable("homePageImg"));
			takeScreenShot(System.getProperty("user.dir")+"\\src\\ScreenShot\\login.jpg");
			log("Login Success");
			
		}catch (TimeoutException t){
			if (findElement("loginErrMsg").isDisplayed()){
				try{
				log(findElement("loginErrMsg").getText());
				}catch (Exception e){
					System.out.println("Logger failed");
				} 
			}else{
				try{
					log("Page Timed out");
					}catch (Exception e){
						System.out.println("Logger failed");	
					}
			}
		}catch (NoSuchElementException e){
			try{
				log("Page not Launched");
				}catch (Exception s){
					System.out.println("Logger failed");	
				}
		}catch(Exception e){
			System.out.println("screenshot failed");
		}
		
		}
	public void logout(){
		
			try{
				findElement("homePageImg").click();
				new WebDriverWait(driver , 5).until(ElementIsAvailable("logoutLink"));
				findElement("logoutLink").click();
				new WebDriverWait(driver , 10).until(ElementIsAvailable("loginLink"));
				log("Logout Success");
				takeScreenShot(System.getProperty("user.dir")+"\\src\\ScreenShot\\logout.jpg");
			}catch (TimeoutException e){
				System.out.println("Page timed out");
			}catch (NoSuchElementException e){
				System.out.println("Page not logged in");
			}catch(Exception e){
				System.out.println("screenshot failed");
			}
		
		
	}

}
