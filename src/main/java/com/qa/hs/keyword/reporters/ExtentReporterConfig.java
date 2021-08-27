package com.qa.hs.keyword.reporters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterConfig {
	public static ExtentReports report;


	public  static ExtentReports configureReporter() {
		String path = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Avesdo Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		report = new ExtentReports();
		report.attachReporter(reporter);
		return report;
	}
}
