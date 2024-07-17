package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.codetru.common.BaseTest;

public class E_Timesheet_Submission_Codetru_Test extends BaseTest {

	@Test
	public void TC_TimeSheet_Submission() throws Exception {

		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");

		// getStep_3Page().Logout();

		for(int i=1; i<=3; i++) {

			if( i==1 ) {
				getLoginPage().Launch_Url();
				getLoginPage().Valid_Username_Password("divya.s@codetru.com","Codetru@007");
				getStep_3Page().TimeSheet_Submission_by_Consultant();
				getStep_3Page().OT_Hours();
				getStep_3Page().TimeSheet_Submission();
				getStep_3Page().Logout();

			} else 	if(i==2) {
				//getLoginPage().Launch_Url();
				getLoginPage().Valid_Username_Password("sankar.s@codetru.com","Codetru@007");
				getStep_3Page().TimeSheet_Submission_by_Consultant();
				getStep_3Page().TimeSheet_Submission();
				getStep_3Page().Logout();

			}	if(i==3) {

				//getLoginPage().Launch_Url();
				getLoginPage().Valid_Username_Password("venkatesh.t@codetru.com","Codetru@007");
				getStep_3Page().TimeSheet_Submission_by_Consultant();
				getStep_3Page().TimeSheet_Submission();
				getStep_3Page().Logout();


			}

		}
	}
}