package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test2 {
	WebDriver driver;
  @Test
  public void verifyTitlePage() {
	  String title=driver.getTitle();
	  Assert.assertEquals(title, "rangeHRM - New Level of HR Management");
	  
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
