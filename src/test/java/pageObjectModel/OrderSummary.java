package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.DriverClass;
import library.WaitAction;

public class OrderSummary {
	
	
	WebDriver driver;

	
	public OrderSummary(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']")
	public WebElement btnProceedToCheckout;
	
	
	
	public void clickCheckOut()
	{
		WaitAction.initiateWait(driver);
		//click proceed to checkout on summary page
		WaitAction.wait.until(ExpectedConditions.visibilityOf(btnProceedToCheckout));
		btnProceedToCheckout.click();
				
	}
	
	
	
	
	
	
	
	

}
