package utils;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import adminPage.AdminUserMaster;
import baseTest.BaseTest;

public class GetDetails extends BaseTest{

	private static By nextButtonElement=By.xpath("//a[text()='Next']");
	private static org.apache.logging.log4j.Logger log=LogManager.getLogger(GetDetails.class);
	
	
	public static void getAllDetails(By WebElement, int totalEntries ) {
		int innerLoop=1;
		int outerCount=1;
		boolean flag=true;
		do {
			List<WebElement> details=driver.findElements(WebElement);
			int size=details.size()>10?10:details.size();
			for(int i=0;i<size-1;i++) {
				log.debug(details.size());
				log.debug(details.get(i).getText() + " " + innerLoop + i);
				innerLoop++;
				outerCount++;
				if(i==10 && totalEntries>10) {
					driver.findElement(nextButtonElement).click();
					totalEntries=totalEntries-10;
					i=0;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
				}
				
				if(totalEntries<10 && totalEntries>0) {
					log.debug(i);
					flag=false;
				}


			}
		} while (flag);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
