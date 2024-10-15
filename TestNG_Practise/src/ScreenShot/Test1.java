package ScreenShot;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class Test1 {
	WebDriver driver;
  @Test
  public void screenShot() throws IOException {
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  driver.findElement(By.xpath("//input[@name='txtUserName']")).sendKeys("selenium");
	  driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("selenium");
	  driver.findElement(By.xpath("//input[@name='Submit']")).click();
	  //create file object to create files in desired location
	  File desired_loaction=new File("D:\\Screenshot\\image.jpg");
	  //change driver object to screenshot and take screen shot
	  File copy_screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  //copy the screenshot into the desired location using copy method from filehandler
	  FileHandler.copy(copy_screenshot, desired_loaction);
  }
  @BeforeClass
  public void beforeClass() {
	  driver=new FirefoxDriver();
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }
  

}
