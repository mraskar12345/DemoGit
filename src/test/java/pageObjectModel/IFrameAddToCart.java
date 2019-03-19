package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.DriverClass;

public class IFrameAddToCart {
	
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(DriverClass.driver,10);
	
	public IFrameAddToCart(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "a[class='btn btn-default button-plus product_quantity_up']")
	public WebElement btnIncreaseItem;
	
	@FindBy(name = "Submit")
	public WebElement btnAddToCart;
	
	
	
	
	
	public void clickAddToCart()
	{
		
		//switch to frame
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		//click + to increase items
		wait.until(ExpectedConditions.visibilityOf(btnIncreaseItem));
		btnIncreaseItem.click();
		//click add to cart	
		wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
		btnAddToCart.click();
		
		//switch back to default frame
		DriverClass.driver.switchTo().defaultContent();
	}
	
	
	
	
	

}
