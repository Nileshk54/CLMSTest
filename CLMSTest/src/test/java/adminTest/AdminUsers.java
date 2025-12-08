package adminTest;

import org.testng.annotations.Test;

import adminPage.AdminUserMaster;
import baseTest.BaseTest;
import loginPage.LoginPage;

public class AdminUsers extends BaseTest{

	@Test
	public void getAllVendors() {
		LoginPage lp=new LoginPage(driver);
		lp.validLogin(username,password);
		AdminUserMaster adminUser=new AdminUserMaster(driver);
		adminUser.getAllVendors();
	}
	
	@Test
	public void getAllPurchase() {
		LoginPage lp=new LoginPage(driver);
		lp.validLogin(username,password);
		AdminUserMaster adminUser=new AdminUserMaster(driver);
		adminUser.getAllPurchase();
	}
}
