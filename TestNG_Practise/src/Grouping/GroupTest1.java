package Grouping;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class GroupTest1 {
	WebDriver driver;
	Properties config;
	Properties or;
  @Test(groups="Smoke")
  public void loginButtonClick() throws IOException {
	  //create object for config file
	  config=new Properties();
	  //access and read config file
	  FileInputStream file= new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\Config.Properties");
	  config.load(file);
	  if(config.getProperty("Browser").equals("FireFox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  else
	  {
		  System.out.println("browser not available");
	  }
	
	  //navigate to URL
	  driver.get(config.getProperty("TestApplication"));
	  //create object for OR file and read file
	  or=new Properties();
	  FileInputStream fileor=new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\OR.Properties");
	  or.load(fileor);
	
	  //identify and give input to username and password
	  
	  driver.findElement(By.xpath(or.getProperty("Username"))).sendKeys("kosmik");
	  driver.findElement(By.xpath(or.getProperty("Password1"))).sendKeys("kosmik");
	  //click on loginbutton
	  driver.findElement(By.xpath(or.getProperty("LoginButton"))).click();
  }
  
 /* @BeforeClass
  public void launchBrowser() throws IOException {
	  //create object for config file
	  config=new Properties();
	  //access and read config file
	  FileInputStream file= new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\Config.Properties");
	  config.load(file);
	  if(config.getProperty("Browser").equals("FireFox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  else
	  {
		  System.out.println("browser not available");
	  }
	  
  }*/

  /*@AfterClass
  public void closeBrowser() {
	 // driver.close();
  }*/

}
