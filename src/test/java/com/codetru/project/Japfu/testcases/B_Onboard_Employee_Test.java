package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.JiraCreateIssue;
import com.codetru.common.BaseTest;

public class B_Onboard_Employee_Test extends BaseTest {

	 @JiraCreateIssue(isCreateIssue = true)
	 @Test
	 public void TC_Onboarding_an_Employee() throws Exception {
		 
		 ExcelHelpers excel = new ExcelHelpers();
		 excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
		 getHomePage().verify_Navigating_to_Homepage_Once_click_on_Login();;
		 getHomePage().Employee_Information();
		 
	 }
	 
}
