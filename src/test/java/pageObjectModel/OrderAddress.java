package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.DriverClass;
import library.WaitAction;

public class OrderAddress {
	
	
	
	WebDriver driver;
	
	
	public OrderAddress(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "processAddress")
	public WebElement btnProceedToCheckout;
	
	public void clickCheckOut()
	{
		
		WaitAction.initiateWait(driver);
		
		//click proceed to checkout on summary page
		WaitAction.wait.until(ExpectedConditions.visibilityOf(btnProceedToCheckout));
		btnProceedToCheckout.click();
				
	}
	
	

}
