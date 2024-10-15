package Parallel_Testing;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
@Parameters({"browser"})
@Test
public void test(String browser)
{
	System.out.println("Browser name is:"+browser);
}


}
