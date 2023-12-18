package letcode_practice;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL_file_dynamic_reading {

	public static void main(String[] args) throws IOException {
		String filelocation= "./Data/data_ for_testing.xlsx";
		XSSFWorkbook wbook=new XSSFWorkbook(filelocation);
		DataFormatter dft=new DataFormatter();
		XSSFSheet sheet=wbook.getSheetAt(0);
		//get the row count
		int row_count=sheet.getLastRowNum();//exclusive of header
		//int row_count=sheet.getPhysicalNumberOfRows();//inclusive of header
		System.out.println("row count- "+row_count);
		//always use the first row for getting cell
		short Cell_count=sheet.getRow(0).getLastCellNum();
		System.out.println("cell count- "+Cell_count);
		//use that row count as condition 
		for(int i=1;i<=row_count;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<=Cell_count;j++) {
				XSSFCell cell=row.getCell(j);
				//we are using dataformater object for conveting int to string
				String value=dft.formatCellValue(cell);
				System.out.println(value);
			}
		}
wbook.close();
	}

}
