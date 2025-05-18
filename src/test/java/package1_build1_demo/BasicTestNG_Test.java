package package1_build1_demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicTestNG_Test 
{

	@Test(priority=1,enabled=true,groups= {"SmokeTesting"})
	public void signUp_Test()
	{
		//to fail the testcase
			//	Assert.assertTrue(false);
		System.out.println("signUP Testcase1");
		Reporter.log("signUP -----Testcase1");
		
	}
	
	@Test(priority=2,invocationCount=1,groups= {"FT"})
	public void login_Test()
	{
		
		//Assert.assertTrue(false);
		System.out.println("login_Test Testcase2");
		Reporter.log("login_Test ------Testcase2");
	}
	
	@Test(priority=3,groups= {"SmokeTesting","RegressionTesting"})
	public void Homepage_Test()
	{
		//Assert.assertTrue(false);
		System.out.println("Homepage_Test Testcase3");
	}
	
	@Test(priority=3,groups= {"RegressionTesting"})
	public void logOut_Test()
	{
		
		System.out.println("Homepage_Test Testcase3");
	}
}
