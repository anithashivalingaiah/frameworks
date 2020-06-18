package com.frameworks.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.frameworks.utils.TestBase;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends TestBase {
 
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
    	String uniqueDate = new SimpleDateFormat("'secondDate_'yyyyMMDDHHmm''").format(new Date());

    	//String path = prop.getProperty("pathExtReport") + "//FirstSFReport_" + uniqueDate + ".html";
    	String path = prop.getProperty("pathExtReport") + "\\testreport.html" ;
    	String pathForScreenshot = prop.getProperty("pathForScreenshot") + "//ImageOne.png";

    	if (extent == null) {
        	
        	extent = new ExtentReports(path, true) ;
        	
			/*
			 * //Set HTML reporting file location String workingDir =
			 * System.getProperty("user.dir"); if
			 * (System.getProperty("os.name").toLowerCase().contains("win")) { //extent =
			 * new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html",
			 * true); extent = new ExtentReports(path, true); } else if
			 * (System.getProperty("os.name").toLowerCase().contains("mac")) { extent = new
			 * ExtentReports(workingDir + "/ExtentReports/ExtentReportResults.html", true);
			 * }
			 */
        }
        return extent;
    }
}