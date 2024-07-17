package com.codetru.project.Japfu.pages;

import static com.Japfu.keywords.WebUI.clickElement;
import static com.Japfu.keywords.WebUI.moveToElement;
import static com.Japfu.keywords.WebUI.setText;
import static com.Japfu.keywords.WebUI.sleep;

import org.openqa.selenium.By;

import com.codetru.project.Japfu.CommonPageCICA;


public class F_Timesheet_Approval_Page extends CommonPageCICA {

	private By Timesheet = By.xpath("//span[.='Timesheet']");

	private By View_button = By.xpath("//div[.='View']");

	private By Pending_Approvals = By.xpath("//button[@type='button' and text()='Pending Approval']");
	
	private By SearchBar = By.xpath("//input[@placeholder='Search by Name / Timesheet ID']");

	private By Approve_Button = By.xpath("//button[.='Approve']");

	private By Go_To_Home = By.xpath("//button[.='Go To Home']");
	
	private By Reject_Button = By.xpath("//button[.='Reject']");

	private By Reject_Comment = By.xpath("//label[.='Add reason for rejection']/following-sibling::div/input[@name='rejectComment']");
	
	private By Yes_Button = By.xpath("//button[.='Yes, Reject']");
	
	
	
	public void TimeSheet() throws Exception {
		sleep(2);
		clickElement(Timesheet);
	}

	public void Pending_Approvals() throws Exception {
		sleep(1);
		clickElement(Pending_Approvals);
		sleep(1);
		clickElement(View_button);
	}

	public void Pending_Approvals1() throws Exception {
		sleep(1);
		clickElement(Pending_Approvals);
		sleep(0.5);
		setText(SearchBar, "N"); 
		sleep(0.5);
		setText(SearchBar, "a"); 
		sleep(0.5);
		setText(SearchBar, "t"); 
		sleep(0.5);
		setText(SearchBar, "h"); 		
		sleep(0.5);
		clickElement(View_button);
	}
	
	public void Pending_Approvals2() throws Exception {
		sleep(1);
		clickElement(Pending_Approvals);
		sleep(0.5);
		setText(SearchBar, "M");
		sleep(0.5);
		setText(SearchBar, "a");
		
		sleep(0.5);
		
		clickElement(View_button);
	}
	
	public void Pending_Approvals3() throws Exception {
		sleep(1);
		clickElement(Pending_Approvals);
		sleep(0.5);
		setText(SearchBar, "E"); 
		sleep(0.5);
		setText(SearchBar, "d"); 
		
		sleep(0.5);
		clickElement(View_button);
	}
	
	public void Timesheet_Approve() throws Exception {
		sleep(1);
		moveToElement(Approve_Button);
		sleep(1);
		clickElement(Approve_Button);
		sleep(1);
		clickElement(Go_To_Home);
		
	}

	public void Timesheet_Rejection() throws Exception {
		sleep(1);
		moveToElement(Reject_Button);
		clickElement(Reject_Button);
		sleep(1);
		clickElement(Yes_Button);
		sleep(0.5);
		setText(Reject_Comment, "Update the Timesheet and submit again"); 
		sleep(0.5);
		clickElement(Yes_Button);
		sleep(1);
		clickElement(Go_To_Home);
		
	}
	

}
