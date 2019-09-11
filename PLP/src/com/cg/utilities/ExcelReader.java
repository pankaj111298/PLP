package com.cg.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
 

public class ExcelReader {

	/*public static void ReadExeclData(String filepath,String filename,String sheetname) throws IOException
	{
		File file=new File(filepath+"/"+filename);
		FileInputStream i=new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(i);
		Sheet sheet=wb.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		for(int r=0;r<rowcount;r++)
		{
			Row row=sheet.getRow(r);
			for(int c=0;c<row.getLastCellNum();c++)
			{
				Cell cell=row.getCell(c);
				System.out.println(cell.getStringCellValue()+ "\t");
			}
			System.out.println(" ");
		}
	}*/
	
	public static Object[][] ReadExeclDataToObject(String filepath,String filename,String sheetname) throws IOException
		{
			File file=new File(filepath+"/"+filename);
			FileInputStream i=new FileInputStream(file);
			XSSFWorkbook wb= new XSSFWorkbook(i);
			Sheet sheet=wb.getSheet(sheetname);
			int rowcount=sheet.getLastRowNum();
			Object[][] data=new Object[rowcount][1];
			Row keyrow=sheet.getRow(0);
			Hashtable<String,String> rec=null; 
			for(int r=1;r<rowcount+1;r++)
			{
				Row datarow=sheet.getRow(r);
				rec= new Hashtable<String,String>();
				for(int c=0;c<datarow.getLastCellNum();c++)
				{
					String key=keyrow.getCell(c).getStringCellValue();
					String val=datarow.getCell(c).getStringCellValue();
					rec.put(key, val);
				}
				data[r-1][0]=rec;
			}
			
			
			return data;
		
	}
	/*public static void main(String[] args) throws IOException {
		String filename="Details.xlsx";
		String filepath=System.getProperty("user.dir")+"/src/com/cg/testdata";
		String sheetname="perdetails";
		ExcelReader.Read(filepath, filename, sheetname);
		//return ExcelReader.ReadExeclDataToObject(filepath, filename, sheetname);	
		}*/

}
