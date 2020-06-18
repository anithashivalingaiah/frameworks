package com.frameworks.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frameworks.pages.LoginPage_page;
import com.frameworks.utils.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage_testcase extends TestBase{
	
	LoginPage_page loginPageObj;
	Logger log = Logger.getLogger(getClass().getSimpleName());
	
	LoginPage_testcase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialiseBrowser("chrome");
		loginPageObj = new LoginPage_page();
		log.info("app has been launched");
	}
	
		
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		
		//logger = reports.startTest("Verify Login Page Title Test") ;
		//logger.log(LogStatus.INFO, "Starting Test");
		boolean flag = loginPageObj.vefifyLoginPageTitlePO();
		Assert.assertTrue(flag);
	}
	  //Assert.assertEquals(, true); }
	 
	
	@Test(priority=2)
	public void loginSalesForceTest() {
		loginPageObj.loginToSalesforcePO(prop.getProperty("userId"), prop.getProperty("passwordValue"));
		
		
	}
	
	@Test(priority =3)
	public void validateHomePageAfterLogin() {
		loginPageObj.loginToSalesforcePO(prop.getProperty("userId"), prop.getProperty("passwordValue"));
		String actual = loginPageObj.verifyHomePageIsLanding();
		String expected = "Home";
		Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
	

}
