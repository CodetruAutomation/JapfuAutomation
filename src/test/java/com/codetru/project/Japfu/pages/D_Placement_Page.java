package com.codetru.project.Japfu.pages;

import static com.Japfu.keywords.WebUI.clickElement;
import static com.Japfu.keywords.WebUI.moveToElement;
import static com.Japfu.keywords.WebUI.setText;
import static com.Japfu.keywords.WebUI.sleep;
import static com.Japfu.keywords.WebUI.verifyElementVisible;
import org.openqa.selenium.By;
import com.Japfu.utils.DataGenerateUtils;
import com.codetru.project.Japfu.CommonPageCICA;

public class D_Placement_Page extends CommonPageCICA {


	private By Placement = By.xpath("//img[@alt='placement']");

	private By Add_Placement = By.id("add-employee");

	private By Add = By.xpath("(//button[.='Add'])[1]");

	private By Client = By.xpath("//label[.='Client Name']/following-sibling::div/input[@role='combobox']");
	private By Kotak = By.xpath("//li[.='"+C_Client_Onboard_Page.clientname+"']");

	private By Contact = By.xpath("(//label[.='Contact']/following-sibling::div/input[@role='combobox'])[1]");
	private By ContactName = By.xpath("//li[.='"+C_Client_Onboard_Page.fname+" "+C_Client_Onboard_Page.Lname+"']");

	private By Bill_rate = By.name("bill_rate");

	private By OT_Bill_rate = By.name("ot_bill_rate");

	private By StartDate = By.xpath("//button[@aria-label='Choose date']");
	private By Date_1 = By.xpath("//button[.='1']");

	private By Continue_button = By.xpath("//button[.='Continue']");

	private By JobTitle = By.xpath("//label[.='Job Title']/following-sibling::div/input[@role='combobox']");
	private By Project = By.xpath("//li[.='Project']");

	private By Address_1= By.name("address_line_one");

	private By State = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	private By Alabama = By.xpath("//li[.='Alabama']");

	private By City = By.name("city");
	private By Zipcode = By.name("zip_code");

	private By PayType = By.xpath("//label[.='Pay Type']/following-sibling::div/input[@role='combobox']");
	private By Salary = By.xpath("//li[.='Hourly']");

	private By Value_Button = By.xpath("//button[.='Value']");
	private By Payrate= By.name("value");

//	private By SameASPayrate = By.xpath("//div[.='Same as Payrate']");

	private By Timesheet_Cycle = By.xpath("//label[.='Timesheet Cycle']/following-sibling::div/input[@role='combobox']");
	private By Semi_monthly = By.xpath("//li[.='Weekly']");

	private By Finish_Button= By.xpath("//button[.='Finish']");

	private By Congratulations = By.xpath("//div[.='Congratulations']");

	private By Go_To_Home = By.xpath("//button[.='Go To Home']");

	private By logo = By.xpath("//img[@alt='Logo']");

	private By Profile_Icon = By.xpath("//img[contains(@src , 'https://japfu-documents.codetru.org/avatar')]");

	private By Logout = By.xpath("(//div[.='Log out'])[2]");

	public void placement() throws Exception {

		clickElement(Placement);
		clickElement(Add_Placement);
		clickElement(Add);

	}

	public void Client_Details() throws Exception {
		sleep(1);
		clickElement(Client);
		clickElement(Kotak);	

		clickElement(Contact);
		clickElement(ContactName); 

		moveToElement(Continue_button);

		setText(Bill_rate, "70");
		setText(OT_Bill_rate, "95");
		sleep(1);
		clickElement(StartDate);
		clickElement(Date_1);

		sleep(1);
		clickElement(Continue_button);

	}

	public void Placement_Details() throws Exception {
		sleep(1);
		moveToElement(JobTitle);
		clickElement(JobTitle);
		clickElement(Project);	

		setText(Address_1,"278 S Franklin St");

		clickElement(State);
		clickElement(Alabama); 


		setText(City, DataGenerateUtils.randomCity());
		setText(Zipcode, DataGenerateUtils.randomZipCode());

		moveToElement(Continue_button);
		sleep(1);
		clickElement(Continue_button);

	}

	public void Payrate_Configuration() throws Exception {
		sleep(1);
		clickElement(PayType);
		clickElement(Salary);
		clickElement(Value_Button);

		setText(Payrate, "85");
		sleep(1);
		clickElement(Continue_button);

	}

	public void Timesheet_Configuration() throws Exception {
		sleep(1);
		clickElement(Timesheet_Cycle);
		clickElement(Semi_monthly);	
		sleep(1);

		moveToElement(Finish_Button);
		sleep(1);
		clickElement(Finish_Button);
		sleep(2);

		verifyElementVisible(Congratulations);

		sleep(2);
		clickElement(Go_To_Home);

		sleep(2);
		clickElement(logo);
		sleep(2);


	}


	public void Logout() throws Exception {
		sleep(2);
		clickElement(Profile_Icon);
		sleep(1);
		clickElement(Logout);
	}




}
