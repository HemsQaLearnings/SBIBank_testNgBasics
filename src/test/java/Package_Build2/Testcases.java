package Package_Build2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenricUtilities.BaseClass;

public class Testcases extends BaseClass
{

	@Test
	public void First_Test() throws InterruptedException
	{
		SoftAssert sf=new SoftAssert();
		System.out.println("if valid credentials home will be displayed");
		//verify
		String text = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		
		//hardAssertion
		//Assert.assertEquals(text, "Dummi");
		
		//softassert
		sf.assertEquals(text, "Dashboard");
		System.out.println("---------------> assertion got pass");
		//Thread.sleep(8000);
		
		sf.assertAll();
	}
}
