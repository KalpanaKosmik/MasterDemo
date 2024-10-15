package Excel_Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Login_xls {
	WebDriver driver;
  @Test
  public void login_xls() throws IOException, InterruptedException {
	//access excelfile into eclipse
		FileInputStream file=new FileInputStream("D:\\Excel\\Book1.xls");
		//get the workbook from file
		HSSFWorkbook workbook=new HSSFWorkbook(file);
		//get sheet from workbook
		HSSFSheet sheet=workbook.getSheet("Login");
		//read username data from sheet
		String username=sheet.getRow(1).getCell(0).getStringCellValue();
		//read password data from sheet
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		//identify username element  and give input
		driver.findElement(By.name("txtUserName")).sendKeys(username);
		//identify password element and give input
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		//click on login button
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		//click on logout
		driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/a")).click();

  }
  @BeforeClass
  public void openBrowser() {
	  driver=new FirefoxDriver();
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  

}
