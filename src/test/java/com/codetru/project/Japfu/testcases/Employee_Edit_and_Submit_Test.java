package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;

import com.Japfu.utils.JiraCreateIssue;
import com.codetru.common.BaseTest;


public class Employee_Edit_and_Submit_Test extends BaseTest {
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 1)
	public void Edit_and_Submit_Employee_Personal_Details1() throws Exception {
		getStep_3Page().Logout();
		getLoginPage().Valid_Username_Password("liam@doid.ai", "Codetru@005");
		getStep_9Page().Update_Employee_Personal_Details();
		getStep_3Page().Logout();
		
		
	}
	  
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 2)
	public void Edit_and_Submit_Employee_Personal_Details2() throws Exception {

		getLoginPage().Valid_Username_Password("noah@doid.ai", "Codetru@007");
		getStep_9Page().Update_Employee_Personal_Details();
		getStep_3Page().Logout();
	}

}