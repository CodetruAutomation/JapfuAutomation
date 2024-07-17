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
public class A_LoginTest extends BaseTest {

	@Test(priority = 1)
	public void TC_Launching_URL() {
		getLoginPage().Launch_Url();
		
	}

	//    @Test(priority = 2)
	//    public void TC_LoginWith_Null_values() {
	////        ExcelHelpers excel = new ExcelHelpers();
	////        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	//        getLoginPage().WithoutUsername_Password();
	//    }
	//
	//    //excel.getCellData(1, "email"), excel.getCellData(1, "password")
	//    
	//    @Test(priority = 3)
	//    public void TC_LoginFailWithOnly_Digits() {
	//        ExcelHelpers excel = new ExcelHelpers();
	//        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	//        getLoginPage().Login_With_Only_Digits(excel.getCellData(2, "email"), excel.getCellData(3, "password"));
	//    }
	//
	//    @Test(priority = 4)
	//    public void TC_LoginFailWithOnly_SpecialCharacters() {
	//        ExcelHelpers excel = new ExcelHelpers();
	//        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	//        getLoginPage().Login_With_Only_SpecialCharacters(excel.getCellData(3, "email"), excel.getCellData(3, "password"));
	//    }
	//
	//    @Test(priority = 5)
	//    public void TC_LoginWith_V_Username_IN_Password() {
	//        ExcelHelpers excel = new ExcelHelpers();
	//        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	//        getLoginPage().ValidUsername_InvalidPassword(excel.getCellData(4, "email"), excel.getCellData(4, "password"));
	//    }
	//
	//    @Test(priority = 6)
	//    public void TC_LoginWith_IV_Username_V_Password() {
	//    	ExcelHelpers excel = new ExcelHelpers();
	//        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	//        getLoginPage().InvalidUsername_validPassword(excel.getCellData(5, "email"), excel.getCellData(5, "password"));
	//    }
	//    
	//    @Test(priority = 7)
	//    public void TC_LoginWith_V_Username_Null_Password() {
	//        ExcelHelpers excel = new ExcelHelpers();
	//        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	//        getLoginPage().ValidUsername_WithoutPassword(excel.getCellData(6, "email"), excel.getCellData(6, "password"));
	//    }
	//
	//    @Test(priority = 8)
	//    public void TC_LoginWith_Null_Username_V_Password() {
	//        ExcelHelpers excel = new ExcelHelpers();
	//        excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
	//        getLoginPage().WithoutUsername_ValidPassword(excel.getCellData(7, "email"), excel.getCellData(7, "password"));
	//    }

	@Parameters
	({"USERID", "PASSWORD"})
	@Test(priority = 2)
	public void TC_LoginSuccess_With_Valid_Credentials(String username,String password) {
		ExcelHelpers excel = new ExcelHelpers();
		excel.setExcelFile(FrameworkConstants.EXCEL_CMS_LOGIN, "Login");
		getLoginPage().Valid_Username_Password(username,password);
		
	}
}
