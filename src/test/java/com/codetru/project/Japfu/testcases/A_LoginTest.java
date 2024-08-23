package com.codetru.project.Japfu.testcases;

import com.codetru.common.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Regression Test POC")
@Feature("Login Test")
public class A_LoginTest extends BaseTest {

	@Test(priority = 1)
	public void TC_Launching_URL() {
		getLoginPage().Launch_Url();
		
	}


	@Test(priority = 2)
	public void TC_LoginSuccess_With_Valid_Credentials() {
//		ExcelHelpers excel = new ExcelHelpers();
//		excel.setExcelFile(FrameworkConstants.EXCEL_ENCRIPTED_CREDENTIALS, "NormalText");
//		Encription_Login_Page.TC_Valid_Username_Password(1);
//		WebUI.logInfoMessage("Before Encription Email ID: "+Encription_Login_Page.De_email);
//		WebUI.logInfoMessage("Before Encription Password: "+Encription_Login_Page.De_password);
//		WebUI.logInfoMessage("After Encription Email ID: "+Encription_Login_Page.En_email);
//		WebUI.logInfoMessage("After Encription Password: "+Encription_Login_Page.En_password);
//		getLoginPage().Valid_Username_Password(Encription_Login_Page.De_email,Encription_Login_Page.De_password);
		
		getLoginPage().Encripted_Credentials(1);
		
	}
}
