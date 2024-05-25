package automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo1 {

	public static void main(String[] args) throws IOException {
		
		//1.read the xl file
		//FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx");		

		FileInputStream file =new FileInputStream("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\TestData\\TestData.xlsx");
	
	//2. workbook read 
	
		XSSFWorkbook workbook =new XSSFWorkbook(file);
	
	 // 3. read sheet
	 
		XSSFSheet sheet =workbook.getSheet("Sheet1");
	
	// total no of rows and column
		
		int totalrows=sheet.getLastRowNum();
		int totalcol=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Total no of Rows are:->"+totalrows);
		System.out.println("Total no of Cols are:->"+totalcol);
		
	// read all excel data
		
		for(int r=0;r<=totalrows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			
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
	}
	
	

}
