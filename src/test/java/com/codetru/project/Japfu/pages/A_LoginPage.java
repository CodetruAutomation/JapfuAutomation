package com.codetru.project.Japfu.pages;

import com.Japfu.constants.FrameworkConstants;
import com.codetru.project.Japfu.CommonPageCICA;

import static com.Japfu.keywords.WebUI.*;

import org.openqa.selenium.By;

public class A_LoginPage extends CommonPageCICA {

	private By Email = By.name("email");
	private By Submit_Btn = By.xpath("//button[@type='submit']");
	private By Password_Btn = By.xpath("//button[.='Enter Password']");
	private By Password = By.name("password");
//	private By Logo = By.xpath("//img[@alt='Logo']");

	public void openLoginPage() {
		openWebsite(FrameworkConstants.URL_CMS_USER);
		waitForPageLoaded();
	}

	public void Launch_Url() {
		openWebsite(FrameworkConstants.URL_CMS_USER);
		waitForPageLoaded();
		//	verifyElementVisible(Logo);
	}

	//	public void WithoutUsername_Password() {
	//		openLoginPage();
	//		sleep(2);
	//		clickElement(InPatient); 
	//		clickElement(loginButton);
	//		waitForPageLoaded();
	//		sleep(1);
	//		verifyEquals(getTextElement(Error_message).trim(), "Invalid username/password. Please try again.", "Invalid error message");
	//	}
	//
	//	public void Login_With_Only_Digits(String email, String Password) {
	//		openLoginPage();
	//		sleep(2);
	//		setText(username, email);
	//		setText(password, Password);
	//		clickElement(InPatient); 
	//		clickElement(loginButton);
	//		waitForPageLoaded();
	//		sleep(1);
	//		verifyEquals(getTextElement(Error_message).trim(), "Invalid username/password. Please try again.", "Invalid error message");
	//	}
	//
	//	public void Login_With_Only_SpecialCharacters(String email, String Password) {
	//		openLoginPage();
	//		sleep(2);
	//		clearAndFillText(username, email);
	//		clearAndFillText(password, Password);
	//		clickElement(InPatient); 
	//		clickElement(loginButton);
	//		waitForPageLoaded();
	//		sleep(1);
	//		verifyEquals(getTextElement(Error_message).trim(), "Invalid username/password. Please try again.", "Invalid error message");
	//	}
	//
	//	public void ValidUsername_InvalidPassword(String email, String Password) {
	//		openLoginPage();
	//		sleep(2);
	//		clearAndFillText(username, email);
	//		clearAndFillText(password, Password);
	//		clickElement(InPatient); 
	//		clickElement(loginButton);
	//		waitForPageLoaded();
	//		sleep(1);
	//		verifyEquals(getTextElement(Error_message).trim(), "Invalid username/password. Please try again.", "Invalid error message");
	//	}
	//
	//	public void InvalidUsername_validPassword(String email, String Password) {
	//		openLoginPage();
	//		sleep(2);
	//		clearAndFillText(username, email);
	//		clearAndFillText(password, Password);
	//		clickElement(InPatient); 
	//		clickElement(loginButton);
	//		waitForPageLoaded();
	//		sleep(1);
	//		verifyEquals(getTextElement(Error_message).trim(), "Invalid username/password. Please try again.", "Invalid error message");
	//
	//	}
	//
	//	public void ValidUsername_WithoutPassword(String email, String Password) {
	//		openLoginPage();
	//		sleep(2);
	//		clearAndFillText(username, email);
	//		clearAndFillText(password, Password);
	//		clickElement(InPatient); 
	//		clickElement(loginButton);
	//		waitForPageLoaded();
	//		sleep(1);
	//		verifyEquals(getTextElement(Error_message).trim(), "Invalid username/password. Please try again.", "Invalid error message");
	//	}
	//
	//	public void WithoutUsername_ValidPassword(String email, String Password) {
	//		openLoginPage();
	//		sleep(2);
	//		clearAndFillText(username, email);
	//		clearAndFillText(password, Password);
	//		clickElement(InPatient); 
	//		clickElement(loginButton);
	//		waitForPageLoaded();
	//		sleep(1);
	//		verifyEquals(getTextElement(Error_message).trim(), "Invalid username/password. Please try again.", "Invalid error message");
	//	}

	public void Valid_Username_Password(String email, String password) {
	
		//openLoginPage();
		sleep(2);
		clearAndFillText(Email, email);
		clickElement(Submit_Btn);
		clickElement(Password_Btn);
		clearAndFillText(Password, password);
		clickElement(Submit_Btn);
		waitForPageLoaded();
		sleep(1);
		//verifyElementVisible(Logo, "Unable to login in to the application");

	}
	public void FailedCase() {
		
		
		clickElement(Password_Btn);
		
		//verifyElementVisible(Logo, "Unable to login in to the application");

	}

}


