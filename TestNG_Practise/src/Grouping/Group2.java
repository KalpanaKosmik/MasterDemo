package Grouping;

import org.testng.annotations.Test;

public class Group2 extends Group1 {
  @Test(groups="Sanity",dependsOnMethods={"loginPage"})
  public void checkDrafts() {
	  System.out.println("Draft mails ");
  }
  @Test(groups="Sanity")
  public void checkSpam()
  {
	  System.out.println("no spam mails ");
  }
  @Test(groups="Smoke")
  public void inValidId()
  {
	  System.out.println("incorrect username or password ");
  }
}
