package adminTest;

import org.testng.annotations.Test;

import adminPage.AdminPage;
import baseTest.BaseTest;
import loginPage.LoginPage;
import navigations.AdminNavigations;

public class AdminTest extends BaseTest{

	@Test
	public void getAllDepartments() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.validLogin(username,password);
		AdminPage admin=AdminNavigations.navigateToDepartment();
		admin.getAllDepartment();
	}
	
	
	
	
}
