package GenricUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public WebDriver driver;
	
	
	
	@BeforeSuite
	public void BeforeSuit_Test()
	{
		System.out.println("Conncet to dataBase");
	}
	@BeforeTest
	public void BeforeTest_Test()
	{
		System.out.println("Conncet to dataBase");
	}
	
	@Parameters("browser") //browser==chrome
	@BeforeClass
	public void BeforeClass_Test(String browser)//browser==chrome
	{
		if(browser.equalsIgnoreCase("chrome")) //chrome ==chrome
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		}
		else
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		}
		
		System.out.println("Launch the Browser and Url");
		
	}
	@BeforeMethod
	public void BeforeMethod_Test()
	{
		System.out.println("Before method is used for login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	@AfterMethod
	public void AfterMethod_Test()
	{
		System.out.println("After method is used for Logout");
	}
	@AfterClass
	public void AfterClass_Test()
	{
		System.out.println("quit the browser");
		
		driver.quit();
	}
	@AfterTest
	public void AfterTest_Test()
	{
		System.out.println("close the DataBase");
	}
	@AfterSuite
	public void AfterSuite_Test()
	{
		System.out.println("close the DataBase");
	}
}
