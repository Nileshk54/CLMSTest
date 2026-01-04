package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	


	@DataProvider
	public static Object[][] testExcelData() {
		String excelPath=System.getProperty("user.dir")+"/Excel/Data.xlsx";
		String sheetname="Logins";
		ExcelUtils excelUtils=new ExcelUtils(excelPath, sheetname);
		int rowCount=excelUtils.getRowCount();
		int colCount=excelUtils.getColumnCount();
		
		Object[][] excelData=excelUtils.dataFormatted(rowCount,colCount);
		return excelData;
	}
	
	@Test(dataProvider = "testExcelData")
	public void getExcelData(String username,String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	
	
}
