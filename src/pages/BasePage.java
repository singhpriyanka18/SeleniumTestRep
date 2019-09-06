package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.TestUtil;

public class BasePage {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	 
    public BasePage()
    {}
    
    public static void Initialization()
    {
    	  System.getProperty("user.dir");
    	  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\webdrivers\\geckodriver.exe");
    	
    	  driver = new FirefoxDriver();
    	  js = (JavascriptExecutor) driver; 
    	  
    	  String baseUrl = "https://signup.heroku.com/";
         
          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
          
          driver.get(baseUrl);
               
          driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
          
    }
	public boolean signUpUrl() throws InterruptedException {
	String actualTitle = "";
	String expectedTitle = "Heroku | Sign up";
	
	actualTitle =  js.executeScript("return document.title;").toString();
    
    if (actualTitle.contentEquals(expectedTitle)){
        System.out.println("You have reached the signup URL!");
        driver.close();
        return true;
      } 
        System.out.println("Could not open this URL");
        driver.close();
        return false;
        
	}
    
}
