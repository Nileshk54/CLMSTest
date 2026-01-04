package utils;

public class ExcelUtilsCall {
	public static void main(String[] args) {
		String excelPath=System.getProperty("user.dir")+"/Excel/Data.xlsx";
		String sheetname="Logins";
		ExcelUtils excelUtils=new ExcelUtils(excelPath, sheetname);
	//	excelUtils.getRowCount();
	//	excelUtils.getColumnCount();
	//	excelUtils.getCellDataString(1,1);
	
	//	excelUtils.getCellDataNumeric(3,1);
	}
}
