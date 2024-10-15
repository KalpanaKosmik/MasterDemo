package WebTable;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class WebTable_Verify {
	WebDriver driver;
  @Test
  public void verifyWebTable() throws IOException {
	  
	  //identify webtable and count total rows
	  
	  int allrows=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
	  System.out.println("total rows in webtable :" +allrows);
	  
	  //count total columns in webtable
	  
	  int allcol=driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/td")).size();
	  System.out.println("total columns in webtable :" +allcol);
	  
	  //Access excelfile into eclipse
	  
	  FileInputStream file= new FileInputStream("D:\\Excel\\WebTable.xlsx");
	  
	  //get workbook from excel file
	  
	  XSSFWorkbook wb= new XSSFWorkbook(file);
	   //get sheet from workbook
	   
	  XSSFSheet sheet=wb.getSheet("Sheet1");
	  
	  //count total rows and columns in excel sheet
	  
	  int rowcount=sheet.getLastRowNum()+1;
	  int colcount=sheet.getRow(0).getLastCellNum();
	  System.out.println("Total rows and columns in sheet are :" +rowcount +"and" +colcount);
	   
	  //create Array list object for excel data 
	  
	  ArrayList<String> xlvalues=new ArrayList<String>();
	  //read data from excel sheet and add in arraylist 
	  
	  for(int i=0;i<rowcount;i++)//read rows
	  {
		  for(int j=0;j<colcount;j++)//read columns
		  {
			  System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
			  xlvalues.add(sheet.getRow(i).getCell(j).getStringCellValue());
		  }
		  System.out.println();
	  }
	  
	  //create arraylist for webtable and add webtable data into arraylist
	  
	  ArrayList<String> wbtable=new ArrayList<String>();
	  
	  //read data from table and add into arraylist
	  
	  for(int k=1;k<=allrows;k++)//read row data
	  {
		  for(int l=1;l<=allcol;l++)
		  {
			  String data=driver.findElement(By.xpath("/html/body/table/tbody/tr[" + k + "]/td[" + l + "]")).getText();
			  System.out.print(data +" ");
			  wbtable.add(data);
		  }
		  System.out.println();
	  }
	  
	  //compare webtable and excel sheet data
	   
	  int totalsize=allrows*allcol;
	  
	  for(int m=0;m<totalsize;m++)
	  {
		  if(xlvalues.get(m).equals(wbtable.get(m)))
		  {
			  System.out.println(xlvalues.get(m) +"is matched with " +wbtable.get(m));
		  }
		  else
		  {
			  System.out.println("not matched");
		  }
	  }
	  
	  
  }
  @BeforeClass
  public void openBrowser() {
	  driver=new FirefoxDriver();
	  // navigate to url
	  
	  driver.get("file:///C:/Users/KALPANA/Downloads/webtable.html");
  }

  @AfterClass
  public void closeBrowser() {
	  //close browser window
	  
	  driver.close();
  }

}
