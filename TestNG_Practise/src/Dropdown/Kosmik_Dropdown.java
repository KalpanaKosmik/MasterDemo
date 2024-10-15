package Dropdown;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Kosmik_Dropdown {
	WebDriver driver;
  @Test
  public void loginPage() {
	  driver.findElement(By.name("username")).sendKeys("kosmik");
	  driver.findElement(By.name("password")).sendKeys("kosmik");
	  driver.findElement(By.name("submit")).click();
  }
  @Test
  public void verifyDropdownList() throws IOException
  {
	  //identify registration and click on it
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[1]/a")).click();
	  //identify drop down list of patient identifier
	  WebElement dropdown=driver.findElement(By.name("PAT_IDENTITY"));
	  //size of drop down list
	  List<WebElement> ddlist=dropdown.findElements(By.tagName("option"));
	  System.out.println("size of dropdown is :" +ddlist.size());
	  //create array list to drop down elements
	  ArrayList<String> list=new ArrayList<String>();
	  //add drop down elements into arraylist
	  for(int i=0;i<ddlist.size();i++)
	  {
		  list.add(ddlist.get(i).getText());
	  }
	  //access xcel file into eclipse
	  FileInputStream file=new FileInputStream("C:\\Users\\KALPANA\\Downloads\\Dropdown-xls.xls");
	  //get Workbook from file
	  HSSFWorkbook wb=new HSSFWorkbook(file);
	  //get sheet from workbook
	  HSSFSheet sheet=wb.getSheet("Sheet2");
	  //total rows in sheet
	  int total_rows=sheet.getLastRowNum()+1;
	  System.out.println("number of rows :" +total_rows);
	  //add excel sheet rows into arraylist
	  ArrayList<String> xl_list=new ArrayList<String>();
	  for(int j=0;j<total_rows;j++)
	  {
		  xl_list.add(sheet.getRow(j).getCell(0).getStringCellValue());
	  }
	//compare xcel and dropdwn values
	  if(total_rows == ddlist.size())
	  {
		  for(int k=0;k<total_rows;k++)//xcel data
		  {
			  for(int l=0;l<ddlist.size();l++)//dropdown data
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
	  driver.get("https://www.kosmiktechnologies.com/seleniumLiveProject/kosmik-hms/");
	  
	  
  }

  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }

}
