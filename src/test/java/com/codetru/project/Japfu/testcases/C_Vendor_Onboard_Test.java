package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.codetru.common.BaseTest;

public class C_Vendor_Onboard_Test extends BaseTest {
	
	 @Test
    public void TC_Onboard_New_Client() throws Exception {
		 
        ExcelHelpers excel = new ExcelHelpers();
        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
       
        getvendorPage().UserDetails_Confirmation();
        getvendorPage().Visit_StartAndStop();
        getvendorPage().VendorContactDetails();
        getvendorPage().GoHome();
 
	 }
}
