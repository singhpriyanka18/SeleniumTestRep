package pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import util.TestUtil;

public class SignupPage extends BasePage{
	
	public static Properties signupprop;

	WebElement first_name = (WebElement) js.executeScript("return document.getElementById('first_name');");
	WebElement last_name = (WebElement) js.executeScript("return document.getElementById('last_name');");
	WebElement email = (WebElement) js.executeScript("return document.getElementById('email');");
	WebElement company = (WebElement) js.executeScript("return document.getElementById('company');");
	Select role = new Select(driver.findElement(By.name("role")));
	Select self_declared_country = new Select(driver.findElement(By.name("self_declared_country")));
	Select main_programming_language = new Select(driver.findElement(By.name("main_programming_language")));
	
	WebElement commit = (WebElement) js.executeScript("return document.getElementsByName('commit')[0];");
	
	@FindBy(xpath="//p[contains(@id,'fill-all-fields')]")
	WebElement erralert;
	
	//Initialize all the web elements above
	public SignupPage() {
		PageFactory.initElements(driver, this); 
		
	}
	public boolean validateFirstname() throws InterruptedException{
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
        first_name.sendKeys("John");
        Thread.sleep(2000);
        String getFirstname =  js.executeScript("return document.getElementById('first_name').value;").toString();
        if (getFirstname.contentEquals("")){
        	return false;
        }
		return true;
		
	}
	public boolean validateLastname() throws InterruptedException{
		Thread.sleep(1000);
        last_name.sendKeys("Jacobs");
        Thread.sleep(2000);
        String getLastname =  js.executeScript("return document.getElementById('last_name').value;").toString();
        if (getLastname.contentEquals("")){
        	return false;
        }
		return true;
		
	}
	// Let's leave the email field empty, and check the test failure
	public boolean validateEmail() throws InterruptedException{
		Thread.sleep(1000);
        //email.sendKeys("Jacobs123John@gmail.com");
        //Thread.sleep(2000);
        String getEmail =  js.executeScript("return document.getElementById('email').value;").toString();
        if (getEmail.contentEquals("")){
        	return false;
        }
		return true;
		
	}
	public boolean validateCompany() throws InterruptedException{
		Thread.sleep(1000);
        company.sendKeys("JacobsJohn Limited");
        Thread.sleep(2000);
        String getCompany =  js.executeScript("return document.getElementById('company').value;").toString();
        if (getCompany.contentEquals("")){
        	return false;
        }
		return true;
		
	}
	public boolean validateRole() throws InterruptedException{
		Thread.sleep(1000);
        role.selectByValue("professional_developer");
        Thread.sleep(2000);
        String getRole =  js.executeScript("return document.getElementById('role').value;").toString();
        if (getRole.contentEquals("")){
        	return false;
        }
		return true;
		
	}
	public boolean validateCountry() throws InterruptedException{
		Thread.sleep(1000);
        self_declared_country.selectByValue("Canada");
        Thread.sleep(2000);
        String getCountry =  js.executeScript("return document.getElementById('self_declared_country').value;").toString();
        if (getCountry.contentEquals("")){
        	return false;
        }
		return true;
	}
	public boolean validateLanguage() throws InterruptedException{
		Thread.sleep(1000);
        main_programming_language.selectByValue("java");
        Thread.sleep(2000);
        String getLanguage =  js.executeScript("return document.getElementById('main_programming_language').value;").toString();
        if (getLanguage.contentEquals("")){
        	return false;
        }
		return true;
	}
	
	// If email field (or any other field(s) is(are) empty, the test case for this methos should also fail
	public boolean validateSignup() throws InterruptedException
	{
		Thread.sleep(2000);
        js.executeScript("arguments[0].click();", commit);
        Thread.sleep(3000);
        if(erralert.getText().equals(null) || erralert.getText().equals("")) {
        	System.out.println("All fields are filled properly!");
        	driver.close();
        	return true;
        }
        System.out.println("You did not fill all the details!");
        driver.close();
		return false;
		
	}
}
