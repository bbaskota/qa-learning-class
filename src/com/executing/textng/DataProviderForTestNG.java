package com.executing.textng;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProviderForTestNG extends AllMyMethod {
	

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
			// take screen shots
			// SQL - go to W3schools.com
			// Register MySql https://www.mysql.com/
			
			
		}
		
		
		@Test( description = "This test case will check the submit button after the Register link is clicked")
		public void testSubmitButtonWithHarDAssertion() {
			clickRegister(); 
			// hard assertion
			// Next assert will not continue once the test case is fail
			
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
		public void testSubmitButtonWithSoftAssertion() throws InterruptedException {
			
			// instansiate the soft assert 
			
			SoftAssert asser = new SoftAssert();
			clickRegister(); 
			// Soft assertion
			// Next assert will continue even the test case is failed
			System.out.println(" Soft assertion starts from here");
			asser.assertEquals(verifySubmitButton(), true);
			asser.assertTrue(verifyClickSubmit());
			System.out.println(" Soft assertion continues  here");
			asser.assertTrue(false);
			asser.assertTrue(false);
			System.out.println(" Soft assertion ends here : *****Hurry Everything executed successfully***");
			
		}
		
		
		// soft assert vs hard assert 
		
		
		@Test
		public void addingNewTestCase(){
			System.out.println("");
		}
		
		
		@AfterMethod
		public void closeTheBrowser() {
			driver.close();
		}
		
		
}
