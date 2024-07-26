package com.codetru.project.Japfu.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Japfu.keywords.WebUI;

public class DashboardValidationsPage {

	private By clientsTab = By.xpath("//a[@href='/clients']");
	private By viewAnalyticsButton = By.xpath("//button[text()='View Analytics']");
	//	private By totalBilled_Element = By.xpath("(//div[@class='MuiBox-root css-11ca26'])[2]");
	//	private By totalPay_Element = By.xpath("(//div[@class='MuiBox-root css-11ca26'])[3]");
	//	private By margin_Element = By.xpath("(//div[@class='MuiBox-root css-11ca26'])[4]");

	private By dashboardTab = By.xpath("//a[@href='/dashboard']");
	//	private By totalBilled_Element_Dash = By.xpath("(//div[@class='MuiTypography-root MuiTypography-body1 jss269 css-9l3uo3'])[2]");
	//	private By totalPay_Element_Dash = By.xpath("(//div[@class='MuiTypography-root MuiTypography-body1 jss269 css-9l3uo3'])[3]");
	//	private By margin_Element_Dash = By.xpath("(//div[@class='MuiTypography-root MuiTypography-body1 jss269 css-9l3uo3'])[4]");

	private By totalBilled_Element_ = By.xpath("//div[.='Total Billed']/following-sibling::div");
	private By totalPay_Element_ = By.xpath("//div[.='Total Pay']/following-sibling::div");
	private By margin_Element_ = By.xpath("//div[.='Margin']/following-sibling::div");

	//	private By clientList_Element = By.xpath("//div[@class='jss637 MuiBox-root css-0']/div");
	private By clientList_Element = By.xpath("(//div[starts-with(text(),'CLT')]/ancestor::div[starts-with(@class, 'jss')])[last()]/div");

	//	private By totalBilled_Dyn_List = By.xpath("//div[@class='jss637 MuiBox-root css-0']/div/div[4]/div");
	//	private By totalPay_Dyn = By.xpath("(//div[@class='jss637 MuiBox-root css-0'])/div[1]//descendant::div[19]/div");
	private By totalBilled_Dyn_List = By.xpath("((//div[starts-with(text(),'CLT')])[4]/parent::div/parent::div/parent::div/following-sibling::div)[3]");


	public double totalBilled;
	public double totalPay;
	public double margin;
	public double totalBilled_Dash;
	public double totalPay_Dash;
	public double margin_Dash;
	public List<String> clientNames;

	public void Get_Value_From_DB_AP() {
		WebUI.sleep(1);
		System.out.println(WebUI.getTextElement(totalBilled_Element_));
		totalBilled_Dash = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element_));
		System.out.println(WebUI.getTextElement(totalPay_Element_));
		totalPay_Dash = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element_));
		System.out.println(WebUI.getTextElement(margin_Element_));
		margin_Dash = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element_));
		WebUI.sleep(0.5);
		WebUI.clickElement(clientsTab);
		WebUI.sleep(1);
		WebUI.clickElement(viewAnalyticsButton);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(margin_Element_);
		WebUI.sleep(0.5);
		//WebUI.scrollToElementAtBottom(By.xpath("(//div[@class='jss637 MuiBox-root css-0']/div)[last()]"));
		WebUI.scrollToElementAtBottom(By.xpath
				("(//div[starts-with(text(),'CLT')]/ancestor::div[starts-with(@class, 'jss')])[last()]/div"));

		System.out.println(WebUI.getTextElement(totalBilled_Element_));
		totalBilled = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element_));
		System.out.println(WebUI.getTextElement(totalPay_Element_));
		totalPay = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element_));
		System.out.println(WebUI.getTextElement(margin_Element_));
		margin = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element_));

	}

	//(//div[.='Total Pay'])[2]/parent::div/following-sibling::div//div[contains(@class,'container')]/div[contains(@class,'jss')]
	//(//div[starts-with(text(), 'CLT')]/ancestor::div[starts-with(@class, 'jss')])[last()]
	//parent::div/parent::div/parent::div/following-sibling::div//div)[3]

	// final xp	((//div[starts-with(text(),'CLT')])[1]/parent::div/parent::div/parent::div/following-sibling::div)[3]
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
		for(int i=1; i<=clients.size(); i++)
		{	
			double temp_Billed = removeSpacesAndSpecialChars(WebUI.getTextElement(By.xpath
					("((//div[starts-with(text(),'CLT')])["+i+"]/parent::div/parent::div/parent::div/following-sibling::div)[3]")));
			System.out.println("*********************** Total Billed "+i+": "+temp_Billed);	
			totalBilled_Clients = totalBilled_Clients+temp_Billed;
		}

		for(int i=1; i<=clients.size(); i++)
		{			
			//double temp_Pay = removeSpacesAndSpecialChars(WebUI.getTextElement(By.xpath("(//div[@class='jss637 MuiBox-root css-0'])/div["+i+"]//descendant::div[19]/div")));
			double temp_Pay = removeSpacesAndSpecialChars(WebUI.getTextElement(By.xpath
					("((//div[starts-with(text(),'CLT')])["+i+"]/parent::div/parent::div/parent::div/following-sibling::div)[4]")));

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
		double tb_d = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element_));
		double tp_d = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element_));
		double marg_d = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element_));

		WebUI.clickElement(clientsTab);
		WebUI.sleep(1);
		WebUI.clickElement(viewAnalyticsButton);
		WebUI.sleep(1);
		WebUI.scrollToElementAtBottom(margin_Element_);
		WebUI.sleep(1);

		double tb_a = removeSpacesAndSpecialChars(WebUI.getTextElement(totalBilled_Element_));
		double tp_a = removeSpacesAndSpecialChars(WebUI.getTextElement(totalPay_Element_));
		double marg_a = removeSpacesAndSpecialCharsWithMinus(WebUI.getTextElement(margin_Element_));

		WebUI.verifyEquals(tb_d, tb_a);
		WebUI.verifyEquals(tp_d, tp_a);
		WebUI.verifyEquals(marg_d, marg_a);
		WebUI.sleep(1);
		
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
