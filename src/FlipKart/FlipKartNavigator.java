package FlipKart;





//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class FlipKartNavigator extends FlipKartActionBase {
	public int count;

	public FlipKartNavigator(FlipKartManager flipKartManager) {
		super(flipKartManager);
		// TODO Auto-generated constructor stub
	}
	
	public void goToMainPage(String url){
		try{
		driver.get(url);
		log("Page is open");
		} catch (Exception e){
			try{
			log("Page open error");
			}catch (Exception s){
				System.out.println("logging error");
			}
		} 
	}
	
    public void searchFlipKart(String item) throws Exception{
    	try{
    	count = findElementsCount("searchResultBox");
    	if (count>0){
    		clickAndWait("homeLink","homePageImg");
    	}
    	count = 0 ;
    	findElement("searchText").sendKeys(item);
    	clickAndWait("searchButton", "homePageImg");
    	
    	takeScreenShot(System.getProperty("user.dir")+"\\src\\ScreenShot\\searchResult"+item+".jpg");
    	log("Searching "+item+"Complete");
    	}catch(Exception e){
    		log("Searching failed");
    	}
    }
    public int searchItemCount(String item) throws Exception{
    	searchFlipKart(item);
    	
    	try{ 
    		wait("searchResultBox");    	  		
    		count = findElementsCount("searchResultBox");
    		log("no of items returned in search "+count);
    		return count;
    	}
    	catch(Exception e){ 
    		log("category not found in flipkart");
    		return 0 ;
    	}
    	
    		
    	}
    public void addItemToCart(String item,String price) throws Exception{
    	try{
    	count = searchItemCount(item);
    	if (count == 0){
    		log(item+" not found");
    		return;
    	}
    	if (count>1){
    		
    		log(item + " has multiple return");
    		return;
    	}
    	clickAndWait("itemLinkimg", "buyThisButton");
    	takeScreenShot(System.getProperty("user.dir")+"\\src\\ScreenShot\\buyScreen"+item+".jpg");
    	clickAndWait("buyThisButton","shoppingCart");
    	wait("shoppingCart");
    	takeScreenShot(System.getProperty("user.dir")+"\\src\\ScreenShot\\addToCart"+item+".jpg");
    	click("continueShoppingButton");
    	clickAndWait("homeLink","homePageImg");
    	log(item+" Added to Shopping cart");
    	}catch (Exception e){
    		log(item+" not added to Shopping cart");
    	}
    }
    
    public void getCartCount() throws Exception{
    	
    		clickAndWait("cartOnHome","shoppingCart");
        	log("Total no of item in Cart "+findElement("cartCount").getText());
    		
    	
    }
    public void getCartAmount() throws Exception{
    	
        		clickAndWait("cartOnHome","shoppingCart");
            	log("Total amount in Cart "+findElement("cartTotalAmount").getText());
            }
       
    }


