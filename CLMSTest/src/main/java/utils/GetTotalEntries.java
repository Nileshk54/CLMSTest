package utils;

import org.openqa.selenium.By;

import baseTest.BaseTest;

public class GetTotalEntries extends BaseTest{
	
	private static By showEntries=By.id("acexample_info");

	public static int getTotalEntries() {
		String text=driver.findElement(showEntries).getText();
		int totalEntries=Integer.parseInt(text.split(" ")[5]);
		System.out.println(totalEntries);
		return totalEntries;
	}
	
}
