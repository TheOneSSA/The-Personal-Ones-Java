package test;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchExcel {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream file = new FileInputStream("E:\\DemoExcel.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheetAt(0);
			int rownum=0;
			String cellcontent="ita";
			rownum=findRow(sheet,cellcontent);
			System.out.println("Row number:"+rownum);
			file.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	 static int findRow(XSSFSheet sheet,String cellcontent)
	{
		for(Row row:sheet)
			for(Cell cell:row)
				switch(cell.getCellType())
				{
				case STRING:
					System.out.println(cell.getStringCellValue());
					if(cell.getStringCellValue().contains(cellcontent))
						return row.getRowNum();
					break;
				
						
				}
		
		return 99;
	}
}

					
		
		
					
					
					
	