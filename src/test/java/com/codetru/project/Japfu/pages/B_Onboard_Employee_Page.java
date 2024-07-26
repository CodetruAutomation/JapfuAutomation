package com.codetru.project.Japfu.pages;

import static com.Japfu.keywords.WebUI.clickElement;
import static com.Japfu.keywords.WebUI.isElementVisible;
import static com.Japfu.keywords.WebUI.moveToElement;
import static com.Japfu.keywords.WebUI.setText;
import static com.Japfu.keywords.WebUI.sleep;
import static com.Japfu.keywords.WebUI.verifyElementVisible;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;

import com.Japfu.keywords.WebUI;
import com.Japfu.utils.DataGenerateUtils;
import com.codetru.project.Japfu.CommonPageCICA;
import com.codetru.project.Japfu.ProjectUtils;



public class B_Onboard_Employee_Page extends CommonPageCICA{

	private By Employee = By.xpath("//img[@alt='employees']/following-sibling::span[.='Employees']");

	private By Add_Employee = By.id("add-employee"); 

	private By Onboard = By.xpath("//button[.='Onboard']");

	private By FirstName = By.name("first_name");
	private By LastName = By.name("last_name");

	private By DOB = By.xpath("//button[@aria-label='Choose date']");
	private By DOB_year = By.xpath("//button[@aria-label='calendar view is open, switch to year view']");
	private By DOB_year_1998 = By.xpath("//button[.='1998']");
	private By DOB_Date_1 = By.xpath("//button[.='1']");

	private By Gender = By.xpath("//label[.='Gender']/following-sibling::div/input[@role='combobox']");
	private By Gender_value = By.xpath("//li[.='Male']");

	private By Marital = By.xpath("//label[.='Marital Status']/following-sibling::div/input[@role='combobox']");
	private By Marital_status = By.xpath("//li[.='Single']");

	private By Contact_Number = By.name("contact_number");

	private By Email_id = By.name("email_id");

	private By Address1 = By.name("address_line_one");

	private By Country = By.xpath("//label[.='Country']/following-sibling::div/input[@role='combobox']");
	private By United_States = By.xpath("//li[.='United States']");

	private By State = By.xpath("//label[.='State']/following-sibling::div/input[@role='combobox']");
	private By Alabama = By.xpath("//li[.='Alabama']");

	private By City = By.name("city");
	private By Zipcode = By.name("zip_code");

	private By Employment_Type = By.xpath("//label[.='Employment Type']/following-sibling::div/input[@role='combobox']");
	private By Consultant = By.xpath("//li[.='Consultant']");
	private By Contractor = By.xpath("//li[.='Contractor']");

	//Consultant
	//Contractor

	private By Employment_category = By.xpath("//label[.='Employment Category']/following-sibling::div/input[@role='combobox']");
	private By W2 = By.xpath("//li[.='W2']");
	//	private By W1099 = By.xpath("//li[.='1099']");
	//	private By Srivari = By.xpath("//li[.='Srivari']");	

	private By Joining_Calander = By.xpath("//button[@aria-label='Choose date']");
	private By Left_Arrow = By.xpath("//*[local-name()='svg' and @data-testid='ArrowLeftIcon']");
	private By Joining_Date_1 = By.xpath("//button[.='1']");

	private By Employee_USC = By.xpath("//label[.='Is the Employee USC?']/following-sibling::div/input[@role='combobox']");
	private By Employee_yes = By.xpath("//li[.='Yes']");
	//	private By Employee_no = By.xpath("//li[.='No']");

	//	private By Enable_User_Access = By.xpath("//*[local-name()='svg' and @fill='none']//*[name()='rect']");

	private By Save_Button = By.xpath("//button[.='Save & Continue']");

	private By Logo = By.xpath("//img[@alt='Logo']");

	private By Emergency_Contact1_Name = By.xpath("(//input[@name='name'])[1]");
	private By Emergency_Contact1_Mobile = By.xpath("(//input[@name='contact_number'])[1]");
	private By Emergency_Contact1_Relation = By.xpath("(//label[.='Relation']/following-sibling::div/input[@role='combobox'])[1]");
	private By Emergency_Contact1_Father = By.xpath("//li[.='Father']");
	private By Emergency_Contact1_Address1 = By.xpath("(//label[.='Address Line-1']/following-sibling::div/input)[1]");
	private By Emergency_Contact1_Country = By.xpath("(//label[.='Country']/following-sibling::div/input[@role='combobox'])[1]");
	private By Emergency_Contact1_State = By.xpath("(//label[.='State']/following-sibling::div/input[@role='combobox'])[1]");
	private By Emergency_Contact1_City = By.xpath("(//input[@name='city'])[1]");
	private By Emergency_Contact1_Zipcode = By.xpath("(//input[@name='zip_code'])[1]");

