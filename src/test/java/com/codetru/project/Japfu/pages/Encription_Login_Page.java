package com.codetru.project.Japfu.pages;

import org.testng.annotations.Test;

import com.Japfu.constants.FrameworkConstants;
import com.Japfu.helpers.ExcelHelpers;
import com.Japfu.utils.DecodeUtils;
import com.codetru.project.Japfu.CommonPageCICA;

public class Encription_Login_Page extends CommonPageCICA {

//EXCEL_ENCRIPTED_CREDENTIALS
	
	public static String De_email ;
	public static String De_password;
	
	public static String En_email ;
	public static String En_password;
	

	public static void TC_Valid_Username_Password(int e) {
		
		ExcelHelpers excelNor = new ExcelHelpers();
		ExcelHelpers excelEnc = new ExcelHelpers();

		excelNor.setExcelFile(FrameworkConstants.EXCEL_ENCRIPTED_CREDENTIALS, "NormalText");
		excelEnc.setExcelFile(FrameworkConstants.EXCEL_ENCRIPTED_CREDENTIALS, "EncodedText");

		excelEnc.setCellData(DecodeUtils.encrypt(excelNor.getCellData(e, "EMAIL_ID")), e,"EMAIL_ID");
		excelEnc.setCellData(DecodeUtils.encrypt(excelNor.getCellData(e, "PASSWORD")), e, "PASSWORD");


		System.out.println("Encripted Email		= "+excelEnc.getCellData(e, "EMAIL_ID"));
		System.out.println("Encripted Password	= "+excelEnc.getCellData(e, "PASSWORD"));
		
		En_email = excelEnc.getCellData(e, "EMAIL_ID");
		En_password = excelEnc.getCellData(e, "PASSWORD");
		
		De_email = DecodeUtils.decrypt(En_email);
		De_password = DecodeUtils.decrypt(En_password);
		
		System.out.println("Decripted Email		= "+De_email);
		System.out.println("Decripted Password	= "+De_password);
		
//		getLoginPage().Valid_Username_Password(DecodeUtils.decrypt(excelDec.getCellData(1, "EMAIL_ID")),
//				DecodeUtils.decrypt(excelDec.getCellData(1, "PASSWORD")));
	}

	
	@Test
	public void runn() {
		Encription_Login_Page.TC_Valid_Username_Password(2);
	}

}
