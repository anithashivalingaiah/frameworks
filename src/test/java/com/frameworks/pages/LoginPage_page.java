package com.frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.frameworks.utils.TestBase;

public class LoginPage_page extends TestBase{
	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	@FindBy(xpath = "//input[@id='Login']")
	public WebElement loginBtn;
	@FindBy(xpath = "//img[@id='logo']")
	public WebElement imgLogo;
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement homeTab;
	
	public LoginPage_page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean vefifyLoginPageTitlePO() {
		return imgLogo.isDisplayed();
		  
		
	}
	
	public void loginToSalesforcePO(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginBtn.click();
		
	}
	
	public String verifyHomePageIsLanding() {
		return homeTab.getText();
		//return actual;
		//String expected = "home";
		//Assert.assertEquals(actual, expected);
	}
	
	public void forgotPasswordPO() {
		loginToSalesforcePO(prop.getProperty("userId"), prop.getProperty("passwordValue"));
		
	}
}
