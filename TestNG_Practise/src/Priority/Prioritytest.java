package Priority;

import org.testng.annotations.Test;

public class Prioritytest {
  @Test(priority =1)
  public void login() {
	  System.out.println("Login account");
  }
  @Test(priority=5)
  public void logout()
  {
	  System.out.println("logout successfuuly");
  }
  @Test(priority=2)
  public void verifyTitle()
  {
	  System.out.println("verified title of page");
	  
  }
  @Test(priority=3)
  public void verifyWelcomePage()
  {
	  System.out.println("Welcome text verified");
  }
  @Test(priority=4)
  public void checkAccountDetails()
  {
	  System.out.println("Account details checked"); 
  }
}
