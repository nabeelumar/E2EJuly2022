package resources;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReport {

	static ExtentReports extent;
	public static ExtentReports getReportObjecgt() {
		String path =System.getProperty("user.dir")+"/reports/index.html";
 
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
 
		reporter.config().setReportName("Web Automation Results");
 
		reporter.config().setDocumentTitle("Test Results");
 
		extent =new ExtentReports();
 
		extent.attachReporter(reporter);
 
		extent.setSystemInfo("Tester", "Nabeel");
		return extent;
	}
 


}



