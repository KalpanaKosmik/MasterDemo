package Dropdown;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Orange_Dropdown {
	WebDriver driver;
  @Test
  public void loginPage() {
	  driver.findElement(By.name("txtUserName")).sendKeys("selenium");
	  driver.findElement(By.name("txtPassword")).sendKeys("selenium");
	  driver.findElement(By.name("Submit")).click();
  }
  @Test
  public void verifyDropdownList() throws IOException{
	  //switch to frame
	  driver.switchTo().frame(0);
	  //identify dropdown element
	  WebElement dropdown=driver.findElement(By.id("loc_code"));
	  //get size of dropdown
	  List<WebElement> ddlist=dropdown.findElements(By.tagName("option"));
	  System.out.println("size of dropdwon is :"+ddlist.size());
	  //create array list for dropdown values
	  ArrayList<String> list=new ArrayList<String>();
	  //add dropdown values into arraylist object
	  for(int i=0;i<ddlist.size();i++)
	  {
		  list.add(ddlist.get(i).getText());
	  }
	  //Access excel file into eclipse
	  FileInputStream file=new FileInputStream("D:\\Excel\\OrangeHrm.xlsx");
	  //Get workbook from file
	  XSSFWorkbook book=new XSSFWorkbook(file);
	  //get sheet from workbook
	  XSSFSheet sheet=book.getSheet("Sheet1");
	  //Get total rows in sheet
	  int total_rows=sheet.getLastRowNum()+1;
	  System.out.println("number of rows in excel is: "+total_rows);
	  //Create Arraylist for xcel sheet 
	  ArrayList<String> xl_list=new ArrayList<String>();
	  //add xcel sheet rows into arraylist object
	  for(int j=0;j<total_rows;j++)
	  {
		  xl_list.add(sheet.getRow(j).getCell(0).getStringCellValue());
	  }
	  //compare xcel and dropdwn values
	  if(total_rows == ddlist.size())
	  {
		  for(int k=0;k<total_rows;k++)
		  {
			  for(int l=0;l<ddlist.size();l++)
			  {
				  if(xl_list.get(k).equals(list.get(l)))
				  {
					  System.out.println(xl_list.get(k) +"" +"mathched with"+list.get(l));
					  break;
				  }
			  }
		  }
	  }
	  else
	  {
		  System.out.println("size not matched");
	  }
	  
	  
  }
  @BeforeClass
  public void openBrowser() {
	  driver=new FirefoxDriver();
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
  }

  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }

}
