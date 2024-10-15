package Grouping;

import org.testng.annotations.Test;

public class Group1 {
  @Test(priority=1,groups="Smoke")
  public void loginPage() {
	  System.out.println("Login Successfully");
  }
  @Test(priority=4,groups="Smoke")
  public void logOut()
  {
	  System.out.println("loggedout successfully");
  }
  @Test(priority=2,groups="Sanity")
  public void checkMailInbox()
  {
	  System.out.println("checked messages");
  }
  @Test(priority=3,groups="Sanity")
  public void composeMail()
  {
	  System.out.println("compose new mail");
  }
}
