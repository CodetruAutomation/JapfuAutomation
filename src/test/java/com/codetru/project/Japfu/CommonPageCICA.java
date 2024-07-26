package com.codetru.project.Japfu;

import static com.Japfu.keywords.WebUI.clickElement;
import static com.Japfu.keywords.WebUI.getTextElement;
import static com.Japfu.keywords.WebUI.setText;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codetru.project.Japfu.pages.*;


public class CommonPageCICA {

	private A_LoginPage loginCICA;
	private B_Onboard_Employee_Page homePage;
	private C_Client_Onboard_Page step_1Page;
	private D_Placement_Page step_2Page;
	private E_Timesheet_Submission_Page step_3Page;
	private F_Timesheet_Approval_Page step_4Page;
	private DashboardValidationsPage step_6Page;
	private F_Timesheet_Approval_Page2 step_8Page;
	private	Employee_Edit_and_Submit_Page step_9Page;
	private	Approve_Employee_Edits_Page step_10Page;
	
	
	
	
	public A_LoginPage getLoginPage() {
		if (loginCICA == null) {
			loginCICA = new A_LoginPage();
		}
		return loginCICA;
	}

	public B_Onboard_Employee_Page getHomePage() {
		if (homePage == null) {
			homePage = new B_Onboard_Employee_Page();
		}
		return homePage;
	}

	public C_Client_Onboard_Page getStep_1Page() {
		if (step_1Page == null) {
			step_1Page = new C_Client_Onboard_Page();
		}
		return step_1Page;
	}

	public D_Placement_Page getStep_2Page() {
		if (step_2Page == null) {
			step_2Page = new D_Placement_Page();
		}
		return step_2Page;
	}

	public E_Timesheet_Submission_Page getStep_3Page() {
		if (step_3Page == null) {
			step_3Page = new E_Timesheet_Submission_Page();
		}
		return step_3Page;
	}

	public F_Timesheet_Approval_Page getStep_4Page() {
		if (step_4Page == null) {
			step_4Page = new F_Timesheet_Approval_Page();
		}
		return step_4Page;
	}

	public DashboardValidationsPage getStep_6Page() {
		if (step_6Page == null) {
			step_6Page = new DashboardValidationsPage();
		}
		return step_6Page;
	}

	public F_Timesheet_Approval_Page2 getStep_8Page() {
		if (step_8Page == null) {
			step_8Page = new F_Timesheet_Approval_Page2();
		}
		return step_8Page;
	}
	
	public Employee_Edit_and_Submit_Page getStep_9Page() {
		if (step_9Page == null) {
			step_9Page = new Employee_Edit_and_Submit_Page();
		}
		return step_9Page;
	}
	
	public Approve_Employee_Edits_Page getStep_10Page() {
		if (step_10Page == null) {
			step_10Page = new Approve_Employee_Edits_Page();
		}
		return step_10Page;
	}

	//  ------------------------------------------------------------------------------------------------------------------

	private By menuProducts = By.xpath("//span[normalize-space()='Products']");
	private By messageNotify = By.xpath("//span[@data-notify='message']");
	private By buttonEdit = By.xpath("(//a[@title='Edit'])[1]");
	private By buttonSave = By.xpath("//button[normalize-space()='Save']");
	private By inputSearch = By.xpath("//input[@id='search']");
	public By avatarProfile = By.xpath("//span[contains(@class,'avatar avatar-sm')]");
	public By buttonCookies = By.xpath("//button[normalize-space()='Ok. I Understood']");

	public void enterDataOnSearchDataTable(String value) {
		setText(inputSearch, value, Keys.ENTER);
	}

	public void clickEditButton() {
		clickElement(buttonEdit);
	}

	public void clickSaveButton() {
		clickElement(buttonSave);
	}

	public String getMessageNotify() {
		return getTextElement(messageNotify);
	}

	public CommonPageCICA clickMenuProducts() {
		clickElement(menuProducts);
		return this;
	}


}
