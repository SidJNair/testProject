package excelRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead
{
	
	XSSFSheet sh;
	
	public ExcelRead() throws IOException
	{
		FileInputStream f= new FileInputStream("F:\\Workspace-Automation\\Project\\src\\main\\resources\\excelFiles\\ProjectExcel.xlsx");
		XSSFWorkbook w= new XSSFWorkbook(f);
		sh=w.getSheet("Sheet1");
		
	}
	
	public String numericReadData(int i, int j) 
	{
		
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		
		int a = (int) c.getNumericCellValue();
		return String.valueOf(a);
	}
	
	public String readingStringData(int i,int j) 
	{
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}

	
 
	

}
