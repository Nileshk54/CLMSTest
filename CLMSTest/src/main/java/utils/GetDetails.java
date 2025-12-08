package utils;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import adminPage.AdminUserMaster;
import baseTest.BaseTest;

public class GetDetails extends BaseTest {

	private static By nextButtonElement = By.xpath("//a[text()='Next']");
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(GetDetails.class);

	public static void getAllDetails(By WebElement, int totalEntries) {
		int processedEntries = 0;
		while (processedEntries < totalEntries) {
			int size = 10;
			for (int row = 0; row < size; row++) {
				List<WebElement> details = driver.findElements(WebElement);
				log.debug(details.get(row).getText() + " " + processedEntries);
				System.out.println(details.get(row).getText() + " " + processedEntries);
				processedEntries++;
				if (row == 9 && totalEntries > 10) {
					driver.findElement(nextButtonElement).click();
					totalEntries = totalEntries - 10;
					log.debug("Remaining :" + totalEntries);
					row = -1;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (totalEntries < 10 && totalEntries > 0) {
					size = totalEntries;
				}
			}

		}

	}

}
