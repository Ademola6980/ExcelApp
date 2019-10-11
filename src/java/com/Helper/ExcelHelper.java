/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Helper;

import com.entities.Customer;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 *
 * @author Femi
 */
public class ExcelHelper {
    
    private List<String> fileNames = new ArrayList<String>();
    private Workbook workbook = null;
    private String workbookName=""; 
    
    public ExcelHelper(String workbookName)
    {
        this.workbookName=workbookName;
        initialize();
        
    }
    
    private void initialize()
    {
        setWorkbook(new HSSFWorkbook());
    }
    
    public void closeWorkSheet()
    {
        
    }
    
    public void readData(String path)
    {
        try {
            
            //String path="C:\\\\test.xls";
			
			FileInputStream file = new FileInputStream(new File(path));
			
			//Get the workbook instance for XLS file 
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			//Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			//Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				
				//For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType()) {
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.print(cell.getBooleanCellValue() + "\t\t");
							break;
						case Cell.CELL_TYPE_NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t\t");
							break;
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + "\t\t");
							break;
					}
				}
				System.out.println("");
			}
			file.close();
			FileOutputStream out = 
				new FileOutputStream(new File(path));
			workbook.write(out);
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }
    

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public String getWorkbookName() {
        return workbookName;
    }

    public void setWorkbookName(String workbookName) {
        this.workbookName = workbookName;
    }
    
    
    
}
