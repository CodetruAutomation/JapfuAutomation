package com.codetru.project.Japfu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Japfu.keywords.WebUI;

public class DashboardValidationsPage {
	private By Email = By.name("email");
	private By Submit_Btn = By.xpath("//button[@type='submit']");
	private By Password_Btn = By.xpath("//button[.='Enter Password']");
	private By Password = By.name("password");
	private By Logo = By.xpath("//img[@alt='Logo']");
	
	private By clientsTab = By.xpath("//a[@href='/clients']");
	private By viewAnalyticsButton = By.xpath("//button[text()='View Analytics']");
	private By totalBilled_Element = By.xpath("(//div[@class='MuiBox-root css-11ca26'])[2]");
	private By totalPay_Element = By.xpath("(//div[@class='MuiBox-root css-11ca26'])[3]");
	private By margin_Element = By.xpath("(//div[@class='MuiBox-root css-11ca26'])[4]");
	
	private By placementsTab = By.xpath("//a[@href='/placements']");
	private By placement_Searchbox = By.xpath("//input[@placeholder='Search by Name / ID']");
	private By emp_List_After_Search_In_Placements = By.xpath("//div[@class='MuiBox-root css-j567hf']/div");
	
	private By timesheetTab = By.xpath("//a[@href='/timesheet']");
	private By pending_Approval = By.xpath("//button[text()='Pending Approval']");
	private By timesheet_PA_Searchbox = By.xpath("//input[@placeholder='Search by Name / Timesheet ID']");
	private By emp_List_After_Search_In_Timesheet = By.xpath("//div[@class='MuiBox-root css-112je16']/div");
	private By view_Button_List_After_Search_In_Timesheet_PA_Tab = By.xpath("//div[@class='MuiBox-root css-112je16']/div//div[6]");
	private By view_button = By.xpath("(//div[.='View'])[1]");
	private By edit_Button = By.xpath("//button[text()='Edit']");
	private By approve_Button = By.xpath("//button[text()='Approve']");
	private By OT_Days = By.xpath("//table/tbody/tr[2]/td/input[@type='text']");
	private By resumbit_Button = By.xpath("//button[text()='Resubmit']");
	private By done_Popup = By.xpath("(//button[text()='Done'])[2]");
	private By GotoHome_Button = By.xpath("//button[text()='Go To Home']");
	
	
	private By dashboardTab = By.xpath("//a[@href='/dashboard']");
	private By totalBilled_Element_Dash = By.xpath("(//div[@class='MuiTypography-root MuiTypography-body1 jss269 css-9l3uo3'])[2]");
	private By totalPay_Element_Dash = By.xpath("(//div[@class='MuiTypography-root MuiTypography-body1 jss269 css-9l3uo3'])[3]");
	private By margin_Element_Dash = By.xpath("(//div[@class='MuiTypography-root MuiTypography-body1 jss269 css-9l3uo3'])[4]");
	
	//Analytics Home
	//(//div[@class='jss636 MuiBox-root css-0']//div[1]//div[@class='MuiTypography-root MuiTypography-body1 jss340 css-9l3uo3' and contains(text(),'$')])[1]
	private By clientList_Element = By.xpath("//div[@class='jss637 MuiBox-root css-0']/div");
	private By totalBilled_Dyn_List = By.xpath("//div[@class='jss637 MuiBox-root css-0']/div/div[4]/div");
	private By totalPay_Dyn = By.xpath("(//div[@class='jss637 MuiBox-root css-0'])/div[1]//descendant::div[19]/div");
	
	
	public double totalBilled;
	public double totalPay;
	public double margin;
	public double totalBilled_Dash;
	public double totalPay_Dash;
	public double margin_Dash;
	public List<String> clientNames;
	
