package com.frameworks.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.frameworks.reports.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.frameworks.reports.ListenerForLoginTest.class)

public class TestBase {	
	
	public static WebDriver driver;
	public static Properties prop;
	String path = ("C:\\Users\\pmuniraju\\workspaces\\frameworks\\src\\main\\java\\com\\config\\config.properties");
	public ExtentReports reports ;
	public ExtentTest logger ;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream(path);
			prop.load(inputStream);
			//System.setProperties(prop);
			
		} catch (Exception e) {
			System.out.println(e);
		}  
	}
	
	public void log4jSetUp() throws IOException {
		String pathLog4j = "C:\\Users\\pmuniraju\\workspaces\\frameworks\\src\\main\\java\\com\\config\\log4j.properties";
		FileInputStream log4jInput = new FileInputStream(pathLog4j);
		Properties prop4j = new Properties();
		prop4j.load(log4jInput);
		PropertyConfigurator.configure(prop4j);		
	}
	
	public void initialiseBrowser(String brName) {
		brName = prop.getProperty("browser");
		if (brName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (brName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(CommonUtils.pageload_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);		
		driver.get(prop.getProperty("url"));		
	}
	
	@BeforeSuite 
	public void setupSuite() {
		reports = ExtentManager.getReporter() ;
	}
	
	@BeforeSuite
	public void setUp2() throws IOException {
		log4jSetUp();
	}
	

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if  (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed test case");
		}
		ExtentManager.getReporter().flush();
	}

}

