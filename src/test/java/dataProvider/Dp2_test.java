package dataProvider;

import org.testng.annotations.DataProvider;

public class Dp2_test {

	@DataProvider(name="vishnu")
	public Object[][] dataProvider_test2()
	{
		Object[][]arr= {
				{"Manual","80"},
				{"Core java","75"},
				{"Selenium","90"}
				
		};
		return arr;
	}
}
