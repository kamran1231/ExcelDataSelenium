package TestNGDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGwithExcel {

	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "testData")
	public void testcase(String name, String job, String add) {

		System.out.println(name + job + add);
	}

	@DataProvider(name = "testData")
	public Object[][] getData() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\khanb\\Downloads\\WowzaTestcases.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// int numberOfSheets = workbook.getNumberOfSheets();

		XSSFSheet sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();

		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();

		Object data[][] = new Object[rowCount-1][colCount];

		for (int i = 0; i < rowCount - 1; i++) {

			row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {

				// In excel there will be the multiple data type so we will convert it in string

				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;

	}
}
