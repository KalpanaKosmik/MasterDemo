package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test3 {
	WebDriver driver;
  @Test
  public void verifyTitileOfPage() {
	  String title=driver.getTitle();
	  Assert.assertEquals(title, "OrangeHRM");
  }
  @Test
  public void loginPage(){
	  driver.findElement(By.name("txtUserName")).sendKeys("selenium");
	  driver.findElement(By.name("txtPassword")).sendKeys("selenium");
	  driver.findElement(By.name("Submit")).click();
	  
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
