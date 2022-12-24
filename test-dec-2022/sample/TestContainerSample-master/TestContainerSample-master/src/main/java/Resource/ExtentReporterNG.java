package Resource;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	 static ExtentReports extent;

     

     public static ExtentReports getReportObject() {

                    

                     String path = System.getProperty("user.dir")+"//reports//output.html";

                     System.out.println(path);

                     ExtentSparkReporter reporter = new ExtentSparkReporter(path);

                     reporter.config().setReportName("CucumberFramework");

                     reporter.config().setDocumentTitle("GoibiboReport");

                     reporter.config().setTimeStampFormat("HH:mm:ss:SSS");

                    

                     extent = new ExtentReports();

                     extent.attachReporter(reporter);

                     extent.setSystemInfo("Manjusree", "Mohanasundaram");

                     return extent;

                    

     }



}


