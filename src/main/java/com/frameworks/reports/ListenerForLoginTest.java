package com.frameworks.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.frameworks.utils.TestBase;
import com.relevantcodes.extentreports.LogStatus;

//public class ListenerForLoginTest extends Salesforce_extentReport implements ITestListener {
public class ListenerForLoginTest extends TestBase implements ITestListener {

	// ExtentReports extReport;
	// ExtentTest extTest;
	// TakesScreenshot screenshot;
	//Salesforce_extentReport sfReportObj = new Salesforce_extentReport();

	public void onTestStart(ITestResult result) {
		//sfReportObj.extTest.log(LogStatus.INFO, result.getName() + "started");
		System.out.println("the testcase" + result.getName() + "started.");
		ExtentTestManager.startTest(result.getName(), result.getName()) ;
	}

	public void onTestSuccess(ITestResult result) {
//		sfReportObj.extTest.log(LogStatus.PASS, result.getName());

		System.out.println("I am in onTestSuccess method :" + result.getName());
		// ExtentReports log operation for passed tests.
		ExtentTestManager.getTest().log(LogStatus.PASS, result.getName() + ": Test passed");
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	public void onTestFailure(ITestResult result) {
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	public void onTestSkipped(ITestResult result) {

	}
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Tests finished");


	}

}
