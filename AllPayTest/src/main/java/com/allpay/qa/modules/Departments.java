package com.allpay.qa.modules;

import org.openqa.selenium.support.PageFactory;

import com.allpay.qa.launch.TestBase;

public class Departments extends TestBase {
	
	
	
	
	public Departments(){
		PageFactory.initElements(driver, this);
	}
	
public String validateTitle(){
		
		return driver.getTitle();
	}
}
