package com.codetru.project.Japfu.testcases;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.codetru.common.BaseTest;
import org.testng.annotations.Parameters;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Regression Test CMS")
@Feature("Login Test")
public class DashboardValidationTest extends BaseTest {



	@Parameters

	@Test(priority = 1)
	public void TC_DashboardValidationAfterTimeSheetSUbmission() {
		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
		getStep_6Page().Get_Value_From_DB_AP();
		getStep_6Page().Get_Data_From_Clients_And_Validate();
		
	}
}
