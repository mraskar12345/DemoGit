package pageObjectModel;

import org.openqa.selenium.By;

import baseClass.DriverClass;

public class SignInPage 
{
	
	public static By lnkSignin = By.xpath("//a[@title='Log in to your customer account']");
	
	
	public static void clickSignIn()
	{
		
		DriverClass.driver.findElement(lnkSignin).click();
	}
	
	
	

}
