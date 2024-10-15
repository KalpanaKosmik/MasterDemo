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

public class Drop_Down {
	WebDriver driver;
  @Test
  public void verifyDropdownList() throws IOException {
	  //identify dropdown 
	 WebElement dropdown= driver.findElement(By.name("selectionField"));
	 //get the size of dropdown elements
	 List<WebElement> ddcount=dropdown.findElements(By.tagName("option"));
	 //print size of dropdown list
	 System.out.println("Size of dropdown :"+ddcount.size());
	 //create arraylist object for dropdown elements
	 ArrayList<String> ddlist=new ArrayList<String>();
	 //store dropdownelements in arraylist object
	 /*for loop is used to add elements in array list
	  * add elements is repeated action
	  */
	 for(int i=0;i<ddcount.size();i++)
	 {
		 ddlist.add(ddcount.get(i).getText());
	 }
	 //access excel file into eclipse
	 FileInputStream file=new FileInputStream("C:\\Users\\KALPANA\\Downloads\\Kalpana.xlsx");
	 //get workbook from excel file
	 XSSFWorkbook workbook=new XSSFWorkbook(file);
	 //Get the sheet from workbook
	 XSSFSheet sheet=workbook.getSheet("Dropdown");
	 //get the row size of excel sheet
	 int total_rows=sheet.getLastRowNum()+1;
	 //print size of excel sheet rows
	 System.out.println("number of rows :"+ total_rows);
	 //create arraylist object for excel sheet
	 ArrayList<String> xl_list =new ArrayList<String>();
	 //store elements of excel sheet in xl_list
	 for(int j=0;j<total_rows;j++)
	 {
		 xl_list.add(sheet.getRow(j).getCell(0).getStringCellValue());
	 }
	 //compare size and values of dropdown list and excel list 
	 if( total_rows == ddcount.size() )
	 {
		 //excel size
		 for(int k=0;k<total_rows;k++)
		 {
			 // dropdown values 
			 for(int l=0;l<ddcount.size();l++)
			 {
				 //compare dropdown with excel values
				 if(xl_list.get(k).equals(ddlist.get(l)))
				 {
					 System.out.println(xl_list.get(k) + "matched with" +ddlist.get(l));
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
	  driver.get("http://www.tizag.com/htmlT/htmlselect.php");
  }

  @AfterClass
  public void closeBrowser() {
	  driver.quit();
  }

}
