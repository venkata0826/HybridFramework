package com.crm.qa.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class RegistrationPage extends TestBase {
	
	
	@FindBy(xpath="//input[@name='firstName']")
	@CacheLookup
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='phone']")
	@CacheLookup
	WebElement Phone;
	
	@FindBy(xpath="//input[@name='userName']")
	@CacheLookup
	WebElement Email;
	
	
	//Initializing the Page Objects:
		public RegistrationPage(){
			PageFactory.initElements(driver, this);
		}
	
	public void setContactInformation(String FirstNameinfo,String LastNameinfo,String Phoneinfo,String Emailinfo){
		
		if(FirstName.isDisplayed() && LastName.isDisplayed() && Phone.isDisplayed() && Email.isDisplayed()){
			FirstName.clear();
			FirstName.sendKeys(FirstNameinfo);
			LastName.clear();
			LastName.sendKeys(LastNameinfo);
			Phone.clear();
			Phone.sendKeys(Phoneinfo);
			Email.clear();
			Email.sendKeys(Emailinfo);System.out.println("First Name, Last Name, Phone, Email Fields are not displaying and failed to enter");}
			else{
				System.out.println("First Name, Last Name, Phone, Email Fields are not displaying and failed to enter");
			}
		}
		
	}
