package com.frameworks.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;

public class CommonUtils {
	//static WebDriver driver;
	
	public static int implicit_wait = 10;
	public static int pageload_timeout = 20;
	public static Timeouts implicitWait = TestBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	
	/*
	 * public void timeoutsImplicit(long implicit, TimeUnit seconds ) {
	 * driver.manage().timeouts().implicitlyWait(implicit, seconds); }
	 * 
	 * public void timeoutsPageload(long pageload, TimeUnit sec) {
	 * 
	 * driver.manage().timeouts().pageLoadTimeout(pageload, sec);
	 * 
	 * }
	 */

}
