package ExcelPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class practice {
	

	public void getData(String testcaseName) throws IOException {

		//ArrayList<String> arr = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C:\\Users\\khanb\\Downloads\\WowzaTestcases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int numberOfSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < numberOfSheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Data")) {

				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.rowIterator();
				Row firstRow = rows.next();

				Iterator<Cell> ce = firstRow.cellIterator();

				int k = 0;
				int column = 0;
				while (ce.hasNext()) {

					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("name")) {

						column = k;
					}
					k++;

				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row rv = rows.next();

					if (rv.getCell(column) != null
							&& rv.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {

						Iterator<Cell> c = rv.iterator();

						while (c.hasNext()) {

							System.out.println(c.next().getStringCellValue());

						}

					}

				}

			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		practice p = new practice();
		p.getData("aisha");

	}
}
