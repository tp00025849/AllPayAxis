package com.allpay.qa.launch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.allpay.qa.util.TestUtil;
import com.allpay.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:/Bitnami/jenkins-1.612-0/apps/jenkins/jenkins_home/workspace"
				+ "/Facebook/AllPayTest/src/main/java/com/allpay/config/config.properties");
		
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
	    }	
    }
	
	public static void initialization(){
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("gc"))
		{
			System.setProperty("webdriver.chrome.driver","D:/workspace_finsy/finsys/AllDrivers/chromedriver.exe.");
			//System.out.println(System.getProperty("user.dir")+"/AllDrivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
