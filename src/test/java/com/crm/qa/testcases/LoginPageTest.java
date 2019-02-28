package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegistrationPage;
import com.crm.qa.util.TestUtil;

import dataprovider.JSON_data_provider;

public class LoginPageTest extends TestBase{
	
	public static String testName;
	LoginPage loginPage;
	HomePage homePage;
	RegistrationPage registrationPage;
	SoftAssert softassert;
	
	String sheetName = "Register";
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		registrationPage = new RegistrationPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1,enabled=false)
	public void loginPageTitleTest(){
		softassert = new SoftAssert();
		String title = loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "Welcome: Mercury Tours");
		softassert.assertEquals(title, "Welcome: Mercury Tours");
		softassert.assertAll();
	}
	
	@Test(priority=2,enabled=false)
	public void navigateRegistrationPage(){
		softassert = new SoftAssert();
		loginPage.clkRegister();
		String Registrationtitle=loginPage.validateLoginPageTitle();
		System.out.println("The Registration Page title is "+Registrationtitle);
		//Assert.assertEquals(Registrationtitle, "Register: Mercury Tours");
		softassert.assertEquals(Registrationtitle, "Register: Mercury Tours");
		softassert.assertAll();
	}
	
	
	@DataProvider
	public Object[][] getRegistrationdata(){
		Object data[][] = TestUtil.getRegistrationdata(sheetName);
		return data;
	}
	
	@Test(priority=3,enabled=false,dataProvider="getRegistrationdata")
	public void setcontactInfo(String FirstNameinfo,String LastNameinfo,String Phoneinfo,String Emailinfo)
	{
		softassert = new SoftAssert();
		loginPage.clkRegister();
		String Registrationtitle=loginPage.validateLoginPageTitle();
		System.out.println("The Registration Page title is "+Registrationtitle);
		registrationPage.setContactInformation(FirstNameinfo,LastNameinfo,Phoneinfo,Emailinfo);
		softassert.assertEquals(Registrationtitle, "Register: Mercury Tours");
		softassert.assertAll();
	}
	
	
	
	 @Test(priority=4,enabled=true,dataProvider="jsonRead",dataProviderClass= JSON_data_provider.class)
	public void setcontactJson(String FirstNameinfo,String LastNameinfo,String Phoneinfo,String Emailinfo)
	{
		softassert = new SoftAssert();
		loginPage.clkRegister();
		String Registrationtitle=loginPage.validateLoginPageTitle();
		System.out.println("The Registration Page title is "+Registrationtitle);
		registrationPage.setContactInformation(FirstNameinfo,LastNameinfo,Phoneinfo,Emailinfo);
		softassert.assertEquals(Registrationtitle, "Register: Mercury Tours");
		softassert.assertAll();
	}
	
	 
	 @Test(priority=5,enabled=true,dataProvider="JsonE2E",dataProviderClass= JSON_data_provider.class)
		public void setRegistrationE2EJson(String FirstNameinfo,String LastNameinfo,String Phoneinfo,String Emailinfo)
		{
			softassert = new SoftAssert();
			loginPage.clkRegister();
			String Registrationtitle=loginPage.validateLoginPageTitle();
			System.out.println("The Registration Page title is "+Registrationtitle);
			registrationPage.setContactInformation(FirstNameinfo,LastNameinfo,Phoneinfo,Emailinfo);
			softassert.assertEquals(Registrationtitle, "Register: Mercury Tours");
			softassert.assertAll();
		}
	 
	 @Test(priority=6,enabled=true,dataProvider="JsonSingleUser",dataProviderClass= JSON_data_provider.class)
		public void setRegistrationSingleUser(String FirstNameinfo,String LastNameinfo,String Phoneinfo,String Emailinfo)
		{
			softassert = new SoftAssert();
			loginPage.clkRegister();
			String Registrationtitle=loginPage.validateLoginPageTitle();
			System.out.println("The Registration Page title is "+Registrationtitle);
			registrationPage.setContactInformation(FirstNameinfo,LastNameinfo,Phoneinfo,Emailinfo);
			softassert.assertEquals(Registrationtitle, "Register: Mercury Tours");
			softassert.assertAll();
		}
	 
	 
	 
	 
	 
	 
	/*@Test(priority=2,enabled=true)
	public RegistrationPage navigateRegistrationPage(){
		loginPage.clkRegister();
		return new RegistrationPage();
		
	}*/
	
	@Test(priority=5,enabled=false)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
