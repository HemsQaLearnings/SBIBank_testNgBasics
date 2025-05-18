package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPomPage 
{
	//constructor
		public LoginPomPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
//	     @findALL({ @findBy(@id=’username’) , @findBy(name=’user’)}) //or condition


		@FindAll(
					{
					@FindBy(xpath="//input[@placeholder='Username']"), 
					@FindBy(xpath="//input[@name='username']")
					}
				)
		private WebElement usn_edit;
		
		// getmethod
		public WebElement getUsn_edit() {
			return usn_edit;
		}
		//setMethod
		public void setUsn_edit(WebElement usn_edit) {
			this.usn_edit = usn_edit;
		}


		//---------------------------------------------------------------
		@FindBy(xpath="//input[@placeholder='Password']")
		private WebElement pass_edit;

		public WebElement getPass_edit() {
			return pass_edit;
		}
		public void setPass_edit(WebElement pass_edit) {
			this.pass_edit = pass_edit;
		}
		
		//---------------------------------------------------------------
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement login_btn;
		

		public WebElement getLogin_btn() {
			return login_btn;
		}

		public void setLogin_btn(WebElement login_btn) {
			this.login_btn = login_btn;
		}
	//......................................................................	
		
		//business logic implementation in pom page only
		
		public void logintoApp(String usn, String psw)
		{
			usn_edit.sendKeys(usn);
			
			pass_edit.sendKeys(psw);
		}
		
	
	
}
