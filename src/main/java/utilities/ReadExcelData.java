package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelData {
    public static void main(String[] args) throws IOException {
        ReadExcelData readData = new ReadExcelData();
        readData.getExcelFileData("login");
    }

    public String[][] getExcelFileData(String excelSheetName) throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\testdata.xlsx");
        //Create a stream for the file variable
        FileInputStream fileInputStream = new FileInputStream(file);
        //Look into the excel workbook
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheetName = workbook.getSheet(excelSheetName);

        //get number of used rows
        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);
        //Get number of columns
        Row rowCells = sheetName.getRow(0);
        int totalColumn = rowCells.getLastCellNum();
        System.out.println(totalColumn);

        //Format data
        DataFormatter format = new DataFormatter();

        String testData[][] = new String[totalRows][totalColumn];
        //i is starting from 1 because we skipping the header in row no a column
        for (int i =1; i<= totalRows; i++){
            for (int j = 0; j< totalColumn; j++){
                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
        return testData;
    }
}
