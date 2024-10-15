package Parallel_Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	public void launchBrowser(String browser)
	{
		switch(browser)
		{
		case"FFX":  System.setProperty("webdriver.Firefox.driver", "D:\\Selenium jar files\\drivers\\geckodriver.exe");
		            driver=new FirefoxDriver();
		            break;
		case "CRM": System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver-win64\\chromedriver.exe"); 
		           driver=new ChromeDriver();
		           break;
		case"Edge": System.setProperty("webdriver.edge.driver", "D:\\Driver\\msedgedriver.exe"); 
                   driver=new EdgeDriver();
                   break;
        default  : System.out.println("driver not found");
                  break;
        

		}
	}
  @Test
  public void loginPage() {
	  driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
  }
  @AfterClass
  public void closeBrowser()
  {
	  System.out.println("close browser");
  }
  
}
