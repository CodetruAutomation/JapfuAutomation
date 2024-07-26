package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;
import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.JiraCreateIssue;
import com.codetru.common.BaseTest;

public class Approve_Employee_Edits_Test extends BaseTest {
	
	  
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 1)
	public void Approve_Employee_Edits() {
		
		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	
		getLoginPage().Valid_Username_Password("emma@doid.ai", "Codetru@004");
		getStep_10Page().Approve_Employee_Personal_Details();
		getStep_10Page().Approve_Employee_Personal_Details();
		getStep_3Page().Logout();
	}
}


