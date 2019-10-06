package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


class DataSource{
	
	String value;
	

	public void setValue(String value)
	{
		this.value = value;
	}
	
	
	public String getValue()
	{
		return value;
	}
	
}


public class ExcelUtils {
	
	private static final String FILE_NAME = "dataSourcesTest.xlsx";

    public static void main(String[] args) {
    	
    	
    	List<DataSource> dataSourceObj = new ArrayList<DataSource>();

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

            	DataSource locators = new DataSource();
            		
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        //System.out.print(currentCell.getStringCellValue() + "--");
                        locators.setValue(currentCell.getStringCellValue());

                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                    	System.out.println("Step 2");
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }
                    
                    dataSourceObj.add(locators);

                }
                System.out.println();

            }
            
            for(int i=0;i<20;i++){
            DataSource ds = dataSourceObj.get(i);
            System.out.println(ds.value);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


