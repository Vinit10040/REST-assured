package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook ;//XSSFWorkbook class for xslx excel format
	static  XSSFSheet sheet ;// XSSFSheet class for xslx excel format
	
	//static HSSFWorkbook workbook ;  HSSFWorkbook class for xsl excel format
	//static HSSFSheet sheet ; HSSFSheet class for xsl excel format
	
	public ExcelUtils(String excelpath, String sheetname) {
		
		
	
		try {
			
		        workbook = new XSSFWorkbook(excelpath);//XSSFWorkbook class for xslx excel format
			
		  /*      //InputStream file = new FileInputStream(excelpath); 
			workbook = new HSSFWorkbook(new POIFSFileSystem(file));
			this code is for calling xsl file format 
			*/
	            sheet = workbook.getSheet(sheetname);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
        }

/*	public static void main(String[] args) {
		
		getRowCounts();
		getCelldata();
	}
	*/
	public static void getCelldata(int rownum, int colnum) {
		
				//String excelpath = "./Exceldata/TestData.xlsx";
	        DataFormatter dataformat = new DataFormatter();
	        Object value = dataformat.formatCellValue(sheet.getRow(rownum).getCell(colnum));
	        
	        //double value = sheet.getRow(1).getCell(2).getNumericCellValue();
	        System.out.println("value is "+value);
	
		
	}
	public static void getRowCounts() {
    
		// String prjdir = System.getProperty("user.dir");
		 //System.out.println("location is:"+prjdir);
		
	//	String excelpath = "./Exceldata/TestData.xlsx";
		
			
	        
	        int rowcount = sheet.getPhysicalNumberOfRows();
	        System.out.println(rowcount);
		
		
			}
	
}
