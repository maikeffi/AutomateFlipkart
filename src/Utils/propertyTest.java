package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
     String item = "loginLink";
     Properties prop = null; 
		if (prop == null){ 
			prop = new Properties();
			try {
			FileInputStream  ip = new FileInputStream("E:\\Selenium webdriver\\Web_testing\\src\\Properties\\flipElement.properties");
			prop.load(ip);
			System.out.println("Loading properties file - Successfull");
			}catch(Exception t){
				System.out.println("Error in reading properties file");
			}
			
			System.out.println("\""+item+"\"");
	}

	}

}
