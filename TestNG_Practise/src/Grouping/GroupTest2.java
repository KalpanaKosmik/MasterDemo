package Grouping;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GroupTest2 extends GroupTest1 {
	//WebDriver driver;
	//Properties config;
	//Properties or;
	//GroupTest1 test=new GroupTest1();
  @Test(priority=1,groups="Smoke" ,dependsOnMethods= {"loginButtonClick"})
  public void logoutButtonClick() throws IOException, InterruptedException {
	  /*or=new Properties();
	  FileInputStream fileor=new FileInputStream("D:\\Selenium eclipse\\TestNG_Practise\\src\\Properties\\OR.Properties");
	  or.load(fileor);*/
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(or.getProperty("Logoutclick"))).click();
	  
  }
  @Test(priority=0,groups="Sanity",dependsOnMethods= {"loginButtonClick"})
  public void verifyTitle()
  {
	  
	  String title=driver.getTitle();
	  System.out.println(title);
	  Assert.assertEquals(title,"Master Page");
	  System.out.println("verified");
  }
 

}
