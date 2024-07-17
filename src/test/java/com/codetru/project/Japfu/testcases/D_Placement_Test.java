package com.codetru.project.Japfu.testcases;

import org.testng.annotations.Test;
import com.codetru.common.BaseTest;

public class D_Placement_Test extends BaseTest {


	@Test(priority = 1)
	public void TC_Employee_Placement() throws Exception {

		getStep_2Page().placement();
		getStep_2Page().Client_Details();
		getStep_2Page().Placement_Details();
		getStep_2Page().Payrate_Configuration();
		getStep_2Page().Timesheet_Configuration();
		getStep_2Page().Logout();

	}




}
