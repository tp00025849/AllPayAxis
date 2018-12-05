package com.allpay.qa.modules;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.allpay.qa.launch.TestBase;

public class NewUser extends TestBase {

	@FindBy(xpath = ".//*[@id='nav-link-yourAccount']")
	WebElement linkUrAccnt;

	@FindBy(xpath = ".//*[contains(text(),'Start here')]")
	WebElement starthere;

	@FindBy(xpath = ".//*[@id='ap_customer_name']")
	WebElement urname;

	@FindBy(xpath = ".//*[@id='ap_phone_number']")
	WebElement cellno;

	@FindBy(xpath = ".//*[@id='ap_email']")
	WebElement emaill;

	@FindBy(xpath = ".//*[@id='ap_password']")
	WebElement passwrd;

	@FindBy(xpath = ".//*[@id='continue']")
	WebElement contnue;

	public NewUser() {
		PageFactory.initElements(driver, this);
	}

	public String validateAppTitle() {

		Actions action = new Actions(driver);
		action.moveToElement(linkUrAccnt).build().perform();
		starthere.click();
		return driver.getTitle();
	}

	public HomePage register(String name, String celno, String email, String pasw) {
		Actions action = new Actions(driver);
		action.moveToElement(linkUrAccnt).build().perform();
		starthere.click();
		urname.sendKeys(name);
		cellno.sendKeys(celno);
		emaill.sendKeys(email);
		passwrd.sendKeys(pasw);
		contnue.click();
		return new HomePage();
	}

}
