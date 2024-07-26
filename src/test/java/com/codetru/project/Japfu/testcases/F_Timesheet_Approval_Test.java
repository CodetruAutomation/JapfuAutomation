package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.JiraCreateIssue;
import com.codetru.common.BaseTest;

public class F_Timesheet_Approval_Test extends BaseTest {
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void TC_Timesheet_Approval_of_Doid_ai() throws Exception {


		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_ENCRIPTED_CREDENTIALS, "NormalText");

		getLoginPage().Launch_Url();
		getLoginPage().Encripted_Credentials(1);

		getStep_4Page().TimeSheet();

		for(int i=1; i<=5; i++) {
			
			if(i==1) {
				getStep_8Page().Pending_Approvals1();
				getStep_8Page().Timesheet_Approve();

			}else if(i==2) {
				getStep_8Page().Pending_Approvals2();
				getStep_8Page().Timesheet_Approve();

			}else if(i==3) {
				getStep_8Page().Pending_Approvals3();
				getStep_8Page().Timesheet_Approve();

			}else if(i==4) {
				getStep_8Page().Pending_Approvals4();
				getStep_8Page().Timesheet_Approve();

			}else if(i==5) {
				getStep_8Page().Pending_Approvals5();
				getStep_8Page().Timesheet_Approve();

			}
		}
		
		getStep_6Page().Approve_Timesheet_And_Validate_Data();
		
	}
}