package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.JiraCreateIssue;
import com.codetru.common.BaseTest;

public class C_Client_Onboard_Test extends BaseTest {
	
	 @JiraCreateIssue(isCreateIssue = true)
	 @Test
    public void TC_Onboard_New_Client() throws Exception {
		 
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
       
        getStep_1Page().UserDetails_Confirmation();
        getStep_1Page().Visit_StartAndStop();
        getStep_1Page().Patient_ID();
        getStep_1Page().Diagnosis_Throat();
 
	 }
}
