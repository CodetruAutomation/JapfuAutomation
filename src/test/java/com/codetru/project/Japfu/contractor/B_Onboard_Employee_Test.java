package com.codetru.project.Japfu.contractor;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.codetru.common.BaseTest;

public class B_Onboard_Employee_Test extends BaseTest {

	
	 @Test
	 public void TC_Onboarding_an_Employee() throws Exception {
		 
		 ExcelHelpers excel = new ExcelHelpers();
		 excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
		 getcontractor().verify_Navigating_to_Homepage_Once_click_on_Login();;
		 getcontractor().Employee_Information();
		 
	 }
	 
}
