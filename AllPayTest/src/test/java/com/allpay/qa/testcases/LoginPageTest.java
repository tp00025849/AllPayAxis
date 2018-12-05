package com.allpay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.allpay.qa.launch.TestBase;
import com.allpay.qa.modules.HomePage;
import com.allpay.qa.modules.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage logingPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		logingPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitle(){
		String title=logingPage.validateAppTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test(priority=2)
	public void logoTest(){
		boolean flag=logingPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTst(){
		homePage=logingPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
