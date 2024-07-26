package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.keywords.WebUI;
import com.Japfu.utils.JiraCreateIssue;
import com.codetru.common.BaseTest;
import com.codetru.project.Japfu.pages.Encription_Login_Page;

public class E_Timesheet_Submission_Test extends BaseTest {
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void TC_TimeSheet_Submission() throws Exception {

		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_ENCRIPTED_CREDENTIALS, "NormalText");

		// getStep_3Page().Logout();

		for(int i=5; i<=9; i++) {

			if( i==5 || i==6 ) {
				//getLoginPage().Launch_Url();
				//getLoginPage().Valid_Username_Password(excel.getCellData(i, 1),"Codetru@007");
				
				getLoginPage().Encripted_Credentials(i);
				
				getStep_3Page().TimeSheet_Submission_by_Consultant();
				getStep_3Page().OT_Hours();
				getStep_3Page().TimeSheet_Submission();
				getStep_3Page().Logout();

			} else {
			//	getLoginPage().Launch_Url();
			//	getLoginPage().Valid_Username_Password(excel.getCellData(i, 1),"Codetru@007");
				
				getLoginPage().Encripted_Credentials(i);
				getStep_3Page().TimeSheet_Submission_by_Consultant();
				getStep_3Page().TimeSheet_Submission();
				getStep_3Page().Logout();



			}

		}
	}
}