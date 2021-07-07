package com.qa.seleniumgluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class Test {
	
	public static WebDriver driver;
@Given("^user is  on homepage$")
public void user_is_on_homepage() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://www.koovs.com/");
    driver.findElement(By.xpath("//div[text()='Accept']")).click();
    
	
   
}

@When("^user navigates to Login Page$")
public void user_navigates_to_Login_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	 	driver.findElement(By.xpath ("//a[text()='Login']")).click();
	 	
}

@When("^user enters username and Password$")
public void user_enters_username_and_Password() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--disable-notifications");
	driver.findElement(By.id("login-email")).sendKeys("raghavendran_tu@yahoo.co.in");
    driver.findElement(By.id("login-pswd")).sendKeys("MultiUse@89");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    
}

@Then("^success message is displayed$")
public void success_message_is_displayed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	String exp_message = "YOU'VE SUCCESSFULLY LOGGED IN.";
	String actual = driver.findElement(By.xpath("//div[@id='notification-wrapper']/div/span")).getText();
	Assert.assertEquals(exp_message, actual);
    driver.quit();
}



}
