package com.executing.textng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MySecondDataProviderClass extends AllMyMethod {

	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeBrowser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		// maximizing window size 
		driver.manage().window().maximize();
		// Implicitly wait 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
	}
		
	
	// parameterization  with data provider , it will execute all the username and password one by one
	// It help to run multiple test cases at a time.
	
	
	@DataProvider
	public Object [][] signOnData(){
		
		return new Object [] [] {
			{"bikey277", "Practice12"},
			{ "bhotebabu", "Cali123" },
			{ "kppanta" , "Hello1234$"},
			{"binda" , "Binda123"},
			{"^%&*%^&* ", "  "}
			
		};
	}
	
	@Test(enabled = false, testName = "data",  dataProvider = "signOnData")
	public void signingInWithDataProvider(String Username , String Password) {
	
		//clickRegister();
		signOnMethod (Username, Password);	
		// verify 
		Assert.assertTrue(verifySignOnmethodIsSuccessful());
		
	
		
		// Soft asserts  vs Hard Asserts 
		// try catch 
		// Exception 
		// TestNG Report 
		
		
	}
	
	@Test( description = "This test case will check the submit button after the Register link is clicked")
	public void testSubmitButtonWithHarDAssertionFromSecondClass() {
		clickRegister(); 
		// hard assertion
		System.out.println(" Hard assertion starts from here");
		Assert.assertEquals(verifySubmitButton(), true);
		Assert.assertTrue(false);
		System.out.println(" Hard assertion continues  here");
		Assert.assertTrue(false);
		Assert.assertTrue(false);
		System.out.println(" Hard assertion ends here");
		
	}
	
	// Soft assertion 
	
	
	@Test(testName = "Submit" ,  description = "This test case will check the submit button after the Register link is clicked")
	public void testSubmitButtonWithSoftAssertionFromSecondClass() throws InterruptedException {
		
		// instansiate the soft assert 
		
		SoftAssert asser = new SoftAssert();
		clickRegister(); 
		// Soft assertion
		System.out.println(" Soft assertion starts from here");
		asser.assertEquals(verifySubmitButton(), true);
		asser.assertTrue(verifyClickSubmit());
		System.out.println(" Soft assertion continues  here");
		asser.assertTrue(false);
		asser.assertTrue(false);
		System.out.println(" Soft assertion ends here : *****Hurry Everything executed successfully***");
		
	}
	
	
	// soft assert vs hard assert 
	
	
	
	
	
	@AfterMethod
	public void closeTheBrowser() {
		driver.close();
	}
	
	
}

