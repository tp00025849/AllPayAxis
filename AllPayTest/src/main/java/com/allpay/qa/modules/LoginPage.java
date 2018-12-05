package com.allpay.qa.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.allpay.qa.launch.TestBase;

public class LoginPage extends TestBase {

//page factory--OR
	
	@FindBy(xpath=".//*[@id='nav-logo']")
	WebElement logo;
	
	@FindBy(xpath=".//*[@id='nav-link-yourAccount']")
	WebElement accountList;
	
	@FindBy(xpath=".//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath=".//input[@type='submit']")
	WebElement Continue;
	
	@FindBy(xpath=".//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='signInSubmit']")
	WebElement signbtn;
	
	//Initializing page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateAppTitle(){
		
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	
	public HomePage login (String usr, String pswd){
		accountList.click();
		email.sendKeys(usr);
		Continue.click();
		password.sendKeys(pswd);
		signbtn.click();
		return new HomePage();
	}
}
