package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	
	public static String Read(int row,int column) 
	{
		String CellData = null ;
		final String path = "D:\\mayur\\car finance\\Java Workspace\\TestData.xlsx";
		
		
		try 
		{
	
				
			 FileInputStream fis = new FileInputStream(path);
			
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);
				
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			XSSFCell cell = sheet.getRow(row).getCell(column);
			CellData = cell.getStringCellValue();
			//return CellData;
			workbook.close();
			fis.close();
			
			
		} 
		catch (FileNotFoundException e)
		{
			//print error
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			//print error
			e.printStackTrace();
		}
		catch(Exception e)
		{
			return "";
		}
		 
		return CellData;
		
		
	}
	
	
	//This method is to write in the Excel cell, Row num and Col num are the parameters
//NEED TO MODIFY IF WANT TO USE
//	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
//
//			try{
//
//  			Row  = ExcelWSheet.getRow(RowNum);
//
//			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
//
//			if (Cell == null) {
//
//				Cell = Row.createCell(ColNum);
//
//				Cell.setCellValue(Result);
//
//				} else {
//
//					Cell.setCellValue(Result);
//
//				}
//
//  // Constant variables Test Data path and Test Data file name
//
//  				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
//
//  				ExcelWBook.write(fileOut);
//
//  				fileOut.flush();
//
//					fileOut.close();
//
//				}catch(Exception e){
//
//					throw (e);
//
//			}
//
//		}
	
	

}
