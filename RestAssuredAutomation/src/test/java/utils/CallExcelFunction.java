package utils;

public class CallExcelFunction {
public static void main(String[] args) {
	
	
	String excelpath = "./Exceldata/TestData.xlsx";
	String sheetname = "sheet1";
	ExcelUtils excel = new ExcelUtils(excelpath, sheetname);
	
	excel.getRowCounts();
	excel.getCelldata(1, 0);
	excel.getCelldata(1, 1);
	excel.getCelldata(1, 2);
	excel.getCelldata(2, 0);
	excel.getCelldata(2, 1);
	excel.getCelldata(2, 2);
	excel.getCelldata(2, 3);
}
}
