package GenricUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import pomPages.LoginPomPage;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPomPage lp;
	
	
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
	public void BeforeMethod_Test() throws InterruptedException
	{
		
		lp=new LoginPomPage(driver);
		lp.logintoApp("Admin", "admin123");
	
		driver.navigate().refresh();
		lp.logintoApp("Admin", "admin123");
		
		lp.getLogin_btn().click();
		Thread.sleep(8000);
		
		/*
		 * System.out.println("Before method is used for login"); WebElement usn =
		 * driver.findElement(By.xpath("//input[@placeholder='Username']"));
		 * usn.sendKeys("Admin"); Thread.sleep(2000);
		 * 
		 * WebElement psw =
		 * driver.findElement(By.xpath("//input[@placeholder='Password']"));
		 * psw.sendKeys("admin123"); Thread.sleep(2000); driver.navigate().refresh();
		 * //exception usn.sendKeys("Admin"); psw.sendKeys("admin123");
		 * Thread.sleep(6000);
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 */
	}
	
	
	@AfterMethod
	public void AfterMethod_Test()
	{
		System.out.println("After method is used for Logout");
	}
	@AfterClass
	public void AfterClass_Test() throws InterruptedException
	{
		System.out.println("quit the browser");
		Thread.sleep(5000);
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
