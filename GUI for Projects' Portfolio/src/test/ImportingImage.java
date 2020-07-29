package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportingImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileOutputStream file=new FileOutputStream("E:\\DemoExcel.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook();
			XSSFSheet sheet=wb.createSheet("My Sample Excel");
			InputStream img=new FileInputStream("E:\\BarChart.jpeg");
			byte[] bytes=IOUtils.toByteArray(img);
			int pictIdx=wb.addPicture(bytes,XSSFWorkbook.PICTURE_TYPE_JPEG);
			img.close();
			CreationHelper helper=wb.getCreationHelper();
			Drawing drawing=sheet.createDrawingPatriarch();
			ClientAnchor anchor=helper.createClientAnchor();
			
			anchor.setCol1(5);
			anchor.setRow1(1);
			anchor.setCol2(10);
			anchor.setRow2(20);
			Picture pict=drawing.createPicture(anchor,pictIdx);
			Cell cell =sheet.createRow(1).createCell(1);
			
			
			
			wb.write(file);
			file.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
