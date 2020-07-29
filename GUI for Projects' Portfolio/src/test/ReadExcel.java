package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream file =new FileInputStream("E:\\DemoExcel.xlsx");
			XSSFWorkbook wb =new XSSFWorkbook(file);
			XSSFSheet sheet =wb.getSheetAt(1);
			
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext())
			{
				
				Row row =rowIterator.next();
				Iterator<Cell> cellIterator =row.cellIterator();
				do
				{
					
					Cell cell= cellIterator.next();
					switch(cell.getCellType())
					{
					case NUMERIC:
						
						System.out.print(cell.getNumericCellValue()+"\t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue()+"\t");
						break;
					case BLANK:
						System.out.print("Hey"+"\t");
						break;
			
						
					}
					
					
				}while(cellIterator.hasNext());
				System.out.println("");
				file.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
