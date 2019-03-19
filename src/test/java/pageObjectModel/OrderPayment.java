package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import baseClass.DriverClass;
import library.WaitAction;

public class OrderPayment {
	
	
	
	
	WebDriver driver;
		
	public OrderPayment(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "a[title='Pay by bank wire']")
	public WebElement lnkPayByBankWire;
	
	@FindBy(css = "button[class='button btn btn-default button-medium']")
	public WebElement btnConfirmOrder;
	
	@FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
	public WebElement eleOrderIsComplete;
	
	
	

	public void clickConfirm()
	{
		
		WaitAction.initiateWait(driver);
		//click pay by bank wire
		WaitAction.wait.until(ExpectedConditions.visibilityOf(lnkPayByBankWire));
		lnkPayByBankWire.click();
		//click i confirm my order
		WaitAction.wait.until(ExpectedConditions.visibilityOf(btnConfirmOrder));
		btnConfirmOrder.click();
		//assertion to check order is complete
		WaitAction.wait.until(ExpectedConditions.visibilityOf(eleOrderIsComplete));
		String text = eleOrderIsComplete.getText();
		Assert.assertEquals(text, "Your order on My Store is complete.");
		
	}
	
	
	
	

}