	private By Emergency_Contact2_Name = By.xpath("(//input[@name='name'])[2]");
	private By Emergency_Contact2_Mobile = By.xpath("(//input[@name='contact_number'])[2]");
	private By Emergency_Contact2_Relation = By.xpath("(//label[.='Relation']/following-sibling::div/input[@role='combobox'])[2]");
	private By Emergency_Contact2_Brother = By.xpath("//li[.='Brother']");
	private By Emergency_Contact2_Address1 = By.xpath("(//label[.='Address Line-1']/following-sibling::div/input)[2]");
	private By Emergency_Contact2_Country = By.xpath("(//label[.='Country']/following-sibling::div/input[@role='combobox'])[2]");
	private By Emergency_Contact2_State = By.xpath("(//label[.='State']/following-sibling::div/input[@role='combobox'])[2]");
	private By Emergency_Contact2_City = By.xpath("(//input[@name='city'])[2]");
	private By Emergency_Contact2_Zipcode = By.xpath("(//input[@name='zip_code'])[2]");

	private By Work_Authorization = By.xpath("//div[.='Work Authorization']");
	private By Skip_Button = By.xpath("//button[.='Skip']");

	private By Add_Education_details = By.xpath("//div[.='Add Education Details']");

	private By Personal_Documents = By.xpath("//div[.='Personal Documents']");

	private By Cheque_Upload = By.xpath("(//button[.='Upload'])[1]");

	private By Bank_Name = By.name("bank_name");
	private By Account_Type = By.xpath("//label[.='Account Type']/following-sibling::div/input[@role='combobox']");
	private By Savings = By.xpath("//li[.='Savings']");
	private By Account_Number = By.name("account_number");
	private By Confirm_Account_Number = By.name("confirm_account_number");
	private By Routing_Number = By.name("routing_number");
	private By Confirm_Routing_Number = By.name("confirm_routing_number");

	private By Finish_Button = By.xpath("//button[.='Finish']");

	private By Congratulation = By.xpath("//div[.='Congratulations']");
	private By BackTOHome = By.xpath("//button[normalize-space()='Go To Home']");

	public static String fname;
	public static String Lname;
	public static String email;
	public static String pass = "Codetru@007";

	public void verify_Navigating_to_Homepage_Once_click_on_Login() throws Exception {

		if(!verifyElementVisible(Logo)) {
			System.out.println("Unable to Navigate to Homepage");
		}else if(verifyElementVisible(Logo)) {
			System.out.println("Navigated to Homepage");
		}
	}

