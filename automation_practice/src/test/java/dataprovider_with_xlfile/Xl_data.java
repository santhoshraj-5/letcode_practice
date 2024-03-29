package dataprovider_with_xlfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Xl_data {
@Test(priority = 1)
	public String[][] xldata() throws IOException {
		String filelocation = "./Data/data_ for_testing.xlsx";
		File file =new File(filelocation);
		FileInputStream stream= new FileInputStream(file);
		XSSFWorkbook wbook=new XSSFWorkbook(stream);;
		/*
		 * try { wbook = new XSSFWorkbook(stream); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		XSSFSheet sheet=wbook.getSheetAt(0);
		int row_count=sheet.getLastRowNum();
		short cell_count=sheet.getRow(0).getLastCellNum();
		DataFormatter dft=new DataFormatter();
		String[][] data=new String[row_count][cell_count];
		for(int i=1;i<row_count;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<cell_count;j++) {
				XSSFCell cell=row.getCell(j);
				String value=dft.formatCellValue(cell);
				data[i-1][j]=value;
			}
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
@DataProvider(name="login")
@Test(priority = 2)
public Object[][] getdata() throws IOException{
	Object[][] exldata=xldata();
	return exldata;
	
}
}
