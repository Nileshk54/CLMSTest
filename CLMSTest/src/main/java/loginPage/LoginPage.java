package loginPage;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseTest.BaseTest;

public class LoginPage{

	private WebDriver driver;
	private org.apache.logging.log4j.Logger log;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By usernameElement=By.id("Username");
	By passwordElement=By.id("Password");
	By loginButtonElement=By.tagName("button");
	
	public void validLogin(String username,String password) {
		log=LogManager.getLogger(LoginPage.class);
		log.info("Valid login Called username :" + username + " password: " + password);
		driver.findElement(usernameElement).sendKeys(username);
		driver.findElement(passwordElement).sendKeys(password);
		driver.findElement(loginButtonElement).click();
	}
}
