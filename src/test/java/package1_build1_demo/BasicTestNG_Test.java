package package1_build1_demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicTestNG_Test 
{

	@Test(priority=1,enabled=true)
	public void signUp_Test()
	{
		//to fail the testcase
			//	Assert.assertTrue(false);
		System.out.println("signUP Testcase1");
		Reporter.log("signUP -----Testcase1");
		
	}
	
	@Test(priority=2,invocationCount=1,dependsOnMethods= {"signUp_Test"})
	public void login_Test()
	{
		
		//Assert.assertTrue(false);
		System.out.println("login_Test Testcase2");
		Reporter.log("login_Test ------Testcase2");
	}
	
	@Test(priority=3,dependsOnMethods= {"signUp_Test","login_Test"})
	public void Homepage_Test()
	{
		Assert.assertTrue(false);
		System.out.println("Homepage_Test Testcase3");
	}
	
	@Test(priority=3,dependsOnMethods= {"Homepage_Test"})
	public void logOut_Test()
	{
		
		System.out.println("Homepage_Test Testcase3");
	}
}
