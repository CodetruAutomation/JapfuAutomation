package com.codetru.project.Japfu.pages;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import com.codetru.project.Japfu.CommonPageCICA;

public class Approve_Employee_Edits_Page extends CommonPageCICA{

	private By Requested = By.xpath("//div[.='Requested']");

	private By Pending = By.id("//div[.='Pending']"); 

	private By Employee = By.xpath("//div[.='Employee']");

	private By Approve_Button = By.xpath("//button[.='Approve']");

	private By Okay_Button = By.xpath("//button[.='Okay']");

	public void Approve_Employee_Personal_Details(){

		sleep(2);
		if(verifyElementVisible(Requested)) {

			clickElement(Requested);
			sleep(1);
			scrollToElementAtBottom(Approve_Button);
			sleep(1);
			clickElement(Approve_Button);
			sleep(1);
			clickElement(Okay_Button);
			sleep(2);

		}else if(verifyElementVisible(Pending)) {

			clickElement(Pending);
			sleep(1);
			clickElement(Employee);
			sleep(1);
			clickElement(Requested);
			scrollToElementAtBottom(Approve_Button);
			sleep(1);
			clickElement(Approve_Button);
			sleep(1);
			clickElement(Okay_Button);
			sleep(2);

		}else {
			System.err.println("No Pending Actions");
		}


	}



}



