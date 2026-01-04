package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook work;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath,String sheetName) {
		try {
			work = new XSSFWorkbook(excelPath);
			sheet = work.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static int getRowCount() {
			int rowCount = sheet.getPhysicalNumberOfRows();
			//System.out.println(rowCount);
			return rowCount;
	}
	
	public static int getColumnCount() {
		int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println(columnCount);
		return columnCount;
	}

	public static  String getCellDataString(int rowNum,int colNum) {
			String celldata00 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(celldata00);
			return celldata00;
	}

	public static void getCellDataNumeric(int rowNum,int colNum) {
			String celldata00 = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(celldata00);
			double celldata01 = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(celldata01);
	}
	
	public static Object[][] dataFormatted(int rowNum,int colNum) {
		Object dataArray[][]=new Object[rowNum-1][colNum];
		DataFormatter df=new DataFormatter();
		
		for(int i=1;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				//here we will convert value into string with the help of DataFormatter
				String data=df.formatCellValue(sheet.getRow(i).getCell(j));
				// Below statement can fail when cell consist of Numeric value
				//String data=sheet.getRow(i).getCell(j).getStringCellValue();
				dataArray[i-1][j]=data;
			//	System.out.print(data + " | ");
			}
			//System.out.println();
		}
		return dataArray;
	}

	public static void main(String[] args) {
		getRowCount();
		//getCellDataString();
		//getCellDataNumeric();
	}

}
