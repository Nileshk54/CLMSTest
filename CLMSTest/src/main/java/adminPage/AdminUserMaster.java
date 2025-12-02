package adminPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.GetDetails;
import utils.GetTotalEntries;

public class AdminUserMaster {

	private WebDriver driver;
	private org.apache.logging.log4j.Logger log=LogManager.getLogger(AdminUserMaster.class);
	private Select filterSelect;
	//locators
	
	private By userTypeDropdownElement=By.id("UserType");
	private By searchUserElement=By.id("searchbtn");
	private By getUserNameElement=By.xpath("//tbody/tr/td[2]");
	
	public AdminUserMaster(WebDriver driver) {
		this.driver=driver;
	}
	
	public void applyUserFilter(String userType) {
		log.debug(userType + " dropdown ");
		WebElement userTypeDropdown=driver.findElement(userTypeDropdownElement);
		
		Select selectDropdown=new Select(userTypeDropdown);
		selectDropdown.selectByVisibleText(userType);
		driver.findElement(searchUserElement).click();
		log.debug(userType + " searched ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getAllVendors() {
		applyUserFilter("Vendor");
		List<WebElement> userNames=driver.findElements(getUserNameElement);
		int totalEntries=GetTotalEntries.getTotalEntries();
		log.debug("Total " + totalEntries +" vendor user found");
		GetDetails.getAllDetails(getUserNameElement, totalEntries);
	}
	
	
	
	
}