	public void Employee_Information() throws Exception {

		clickElement(Employee );
		clickElement(Add_Employee);
		clickElement(Onboard);

		//basic details
		fname =  DataGenerateUtils.randomFirstName();
		Lname =  DataGenerateUtils.randomLastName();
		clickElement(Save_Button);
		sleep(1);
		setText(FirstName, fname);
		sleep(0.5);
		setText(LastName, Lname);
		sleep(0.5);
		
		ProjectUtils.clickElementForJira(DOB);
		sleep(0.5);
		clickElement(DOB_year);
		sleep(0.5);
		clickElement(DOB_year_1998);
		sleep(0.5);
		clickElement(DOB_Date_1);
		sleep(0.5);
		clickElement(Gender);
		clickElement(Gender_value);
		sleep(0.5);
		clickElement(Marital);
		clickElement(Marital_status);
		sleep(1);
		WebUI.scrollToElementAtBottom(Save_Button);
		clickElement(Save_Button);

		//Contact details
		clickElement(Save_Button);
		sleep(1);
		setText(Contact_Number, DataGenerateUtils.randomPhoneNumber());
		sleep(1);

		email =  DataGenerateUtils.randomEmail();
		//		setText(Email_id, "asasas");
		//		sleep(1);

		WebUI.clearAndFillText(Email_id, email);
		System.out.println("First Name ="+fname);
		System.out.println("Last Name ="+Lname);
		System.out.println("Email ="+email);
		System.out.println("Password ="+pass);
		clickElement(Save_Button);
		sleep(2);
		clickElement(Save_Button);
		String Add = "278 S Franklin St";

		//Current Address
		setText(Address1, Add);
		clickElement(Country);
		clickElement(United_States);
		clickElement(State);
		clickElement(Alabama);
		setText(City,DataGenerateUtils.randomCity());
		setText(Zipcode, DataGenerateUtils.randomZipCode());
		WebUI.scrollToElementAtBottom(Save_Button);
		clickElement(Save_Button);

		//Employment details
		sleep(1);
		clickElement(Save_Button);
		sleep(1);
		clickElement(Employment_Type);
		clickElement(Contractor);

		clickElement(Employment_category);
		clickElement(W2);

		clickElement(Joining_Calander);
		//		clickElement(Joining_year);
		//		clickElement(Joining_2024);
		sleep(0.5);
		clickElement(Left_Arrow);
		sleep(0.5);
		clickElement(Left_Arrow);
		sleep(0.5);
		clickElement(Left_Arrow);
		sleep(0.5);
		clickElement(Left_Arrow);
		sleep(0.5);
		clickElement(Left_Arrow);
		sleep(0.5);
		clickElement(Left_Arrow);
		clickElement(Joining_Date_1);

		//add or remove relation
		clickElement(Employee_USC);
		clickElement(Employee_yes);
		sleep(1);
		//clickElement(Enable_User_Access);
		//sleep(1);
		WebUI.scrollToElementAtBottom(Save_Button);

		clickElement(Save_Button);
		sleep(1);
		setText(Emergency_Contact1_Name, DataGenerateUtils.randomMiddleName());
		setText(Emergency_Contact1_Mobile, DataGenerateUtils.randomPhoneNumber());
		clickElement(Emergency_Contact1_Relation);
		clickElement(Emergency_Contact1_Father);
		setText(Emergency_Contact1_Address1, Add);
		clickElement(Emergency_Contact1_Country);
		clickElement(United_States);
		clickElement(Emergency_Contact1_State);
		clickElement(Alabama);

		moveToElement(Emergency_Contact2_Address1);

		setText(Emergency_Contact1_City, DataGenerateUtils.randomCity());
		setText(Emergency_Contact1_Zipcode, DataGenerateUtils.randomZipCode());

		setText(Emergency_Contact2_Name, DataGenerateUtils.randomFirstName());
		setText(Emergency_Contact2_Mobile, DataGenerateUtils.randomPhoneNumber());
		clickElement(Emergency_Contact2_Relation);
		clickElement(Emergency_Contact2_Brother);
		setText(Emergency_Contact2_Address1, Add);

		moveToElement(Save_Button);

		clickElement(Emergency_Contact2_Country);
		clickElement(United_States);
		clickElement(Emergency_Contact2_State);
		clickElement(Alabama);
		setText(Emergency_Contact2_City,  DataGenerateUtils.randomCity());
		setText(Emergency_Contact2_Zipcode, DataGenerateUtils.randomZipCode());
		clickElement(Save_Button);

		sleep(1);
		isElementVisible(Work_Authorization, 20);
		clickElement(Skip_Button);

		sleep(1);
		isElementVisible(Add_Education_details, 20);
		clickElement(Skip_Button);

		sleep(1);
		isElementVisible(Personal_Documents, 20);
		clickElement(Skip_Button);
		
		sleep(2);
		clickElement(Cheque_Upload);
		sleep(1);

		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdataCMS\\I9 Document.jpg";

		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		sleep(2);
		clickElement(Cheque_Upload);
		sleep(1);

		String filePath1 = System.getProperty("user.dir")+"\\src\\test\\resources\\testdataCMS\\W4 form.jpg";

		StringSelection selection1 = new StringSelection(filePath1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		sleep(2);
		clickElement(Cheque_Upload);
		sleep(1);

		String filePath2 = System.getProperty("user.dir")+"\\src\\test\\resources\\testdataCMS\\Void CHeque.jpg";

		// Copy the file path to the clipboard
		StringSelection selection2 = new StringSelection(filePath2);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection2, null);

		// Press Ctrl + V to paste the file path
		sleep(1);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Press Enter to close the file upload dialog
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		sleep(2);
		setText(Bank_Name, "Citizens Bank");

		clickElement(Account_Type);
		clickElement(Savings);

		setText(Account_Number, "4099999992 ");
		setText(Confirm_Account_Number, "4099999992 ");

		setText(Routing_Number, "011075150");
		setText(Confirm_Routing_Number, "011075150 ");

		moveToElement(Finish_Button);
		sleep(0.5);
		
		clickElement(Finish_Button);

		sleep(2);

		verifyElementVisible(Congratulation);
		clickElement(BackTOHome);
		sleep(2);



	}



}



