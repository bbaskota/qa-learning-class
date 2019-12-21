package com.executing.textng;



import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class AllMyMethod {
	
	// POM 
	
	private final static By REGISTER   = By.xpath("//*[contains(text(),'REGISTER')]");
	private final static By FIRST_NAME = By.xpath("//input[@name='firstName']");
	private final static By LAST_NAME  = By.xpath("//input[@name='lastName']");
	private final static By PHONE_NUMBER = By.xpath("//input[@name= 'phone')]");
	private final static By USERNAME = By.xpath("//input[@name='userName']");
	private final static By PASSWORD = By.xpath("//input[@name='password']");
	private final static By SUBMIT = By.xpath("//input[@value='Login']");
	private final static By EMAIL_ADDRESS = By.xpath("//*[@id='userName']");
	private final static By LOG_IN = By.xpath("//*[@name='login'] ");
	
	// mailing address 
	private final static By MAILING_ADDRESS = By.xpath("//input[@name = 'address1']");
	private final static By MAILING_ADDRESS_2 = By.xpath("//input[@name = 'address2']");
	private final static By MAILING_CITY = By.xpath("//input[@name = 'city']");
	private final static By MAILING_STATE = By.xpath("//input[@name = 'state']");
	private final static By MAILING_POSTAL_CODE = By.xpath("//input[@name = 'postalCode']");
	private final static By SELECTING_COUNTRY = By.xpath("//select[@name = 'country']");
	
	// user information 
	private final static By USER_EMAIL = By.xpath("//*[@id=\"email\"]");
	private final static By USER_PASSWORD = By.xpath("//input[@name = 'password']");
	private final static By USER_CONFORM_PASSWORD = By.xpath("//input[@name='confirmPassword']");
	
	// click Register 
	private final static By CLICK_REGISTER = By.xpath("//input[@name='register']");
	
	// check Registraterion is completed
	private final static By REGISTRATION_TEXT = By.xpath("//*[contains(text(),'Thank you for registering')]");
	


	public WebDriver driver;

	// Click Register Method
	
	public void clickRegister() {
		// Implicitly wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Refresh the page
		// page forward
		//driver.navigate().forward();
		System.out.println(" Yes the page forward happend");
		//driver.navigate().refresh();
		driver.findElement(REGISTER).click();

	}
	
	public boolean checkTheTextFiled(String texValue){
		driver.findElement(By.xpath(" ")).sendKeys(texValue);
		return true;
	}

	// creating method to verify the Submit button is there or not after
	// clicking 'REGISTER' link
	public boolean verifySubmitButton() {
		clickRegister();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// using isDisplayed method to see the button 
		driver.findElement(REGISTER).isDisplayed();
		return true;
	}
	
	

	// to check the Register link is available or Not ?	
	public boolean verifyTheRegisterLink(){
		driver.findElement(REGISTER).isDisplayed();
		return true;		
	}

	// contanct information 
	public  void contactInformation(String firstName , String lastName, String phoneNumber , String emailAddress ){
		driver.findElement(FIRST_NAME).sendKeys(firstName);
		driver.findElement(LAST_NAME).sendKeys(lastName);
		driver.findElement(PHONE_NUMBER).sendKeys(phoneNumber);	
		driver.findElement(EMAIL_ADDRESS).sendKeys(emailAddress);	
		
	}

// Log In with username and password 
	
	// this method will log on with username and password
	public void signOnMethod (String userName, String password) {
			driver.findElement(USERNAME).sendKeys(userName);
			driver.findElement(PASSWORD).sendKeys(password);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			clickSigIn();
			
			}
	
	// this method will click SignIn buttton 	
	public void clickSigIn(){
		driver.findElement(LOG_IN).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// this method will click submit
	public void clickSubmit() {
			driver.findElement(SUBMIT).click();
			}
	
	// checking the sumbit button is displayed or not ? 
	public boolean verifySignOnmethodIsSuccessful(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(text(),'Flight ')]")).isDisplayed();	
		return true;
	}


public void verifyMailingInformation(String address1, String address2, String city, String state, String postalCode, String country) {
		driver.findElement(MAILING_ADDRESS).sendKeys(address1);
		driver.findElement(MAILING_ADDRESS_2).sendKeys(address2);
		driver.findElement(MAILING_CITY).sendKeys(city);
		driver.findElement(MAILING_STATE).sendKeys(state);
		driver.findElement(MAILING_POSTAL_CODE).sendKeys(postalCode);
		Select dropCountry = new Select(driver.findElement(SELECTING_COUNTRY));
		dropCountry.selectByVisibleText(country);
}

	public void verifyUserInformation(String email, String passwordOnce, String passwordTwice) {
		driver.findElement(USER_EMAIL).sendKeys(email);
		driver.findElement(USER_PASSWORD).sendKeys(passwordOnce);
		driver.findElement(USER_CONFORM_PASSWORD).sendKeys(passwordTwice);
	}

	
	// try catch block 
	public boolean verifyClickSubmit() throws InterruptedException {
		
		try {
			takeScreenShot(driver, "C://test//selenium.png");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("*******its after thread. sleep****** ");
		driver.findElement(CLICK_REGISTER).click();
		return true;
	}

	
	public boolean verifyTheRegistrationText() {
		driver.findElement(REGISTRATION_TEXT).isDisplayed();
		return true;
		
	}

	public void verifyRegistrationIsCompleted() throws InterruptedException {
		clickRegister();
		contactInformation("TestData.FirstName", "lastName", "123456", "email@gmail.com");
		verifyMailingInformation("222 Dallas st", "apt 2 ", "Irving", "TX", "56780", "USA");
		verifyUserInformation("hello@gmail.com", "MyPassword1", "MyPassword1");
		
		verifyClickSubmit();

	}
	

	
	// Take a screen shot 
	
	
	public void takeScreenShot(WebDriver webdriver , String fileWithPath) throws IOException{
		
		// convert web driver object
		
		TakesScreenshot scrShot  = ((TakesScreenshot)webdriver);
		
		// calling screnshot
		
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		// move to the place where you want to store screen shot
		
		File DestFile = new File(fileWithPath);
		
		// copy file the location
		
		FileUtils.copyFile(SrcFile, DestFile);
		
		
		
	}
	
	
	
	
	}
	
	

		
	
		
	
	
	


