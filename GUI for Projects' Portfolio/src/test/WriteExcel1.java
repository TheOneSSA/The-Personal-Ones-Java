package test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Employee Details");
		TreeMap <String,Object[]> data=new TreeMap<String,Object[]>();
		data.put("1",new Object[] {"ID","Stream"});
		data.put("2",new Object[] {1,"Computer Science & Engineering"});
		data.put("3", new Object[] {2,"Electrical Engineering"});
		data.put("4", new Object[] {3,"Computer Science & Engineering"});
		data.put("5", new Object[] {4,"Computer Science & InformationTechnology"});
		
		Set<String> keyset = data.keySet();
		int rownum =0;
		for(String key:keyset)
		{
			XSSFRow row=sheet.createRow(rownum++);
			Object[] objarr=data.get(key);
			int cellnum=0;
			for(Object obj:objarr)
			{
				Cell cell= row.createCell(cellnum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
			}
		}
		try
		{
			FileOutputStream out =new FileOutputStream("E:\\DemoExcel.xlsx");
			wb.write(out);
			out.close();
			System.out.println("DemoExcel.xlsx has been saved ");
			
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		

	}


