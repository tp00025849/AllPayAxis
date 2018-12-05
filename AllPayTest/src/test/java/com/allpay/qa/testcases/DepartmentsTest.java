package com.allpay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.allpay.qa.launch.TestBase;
import com.allpay.qa.modules.Departments;
import com.allpay.qa.modules.HomePage;
import com.allpay.qa.modules.LoginPage;

public class DepartmentsTest extends TestBase {

	HomePage homePage;
	Departments departments;
	LoginPage logingPage;
	
	public DepartmentsTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		logingPage=new LoginPage();
		homePage=logingPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 departments=homePage.clickOnCategory();
	}
	@Test
	public void validateTitle(){
		String title=departments.validateTitle();
		Assert.assertEquals(title,"Amazon Prime Video: Access Hundreds of New releases, Popular Bollywood Blockbusters, Hollywood movies, TV Shows- Amazon.in");
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
