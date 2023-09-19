package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	public static String[][] testdata(){
		FileInputStream fis;
		//.xlsx files (.xls->hssfworkbook)
		XSSFWorkbook workbook = null;
		try {
			fis=new FileInputStream("C:\\Anna Automation\\HybridFramework\\testdata\\testdata.xlsx");
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Total number of rows used in sheet: "+rowCount);
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Total nummber of columns used in sheet: "+colCount);
		
		String[][] testdata=new String[rowCount][colCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
			 testdata[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return testdata;

	}
//	
//	public static void main(String[] args) {
//		String arr[][]=testdata();
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				System.out.println(arr[i][j]);
//
//			}
//		}
//	}
}
