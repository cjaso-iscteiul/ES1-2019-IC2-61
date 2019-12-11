package projeto;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readExcelFile {
	
	protected ArrayList<String> lista = new ArrayList<String>();
	
	
	public ArrayList<String> getLista(){
		return this.lista;
	}
	
	
	public void showExcel() {
		try
        {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\ritap\\Desktop\\ISCTE\\3º ano\\Engenharia de Software I\\Long-Method.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
//                    System.out.println(cell.getStringCellValue());
//                    lista.add(cell.getStringCellValue());
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) 
                    {
                        case NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + "\t");
                            String sN = String.valueOf(cell.getNumericCellValue());
                            lista.add(sN);
                            break;
                        case STRING:
//                            System.out.print(cell.getStringCellValue() + "\t");
                            lista.add(cell.getStringCellValue());
                            break;
                        case BOOLEAN:
//                        	System.out.print(cell.getBooleanCellValue() + "\t");
                        	String sB = String.valueOf(cell.getBooleanCellValue());
                        	lista.add(sB);
                        	break;
                    }
                }
                System.out.println("");
            } 
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}
