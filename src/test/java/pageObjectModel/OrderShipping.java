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

public class OrderShipping {
	
	
	WebDriver driver;
	
	
	public OrderShipping(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "processCarrier")
	public WebElement btnProceedToCheckout;
	
	@FindBy(name = "cgv")
	public WebElement chkBoxTermsOfService;
	
	
		
			public void clickCheckOut()
			{
				WaitAction.initiateWait(driver);
				//click button proceed on shipping page
				WaitAction.wait.until(ExpectedConditions.visibilityOf(btnProceedToCheckout));
				chkBoxTermsOfService.click();
				btnProceedToCheckout.click();
						
			}
			

}
