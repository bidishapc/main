package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {

    public static String getParticularData(int rowValue, int columnValue) {
        String data = null;
        try {
            File file = new File("C:\\Users\\ASUS\\Documents\\Book1.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");
            Row row = sheet.getRow(rowValue);
            Cell cell = row.getCell(columnValue);
            //String data=cell.getStringCellValue();
            // System.out.println(data);
            DataFormatter dataFormat = new DataFormatter();
            data = dataFormat.formatCellValue(cell);
            //System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;

    }

    public static void getAllData() {
        try {
            File file = new File("C:\\Users\\ASUS\\Documents\\Book1.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");

            int lastRowNum = sheet.getLastRowNum();
            System.out.println("No of rows : " + lastRowNum);

            Short lastCellNum = sheet.getRow(0).getLastCellNum();
            System.out.println("No of column : " + lastCellNum);

            for(int row=0;row<=lastRowNum;row++){
                Row rows = sheet.getRow(row);


                for(int clmn=0;clmn<lastCellNum;clmn++){
                    Cell cell = rows.getCell(clmn);
                    // DataFormatter --> it will convert the cell datatype in to string
                    DataFormatter dataFormat = new DataFormatter();
                    String data = dataFormat.formatCellValue(cell);
                    System.out.println(data);
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public static void main(String[] args) {
     getAllData();

  }
}
