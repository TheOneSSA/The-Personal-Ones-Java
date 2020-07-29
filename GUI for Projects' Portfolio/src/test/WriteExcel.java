package test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class WriteExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Employee Data");
		TreeMap<String,Object[]> data = new TreeMap<String,Object[]>();
		data.put("1",new Object[] {"ID", "NAME", "LASTNAME"});
		data.put("2",new Object[] {1, "Soumya S.", "Acharya"});
		data.put("3", new Object[] {2,"Abhineet","Mishra"});
		data.put("4",new Object[] {3,"Nandita","Nupur"});
		data.put("5", new Object[] {4,"Ashutosh","Anand"});
		
		Set<String> keyset=data.keySet();
		int rownum=0;
		for(String key:keyset)
		{
			XSSFRow row=sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for(Object obj:objArr)
			{
				Cell cell=row.createCell(cellnum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
				
				
			}
			
		}
		try
		{
			FileOutputStream out=new FileOutputStream("E:\\DemoExcel.xlsx");
		
			wb.write(out);
			out.close();
			System.out.println("DemoExcel.xlsx is successfully written on the disk");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			
		}
		
		

	}

}
