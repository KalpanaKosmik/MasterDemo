package Login_Property;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class LoginTest {
	WebDriver driver;
	Properties config;
	Properties or;
	
  @Test
  public void loginPage() throws IOException {
	  //create object for OR property file
	  or=new Properties();
	  //Access property file into eclipse and read the file
	  FileInputStream fileor=new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\OR.Properties");
	  or.load(fileor);
	  //navigate to url
	  driver.get(config.getProperty("TestSiteName"));
	  //identify username and password and give input
	  driver.findElement(By.xpath(or.getProperty("UserName"))).sendKeys("selenium");
	  driver.findElement(By.xpath(or.getProperty("Password"))).sendKeys("selenium");
	  //click on login button
	  driver.findElement(By.xpath(or.getProperty("Login"))).click();
	  
  }
  @Test
  public void verifyWelcomePage() throws InterruptedException
  {
	  String text=driver.findElement(By.xpath(or.getProperty("Welcome"))).getText();
	  //verify text in welcome page
	  System.out.println(text);
	  if(text.equals("Welcome selenium"))
	  {
		  System.out.println("welcome text verified");
	  }
	  else
	  {
		  System.out.println("not verified");
	  }
	  driver.findElement(By.xpath(or.getProperty("Logout"))).click();
	  Thread.sleep(3000);
	  
  }
  @BeforeClass
  public void launchBrowser() throws IOException {
	  //Create object for Config Property file
	  config=new Properties();
	  //Access config file into eclipse and read the file
	  FileInputStream file=new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\Config.Properties");
	  //store the config propertyfile
	  config.load(file);
	  //launch the browser
	  if(config.getProperty("Browser").equals("FireFox"))
	  {
		  driver=new FirefoxDriver();
	  }
	  
  }

  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }

}
