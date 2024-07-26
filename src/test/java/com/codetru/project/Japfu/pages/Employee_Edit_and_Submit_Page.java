package com.codetru.project.Japfu.pages;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import com.Japfu.keywords.WebUI;
import com.Japfu.utils.DataFakerUtils;
import com.Japfu.utils.DataGenerateUtils;
import com.codetru.project.Japfu.CommonPageCICA;

public class Employee_Edit_and_Submit_Page extends CommonPageCICA{

	private By My_Profile = By.xpath("//img[@alt='employees']/following-sibling::span[.='My Profile']");

	private By Edit_Icon = By.xpath("//img[@alt='Edit']"); 

	private By Marital = By.xpath("//label[.='Marital Status']/following-sibling::div/input[@role='combobox']");
	private By Marital_status = By.xpath("//li[.='Single']");

	private By Address1 = By.name("address_line_one");

	private By Save_Button = By.xpath("//button[.='Save']");
	
	private By Changes_Request_message_Alert = By.xpath("//div[.='Do you want to make this changes?']");
	private By Yes_Button = By.xpath("(//button[.='Yes'])[4]");
	
	private By Changes_Approval_Sent_Alert = By.xpath("//div[.='Changes Sent For Approval']");

	private By Okay_Button = By.xpath("//button[.='Okay']");

	public void Update_Employee_Personal_Details() throws Exception {

		clickElement(My_Profile);
		clickElement(Edit_Icon);
		sleep(1);

		clickElement(Marital);
		clickElement(Marital_status);
		sleep(1);
		
		
		WebUI.scrollToElementAtBottom(Address1);
		
		clearTextCtrlA(Address1);
		sleep(1);
		String add = DataGenerateUtils.randomAddress();
		setText(Address1, add);
		WebUI.scrollToElementAtBottom(Save_Button);

		clickElement(Save_Button);
		sleep(1);

		verifyElementVisible(Changes_Request_message_Alert);
		clickElement(Yes_Button);
		sleep(2);
		
		verifyElementVisible(Changes_Approval_Sent_Alert);
		clickElement(Okay_Button);
		sleep(2);



	}



}



