package automation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\TestData\\test.xlsx");
		
		XSSFWorkbook workbook =new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet();
		
		XSSFRow row1=sheet.createRow(0);
		row1.createCell(0).setCellValue("Username");
		row1.createCell(1).setCellValue("Password");
		row1.createCell(2).setCellValue("Confirm Password");
		
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("ABC");
		row2.createCell(1).setCellValue("Abc@1223");
		row2.createCell(2).setCellValue("Abc@1223");
		
		
		XSSFRow row3=sheet.createRow(2);
		
		row3.createCell(0).setCellValue("PQR");
		row3.createCell(1).setCellValue("Pqr@1223");
		row3.createCell(2).setCellValue("Pqr@1223");
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Writing Excel is Done!!!!!!!!!");
		
		
		FileInputStream file1 =new FileInputStream("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\TestData\\test.xlsx");
		
			XSSFWorkbook workbook1 =new XSSFWorkbook(file1);
				 
			XSSFSheet sheet1 =workbook1.getSheet("Sheet0");
			
			int totalrows=sheet1.getLastRowNum();
			int totalcol=sheet1.getRow(1).getLastCellNum();
			
			System.out.println("Total no of Rows are:->"+totalrows);
			System.out.println("Total no of Cols are:->"+totalcol);
		
			for(int r=0;r<=totalrows;r++)
			{
				XSSFRow row=sheet1.getRow(r);
				
				for(int c=0;c<totalcol;c++)
				{
					XSSFCell cell=row.getCell(c);
					String value=cell.toString();
					System.out.print(value+"\t");
				}
				
				System.out.println(" ");
			}
			
			
			workbook.close();
			file.close();
			
			System.out.println("Reading Excel is Done!!!!!!!!!!!!!!!!!!!!!!");
	}

}