	public void Get_Value_From_DB_AP()
	{
		WebUI.sleep(1);
		System.out.println(WebUI.getTextElement(totalBilled_Element_Dash));
		totalBilled_Dash = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element_Dash));
		System.out.println(WebUI.getTextElement(totalPay_Element_Dash));
		totalPay_Dash = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element_Dash));
		System.out.println(WebUI.getTextElement(margin_Element_Dash));
		margin_Dash = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element_Dash));
		WebUI.sleep(0.5);
		WebUI.clickElement(clientsTab);
		WebUI.sleep(1);
		WebUI.clickElement(viewAnalyticsButton);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(margin_Element);
		WebUI.sleep(0.5);
		WebUI.scrollToElementAtBottom(By.xpath("(//div[@class='jss637 MuiBox-root css-0']/div)[last()]"));
		System.out.println(WebUI.getTextElement(totalBilled_Element));
		totalBilled = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element));
		System.out.println(WebUI.getTextElement(totalPay_Element));
		totalPay = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element));
		System.out.println(WebUI.getTextElement(margin_Element));
		margin = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element));
		
	}
	
	
	public void Get_Data_From_Clients_And_Validate()
	{
		WebUI.verifyEquals(totalBilled_Dash, totalBilled);
		WebUI.verifyEquals(totalPay_Dash, totalPay);
		WebUI.verifyEquals(margin_Dash, margin);
		
		double totalBilled_Clients = 0.0;
		double totalPay_Clients = 0.0;
		
		List<WebElement> clients = WebUI.getWebElements(clientList_Element);
		clientNames = WebUI.getElementTextsInList(clientList_Element);
		
		List<String> total_Billed_list = WebUI.getElementTextsInList(totalBilled_Dyn_List);
		for(String T_bill : total_Billed_list)
		{
			double temp_Billed = removeSpacesAndSpecialChars(T_bill);
			System.out.println("*********************** Total Billed "+T_bill+": "+temp_Billed);	
			totalBilled_Clients = totalBilled_Clients+temp_Billed;
		}
		
		for(int i=1; i<=clients.size(); i++)
		{			
			double temp_Pay = removeSpacesAndSpecialChars(WebUI.getTextElement(By.xpath("(//div[@class='jss637 MuiBox-root css-0'])/div["+i+"]//descendant::div[19]/div")));
			System.out.println("*********************** Total Pay "+i+": "+temp_Pay);
			totalPay_Clients = totalPay_Clients+temp_Pay;
		}
		
		//Verify Total Billed and Total Pay data from right side client list with left side column data
		WebUI.verifyEquals(totalBilled_Clients, totalBilled);
		WebUI.verifyEquals(totalPay_Clients, totalPay);		
		WebUI.verifyEquals((totalBilled_Clients-totalPay_Clients), margin);
	}
	
	public void Approve_Timesheet_And_Validate_Data()
	{
		WebUI.clickElement(dashboardTab);
		WebUI.sleep(1);
		double tb_d = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element_Dash));
		double tp_d = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element_Dash));
		double marg_d = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element_Dash));
		
		WebUI.clickElement(clientsTab);
		WebUI.sleep(1);
		WebUI.clickElement(viewAnalyticsButton);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(margin_Element);
		WebUI.sleep(1);
		
		double tb_a = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element));
		double tp_a = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element));
		double marg_a = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element));
		
		WebUI.verifyEquals(tb_d, tb_a);
		WebUI.verifyEquals(tp_d, tp_a);
		WebUI.verifyEquals(marg_d, marg_a);
 
	}
	
 
    public static Double removeSpacesAndSpecialChars(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
 
        // Remove spaces and special characters using regex
        String cleanedString = input.replaceAll("[^\\d.]", "");
        
        // Convert to Double
        return Double.parseDouble(cleanedString);
    }
    
    public static Double removeSpacesAndSpecialCharsWithMinus(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
 
        // Remove spaces and special characters except minus symbol using regex
        String cleanedString = input.replaceAll("[^\\d.-]", "");
        
        // Convert to Double
        return Double.parseDouble(cleanedString);
    }
}
