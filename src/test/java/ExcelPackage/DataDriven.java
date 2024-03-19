package ExcelPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testcase) throws IOException {
		ArrayList<String> arr = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C://Users//khanb//Downloads//WowzaTestcases.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int numberOfSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < numberOfSheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("Data")) {

				XSSFSheet sheet = workbook.getSheetAt(i); // sheet is collection of rows

				// Identify row that you want to search
				Iterator<Row> rows = sheet.rowIterator(); // row is collection of cell
				// it will take you on the first row
				Row firstRow = rows.next();

				Iterator<Cell> ce = firstRow.cellIterator();

				int k = 0;
				int column = 0;
				while (ce.hasNext()) {

					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("name")) {

						// desired column
						column = k;

					}
					k++;
				}

				System.out.println(column);
				while (rows.hasNext()) {

					Row rv = rows.next();

					if (rv.getCell(column) != null
							&& rv.getCell(column).getStringCellValue().equalsIgnoreCase(testcase)) {

						Iterator<Cell> cv = rv.cellIterator();
						while (cv.hasNext()) {

							//System.out.println(cv.next().getStringCellValue());

							Cell c = cv.next();
							if (c.getCellType() == CellType.STRING) {
								arr.add(c.getStringCellValue());
							} else if (c.getCellType() == CellType.NUMERIC) {

								System.out.println(c.getNumericCellValue());
							}

							else {

								arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}
					}
				}

			}

		}
		return arr;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

}
