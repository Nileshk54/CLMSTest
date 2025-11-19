package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By usernameElement=By.id("Username");
	By passwordElement=By.id("Password");
	By loginButtonElement=By.tagName("button");
	
	public void validLogin(String username,String password) {
		driver.findElement(usernameElement).sendKeys(username);
		driver.findElement(passwordElement).sendKeys(password);
		driver.findElement(loginButtonElement).click();
	}
}
