package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.JiraCreateIssue;
import com.codetru.common.BaseTest;

public class F_Timesheet_Approval_Codetru_Test extends BaseTest {
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 1)
	public void TC_TimeSheet_Approval() throws Exception {


		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_ENCRIPTED_CREDENTIALS, "NormalText");

		getLoginPage().Launch_Url();
		getLoginPage().Encripted_Credentials(10);

		getStep_4Page().TimeSheet();

		for(int i=1; i<=3; i++) {
			if( i==1) {
				getStep_4Page().Pending_Approvals1();
				getStep_4Page().Timesheet_Approve();

			} else if(i==2){
				getStep_4Page().Pending_Approvals2();
				getStep_4Page().Timesheet_Approve();

			}else if(i==3){
				getStep_4Page().Pending_Approvals3();
				getStep_4Page().Timesheet_Rejection();
				getStep_3Page().Logout();
			}
		}

	}
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 2)
	public void TC_TimeSheet_Resubmit() throws Exception {


		//	getLoginPage().Launch_Url();
		getLoginPage().Encripted_Credentials(4);
		getStep_3Page().ReSubmission_of_TimeSheet();
		getStep_3Page().Logout();
		
	}
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 3)
	public void TC_FinalValidations() throws Exception {

		getLoginPage().FailedCase();
	}
}
