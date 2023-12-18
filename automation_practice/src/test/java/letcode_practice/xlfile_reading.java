package letcode_practice;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlfile_reading {

	public static void main(String[] args) throws IOException //in this i have writen only the basic so with this we need to optimism
	{
		//storage location
		String filelocation= "./Data/data_ for_testing.xlsx";
		//goinig to the file
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
		
			//get the sheet
			XSSFSheet sheet=wbook.getSheetAt(0);
			//now go the row we want
			XSSFRow row=sheet.getRow(1);
			//get the cell 
			XSSFCell cell=row.getCell(0);
			//get string from that cell
			String value=cell.getStringCellValue();
			System.out.println(value);
			wbook.close();
		
	}
}
