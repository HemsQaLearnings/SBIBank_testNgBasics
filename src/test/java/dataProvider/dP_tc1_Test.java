package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dP_tc1_Test
{

	@DataProvider(name="Gowri")
	public Object[][] dataProvider_test()
	{
		Object[][]arr= {
				{"Manual","60"},
				{"Core java","95"},
				{"Selenium","85"}
				
		};
		return arr;
	}
	
	@Test(dataProvider="Gowri")
	public void dt_Test1(String sub, String score)
	{
		System.out.println(sub+"---->"+score);
	}
	//-------------------------------------------------------------------------
	
	@Test(dataProviderClass=Dp2_test.class,   dataProvider="vishnu")
	public void dt_Test2(String sub, String score)
	{
		System.out.println(sub+"---->"+score);
	}
}
