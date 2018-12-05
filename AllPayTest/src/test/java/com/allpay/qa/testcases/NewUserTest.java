package com.allpay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allpay.qa.launch.TestBase;
import com.allpay.qa.modules.NewUser;
import com.allpay.qa.util.TestUtil;

public class NewUserTest extends TestBase {

	NewUser newUser;
	String sheetName="Register";
	
	public NewUserTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		newUser=new NewUser();
	}
	
	@DataProvider
	public Object[][] getRegData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getRegData")
	public void regPage(String name,String mobile,String email,String password){
		//newUser.register("Amol", "8765745364", "hjgfgb@jjgh", "6587643");
		newUser.register(name,mobile,email,password);
	}
	
	@Test(priority=2)
	public void regPageTitle(){
		String title=newUser.validateAppTitle();
		Assert.assertEquals(title, "Amazon Registration");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
