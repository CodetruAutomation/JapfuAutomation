package com.codetru.project.Japfu.pages;

import static com.Japfu.keywords.WebUI.clearAndFillText;
import static com.Japfu.keywords.WebUI.clickElement;
import static com.Japfu.keywords.WebUI.moveToElement;
import static com.Japfu.keywords.WebUI.sleep;

import org.openqa.selenium.By;

import com.codetru.project.Japfu.CommonPageCICA;

public class E_Timesheet_Submission_Page extends CommonPageCICA {


	private By Timesheet = By.xpath("//span[.='Timesheet']");

	private By View = By.xpath("//div[.='View']");

	private By Submit_Button = By.xpath("//button[.='Submit']");

	private By Done_Button = By.xpath
			("//div[contains(text(),'Successfully')]/following::div[3]/button[.='Done']");


	private By Profile_Icon = By.xpath("//img[contains(@src , 'https://japfu-documents.codetru.org/avatar')]");

	private By Logout = By.xpath("(//div[.='Log out'])[2]");

	public void Logout() throws Exception {
		sleep(2);
		clickElement(Profile_Icon);
		sleep(1);
		clickElement(Logout);
	}

	public void TimeSheet_Submission_by_Consultant() throws Exception {

		clickElement(Timesheet);
		clickElement(View);
	}

	public void OT_Hours() throws Exception {

		for(int i=1; i<=7; i++) {

			By OT_Hours = By.xpath("(//div[.='OT Hours']/parent::td/following-sibling::td/input[@type='text'])["+i+"]");
			moveToElement(OT_Hours);
			clearAndFillText(OT_Hours, "0200");
		}
	}

	public void TimeSheet_Submission() throws Exception {
		moveToElement(Submit_Button);
		sleep(2);
		clickElement(Submit_Button);
		sleep(1);

		clickElement(Done_Button);

	}

	private By Rejected = By.xpath("//button[.='Rejected']");

	private By Re_Submit_Button = By.xpath("//button[.='Resubmit']");

	public void ReSubmission_of_TimeSheet() throws Exception {
		sleep(2);
		clickElement(Timesheet);
		sleep(0.5);
		clickElement(Rejected);
		sleep(0.5);
		clickElement(View);
		sleep(0.5);
		moveToElement(Re_Submit_Button);
		sleep(0.5);
		clickElement(Re_Submit_Button);
		sleep(0.5);
		By OT_Hours = By.xpath("(//div[.='OT Hours']/parent::td/following-sibling::td/input[@type='text'])[1]");
		moveToElement(OT_Hours);
		clearAndFillText(OT_Hours, "0300");

		moveToElement(Submit_Button);
		sleep(2);
		clickElement(Submit_Button);
		sleep(1);
		clickElement(Done_Button);
	}


}
