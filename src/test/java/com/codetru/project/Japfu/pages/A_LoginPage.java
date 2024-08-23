package com.codetru.project.Japfu.pages;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.keywords.WebUI;
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
	
	public void Encripted_Credentials(int v) {
		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_ENCRIPTED_CREDENTIALS, "NormalText");
		
		Encription_Login_Page.TC_Valid_Username_Password(v);
		WebUI.logInfoMessage("Before Encription Email ID: "+Encription_Login_Page.De_email);
		WebUI.logInfoMessage("Before Encription Password: "+Encription_Login_Page.De_password);
		WebUI.logInfoMessage("After Encription Email ID: "+Encription_Login_Page.En_email);
		WebUI.logInfoMessage("After Encription Password: "+Encription_Login_Page.En_password);
		
		getLoginPage().Valid_Username_Password(Encription_Login_Page.De_email,Encription_Login_Page.De_password);
		
	}
	
	public void FailedCase() {
		
		
		clickElement(Password);
		
		//verifyElementVisible(Logo, "Unable to login in to the application");

	}

}


