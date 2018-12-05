package com.allpay.qa.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.allpay.qa.launch.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath=".//*[contains(text(),'Hello, Amol')]")
	WebElement userName;
	
	@FindBy(xpath=".//*[@id='nav-your-amazon-text']")
	WebElement users_amazon;
	
	@FindBy(xpath=".//*[@id='nav-link-shopall']")
	WebElement departments;
	
	@FindBy(xpath=".//*[@id='nav-flyout-shopAll']//*[contains(text(),'Prime Video')]")
	WebElement primeVideo;
	
	@FindBy(xpath=".//*[@id='nav-flyout-shopAll']//*[contains(text(),'All Videos')]")
	WebElement primeAllVideo;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateAppTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUsrName(){
		return userName.isDisplayed();
	}
	
	public Departments clickOnCategory(){
		Actions action = new Actions(driver);
		action.moveToElement(departments).build().perform();
		action.moveToElement(primeVideo).build().perform();
		primeAllVideo.click();
		return new Departments();
	}
}
