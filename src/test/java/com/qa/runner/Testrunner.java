package com.qa.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\Admin\\eclipse-workspace\\cucumber_selenium\\src\\test\\java\\com\\qa\\features\\Test.Feature",glue= "com.qa.seleniumgluecode",
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true, tags = { "@testing" }
)
public class Testrunner {

	   @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
	    
	    }
	}
