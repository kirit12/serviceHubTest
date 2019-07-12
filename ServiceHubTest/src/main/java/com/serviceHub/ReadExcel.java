package com.serviceHub;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String userName,password;
	public void readLoginData()
	{
		try{
		FileInputStream datafile = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook = new XSSFWorkbook(datafile);
	    Sheet sheet= workbook.getSheet("Login");
		Row row = sheet.getRow(1);
		userName = row.getCell(0).toString();
		password = row.getCell(1).toString();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
