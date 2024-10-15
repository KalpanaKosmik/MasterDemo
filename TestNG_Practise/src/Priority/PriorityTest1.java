package Priority;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class PriorityTest1 {
	WebDriver driver;
	Properties config;
	Properties or;
  @Test(priority=1)
  public void loginPage() throws IOException {
	  //navigate to URL
	  driver.get(config.getProperty("TestSiteName"));
	  //Create object for OR file
	  or=new Properties();
	  //read OR Properties file
	  FileInputStream fileor=new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\OR.Properties");
	  or.load(fileor);
	  //identify username password  and enter username,password
	  driver.findElement(By.xpath(or.getProperty("UserName"))).sendKeys("selenium");
	  driver.findElement(By.xpath(or.getProperty("Password"))).sendKeys("selenium");
	  //click on login button
	  driver.findElement(By.xpath(or.getProperty("Login"))).click();
  }
  @Test(priority=2)
  public void verifyTitleOfPage()
  {
	  String title=driver.getTitle();
	  System.out.println(title);
	  
	  //verify title of page
	  Assert.assertEquals(title, "OrangeHRM");
	  System.out.println("title verified successfully");
  }
  @Test(priority=3)
  public void verifyText()
  {
	 String text= driver.findElement(By.xpath(or.getProperty("Welcome"))).getText();
	 System.out.println(text);
	 Assert.assertEquals(text, "Welcome selenium");
	 System.out.println("welcome text verified successfully");
  }
  @Test(priority=4)
  public void logoutPage()
  {
	  driver.findElement(By.xpath(or.getProperty("Logout"))).click();
  }
  @BeforeClass
  public void launchBrowser() throws IOException {
	  //create properties object for config file
	  config=new Properties();
	  //read properties file into working environment
	  FileInputStream file=new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\Config.Properties");
	  config.load(file);
	  //launch browser
	  if(config.getProperty("Browser").equals("FireFox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  else
	  {
		  System.out.println("browser not found");
	  }
  }

  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }

}
