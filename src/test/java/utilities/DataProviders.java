package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="getData")
	public String[][] getData() throws IOException {

		String path = ".//testData//LoginData.xlsx";

		ExcelUtility utlity = new ExcelUtility(path);

		int rowCount = utlity.getRowCount("Sheet1");

		int cellCount = utlity.getCellCount("Sheet1", 1);

		String testdata[][] = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {

			for (int j = 0; j < cellCount; j++) {

				testdata[i-1][j] = utlity.getCellData("Sheet1", i, j);

			}

		}
		return testdata;

	}

}
