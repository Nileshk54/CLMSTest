package navigations;

import org.openqa.selenium.By;
import org.testng.Assert;

import adminPage.AdminPage;
import baseTest.BaseTest;

public class AdminNavigations extends BaseTest{

	// Master Locators
	private static By masterDropdownClickElement=By.xpath("//div[@class='dropdown']");
	private static By departmentMasterElement=By.xpath("//div[@class='dropdown']/div/a[1]");
	private static By locationAreaMasterElement=By.xpath("//div[@class='dropdown']/div/a[2]");
	private static By vendorCategoryMasterElement=By.xpath("//div[@class='dropdown']/div/a[1]");
	private static By vendorSubCategory=By.xpath("//div[@class='dropdown']/div/a[1]");
	private static By importMasterElement=By.xpath("//div[@class='dropdown']/div/a[1]");
	private static By importWorkerMasterElement=By.xpath("//div[@class='dropdown']/div/a[1]");
	
	//Text Field Locator
	
	private static By departmentMasterTextElement=By.xpath("//li[contains(text(), 'Department')]");
	
	public static AdminPage navigateToDepartment() {
		driver.findElement(masterDropdownClickElement).click();
		driver.findElement(departmentMasterElement).click();
		Assert.assertEquals(driver.findElement(departmentMasterTextElement).getText(), "Department Master");
		return new AdminPage(driver);
	}
	
	
}
