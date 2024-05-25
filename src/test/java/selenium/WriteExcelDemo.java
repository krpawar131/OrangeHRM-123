package selenium;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDemo {

	public static void main(String[] args) throws IOException {
		
		
		FileOutputStream file=new FileOutputStream("C:\\Users\\kisho\\eclipse-workspace\\AutomationBatch1\\TestData\\test.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		
		XSSFRow row1=sheet.createRow(0);
		
		row1.createCell(0).setCellValue("Course");
		row1.createCell(1).setCellValue("Tool");
		row1.createCell(2).setCellValue("Duration");
		

		XSSFRow row2=sheet.createRow(1);
		
		row2.createCell(0).setCellValue("Selenium Java Automation");
		row2.createCell(1).setCellValue("Selenium WEBDRIVER");
		row2.createCell(2).setCellValue("4 Months");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Writing is done..!!!!");
		
	}

}
