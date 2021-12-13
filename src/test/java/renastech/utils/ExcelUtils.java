package renastech.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    public String getCellData() throws IOException {

        String filePath="/Users/jessicca/IdeaProjects/SeleniumCucumberTesting/src/test/resources/ExcelSheet.xls";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("sheet1");

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        for (int r = 0; r <= rows; r++) {

            XSSFRow row = sheet.getRow(r);

            for (int c = 0; r <= cols; c++) {

                XSSFCell cell = row.getCell(c);

                switch ((cell.getCellType())) {

                    case STRING:
                        System.out.println(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.println(cell.getBooleanCellValue());
                        break;

                }
            }
        }
            return getCellData();
    }
}
