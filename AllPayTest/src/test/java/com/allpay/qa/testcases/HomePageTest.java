package com.allpay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.allpay.qa.launch.TestBase;
import com.allpay.qa.modules.HomePage;
import com.allpay.qa.modules.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage logingPage;
	HomePage homePage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		logingPage=new LoginPage();
		homePage = logingPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void ValidateUserAccount(){
		String title=homePage.validateAppTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test(priority=2)
	public void verifyUserName(){
		Assert.assertTrue(homePage.verifyUsrName());
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
