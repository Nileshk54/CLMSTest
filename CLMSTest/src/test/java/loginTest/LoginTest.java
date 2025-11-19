package loginTest;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import loginPage.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void validLogin() {
		LoginPage lp=new LoginPage(driver);
		lp.validLogin(username,password);
	}
	
}
