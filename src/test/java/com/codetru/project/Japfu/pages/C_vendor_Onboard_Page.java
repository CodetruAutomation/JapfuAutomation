package com.codetru.project.Japfu.pages;

import static com.Japfu.keywords.WebUI.*;
import org.openqa.selenium.By;
import com.Japfu.utils.DataGenerateUtils;
import com.codetru.project.Japfu.CommonPageCICA;


public class C_vendor_Onboard_Page extends CommonPageCICA{

	private By Clients = By.xpath("//img[@alt='ledger']");
	
	private By Vendor = By.xpath("//div[.='Vendors']");

	private By Add_vendor = By.xpath("//img[@alt='plus']");

	private By Vendor_Name = By.xpath("//label[.='Vendor Name']/following-sibling::div/input[@type='text']");
	//private By Client_Id = By.name("reference_id");
	
	private By Address_1 = By.name("address_line_one");

	private By State = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	private By Alabama = By.xpath("//li[.='Alabama']");

	private By City = By.name("city");

	private By Save_Button = By.xpath("//button[.='Save & Continue']");

	private By Zipcode = By.name("zip_code");

	private By Firstname = By.name("first_name");

	private By Lastname = By.name("last_name");

	private By Email = By.name("email_id");

	private By Phone_number = By.name("telephone_number");

	private By Finish_Button = By.xpath("//button[.='Finish']");

	private By Completion_message = By.xpath("//div[.='Succesfully Added!']");

//	private By crossButton = By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']");

	private By Go_To_Home = By.xpath("//button[.='Go To Home']");




	public static String fname;
	public static String Lname;
	public static String pass = "Codetru@007";

	public void UserDetails_Confirmation() throws Exception {

		clickElement(Clients);
		clickElement(Vendor);
		clickElement(Add_vendor);		}

	public void Visit_StartAndStop() throws Exception {//Client Details
		sleep(2);

		setText(Vendor_Name, "HUL"); 

		setText(Address_1, "278 S Franklin St"); 
		clickElement(State);
		clickElement(Alabama);
		setText(City, DataGenerateUtils.randomCity());
		setText(Zipcode, DataGenerateUtils.randomZipCode());
		moveToElement(Save_Button);
		clickElement(Save_Button);

		//		if(!DriverManager.getDriver().findElement(crossButton).isDisplayed()) {
		//			System.out.println("Cross is not displayed");
		//		}else if(DriverManager.getDriver().findElement(crossButton).isDisplayed()) {
		//			clickElement(crossButton);
		//			System.out.println("Cross is displayed");
		//		}
		sleep(3);
	}

	public void VendorContactDetails() throws Exception {
		sleep(1);
		moveToElement(Firstname);
		
		fname = DataGenerateUtils.randomFirstName();
		Lname=DataGenerateUtils.randomLastName();
		setText(Firstname, fname); 
		setText(Lastname, Lname);
		setText(Email, DataGenerateUtils.randomEmail());
		setText(Phone_number, DataGenerateUtils.randomPhoneNumber());
		moveToElement(Finish_Button);
		sleep(1);
		clickElement(Finish_Button);
	}

	public void GoHome() throws Exception {
		sleep(1);
		verifyElementVisible(Completion_message);
		clickElement(Go_To_Home);
	}



}



