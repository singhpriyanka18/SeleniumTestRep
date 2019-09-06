package tests;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import junit.framework.Assert;
import pages.BasePage;
import pages.SignupPage;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignupPageTest extends BasePage{
	
	static SignupPage Signuppageobj;
		
	public SignupPageTest() throws IOException {
		super();
	}

	@BeforeClass
	public static void SetUp() throws InterruptedException {
		Initialization();
		Signuppageobj = new SignupPage();
	}
	
	@Test
	public void case01_FirstnameTest() throws InterruptedException {
		try {
		Assert.assertTrue("Error entering First name", Signuppageobj.validateFirstname());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
	@Test
	public void case02_LastnameTest() throws InterruptedException {
		try {
		Assert.assertTrue("Error entering Last name", Signuppageobj.validateLastname());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
	@Test
	public void case03_EmailTest() throws InterruptedException {
		try {
		Assert.assertTrue("Error entering Email address", Signuppageobj.validateEmail());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
	@Test
	public void case04_CompanyTest() throws InterruptedException {
		try {
		Assert.assertTrue("Error entering Company name", Signuppageobj.validateCompany());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
	@Test
	public void case05_RoleTest() throws InterruptedException {
		try {
		Assert.assertTrue("Error selecting Role from drodown", Signuppageobj.validateRole());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
	@Test
	public void case06_CountryTest() throws InterruptedException {
		try {
		Assert.assertTrue("Error selecting Country from drodown", Signuppageobj.validateCountry());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
	@Test
	public void case07_LanguageTest() throws InterruptedException {
		try {
		Assert.assertTrue("Error selecting Language from drodown", Signuppageobj.validateLanguage());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}

	//Catch and throw exception while doing registration
	@Test
	public void case08_FieldsTest() throws InterruptedException {
		try {
		Assert.assertTrue("Signup Failed-All fields are not filled in", Signuppageobj.validateSignup());
		}
		catch (IllegalStateException e) {
            Assert.assertFalse(e.getMessage(), Boolean.TRUE);
        } 

	}
		 

}
