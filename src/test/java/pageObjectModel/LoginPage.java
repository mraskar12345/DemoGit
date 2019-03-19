package pageObjectModel;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.Base;
import baseClass.DriverClass;
import library.CommonFunctions;
import testCase.TestCase;


public class LoginPage extends TestCase
{

	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		
		this.driver = driver;
		//PageFactory.initElements(DriverClass.driver, this);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "email") // it is equivalent to "driver.findElement(By.id("email"))"
	public WebElement txtEmail;
	
	@FindBy(name = "passwd")
	WebElement txtPassword;
	
	@FindBy(css = "button[id='SubmitLogin']")
	WebElement btnSignIn;
	
	
	//set email
	public void setEmail() 
	{
		txtEmail.sendKeys("mayurraskar4@gmail.com");
	
	}
	
	//set password
	public void setPassword()
	{
		txtPassword.sendKeys("crossworld4");
		
	}
	
	//click sign in button
	public void clickSignIn()
	{
		btnSignIn.click();
	}
	
	
	//login function
	
	public void login(String uname, String password)
	{
		//set email
		//below line is commented and called from common function
		//txtEmail.sendKeys(uname);
		CommonFunctions.setText(txtEmail, uname);
		//set password
		CommonFunctions.setText(txtPassword, password);
		//click login
		btnSignIn.click();
	
	}

	
	
}
