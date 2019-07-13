package com.serviceHub;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	Logger log = LogManager.getLogger(ReadExcel.class.getName());
	public String userName,password;
	public String client,Fname,Lname,Pdate,add1,add2,zip,email,DDate,service,mobile,claimType,serviceType;
	
	public Sheet getSheet(String sheetName)
	{
		
		Sheet sheet=null;
		try {
			FileInputStream datafile = new FileInputStream("./src/test/resources/TestData.xlsx");
			Workbook workbook = new XSSFWorkbook(datafile);
		    sheet= workbook.getSheet(sheetName);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sheet;
	}
	public void readLoginData()
	{
		try{
		Sheet getsheet=getSheet("Login");
		Row row = getsheet.getRow(1);
		userName = row.getCell(0).toString();
		password = row.getCell(1).toString();
		
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
		}
	}
	public void addOrderData()
	{
		try{
			Sheet getsheet=getSheet("AddOrder");
			Row row = getsheet.getRow(1);
			client = row.getCell(0).toString();
			Fname = row.getCell(1).toString();
			Lname = row.getCell(2).toString();
			Pdate = row.getCell(9).toString();
			add1 = row.getCell(3).toString();
			add2 = row.getCell(4).toString();
			zip = row.getCell(5).toString();
			log.info("zipcode" + zip);
			email = row.getCell(8).toString();
			DDate = row.getCell(10).toString();
			service = row.getCell(11).toString();
			mobile = row.getCell(12).toString();
			claimType = row.getCell(16).toString();
			serviceType = row.getCell(17).toString();
			}
			catch(Exception e)
			{
				log.info(e.getMessage());
			}
	}
}
