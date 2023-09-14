package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	// This class will have common methods to read test case data from excel 

	public static String[][] readData(String workbook, String sheetname) {
		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + workbook);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetname);
			int totalrows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			data = new String[totalrows - 1][totalColumns];
			for (int r = 1; r < totalrows; r++) {
				for (int c = 0; c < totalColumns; c++) {
					data[r - 1][c] = sh.getRow(r).getCell(c).getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
