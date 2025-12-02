package adminPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import baseTest.BaseTest;
import utils.GetDetails;
import utils.GetTotalEntries;

public class AdminPage{

	WebDriver driver;
	
	private By allDepartmentsElement=By.xpath("//tbody/tr/td[2]");
	private org.apache.logging.log4j.Logger log;
	
	public AdminPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getAllDepartment() throws InterruptedException {
		log=LogManager.getLogger(AdminPage.class);
		log.debug("Getting all Department");
		List<WebElement> allDepartments=driver.findElements(allDepartmentsElement);
		int totalEntries=GetTotalEntries.getTotalEntries();
		log.debug(totalEntries +" department found");
		//GetDetails.getAllDetails(allDepartments,totalEntries);
	}
	
	
	

	
}
