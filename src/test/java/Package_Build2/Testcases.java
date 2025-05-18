package Package_Build2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenricUtilities.BaseClass;

public class Testcases extends BaseClass
{

	@Test
	public void First_Test() throws InterruptedException
	{
		System.out.println("if valid credentials home will be displayed");
		//verify
		String text = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
		
		if(text.equalsIgnoreCase("Dashboard"))
		{
			System.out.println("Dashboard is displayed, Your at the home page");
		}
		
		//Thread.sleep(8000);
	}
}
