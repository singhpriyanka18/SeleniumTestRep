package tests;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import junit.framework.Assert;
import pages.BasePage;

public class BasePageTest extends BasePage{
	
	static BasePage Basepageobj;

			
	public BasePageTest() throws IOException {
		super();
	}

	@BeforeClass
	public static void SetUp() {
		Initialization();
		Basepageobj = new BasePage();
	}

	//Catch and throw exception on reaching the Heroku registration page URL
	@Test
	public void UrlTest() throws InterruptedException {
		try {
		Assert.assertTrue("Sorry, could not reach the Signup URL", Basepageobj.signUpUrl());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
		 

}
