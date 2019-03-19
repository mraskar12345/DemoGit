package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.Base;
import baseClass.DriverClass;
import library.WaitAction;
import testCase.TestCase;

public class SummerDresses 

{
	//below 3 lines are moved to base.java
	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(DriverClass.driver,10);
	//Actions action = new Actions(DriverClass.driver);
	
	
	public SummerDresses(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css = "a[title='Printed Chiffon Dress']")
	public WebElement elePrintedChiffonDress;
	
	@FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/2/0/20-home_default.jpg']")
	public WebElement imgPrintedChiffonDress;
	
	
	@FindBy(id = "selectProductSort")
	public WebElement dropDownSortBy;
	
	@FindBy(css = "input[name='layered_id_attribute_group_16']")
	public WebElement chkBoxColorYellow;
	
	@FindBy(xpath = "//span[text()='Quick view']")
	public WebElement lnkQuickView;
	
	
	
	public void selectSortBy(String value)
	{
		
		WaitAction.initiateWait(driver);
		WaitAction.initiateAction(driver);
		
		//select sort by price:lowest first
		WaitAction.wait.until(ExpectedConditions.visibilityOf(elePrintedChiffonDress));
		
		Select s1 = new Select(dropDownSortBy);
		s1.selectByValue(value);
			
		
		//wait until title is available
		WaitAction.wait.until(ExpectedConditions.visibilityOf(elePrintedChiffonDress));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//click on quick view
	public void clickQuickView()
	{
			WaitAction.initiateWait(driver);
			WaitAction.initiateAction(driver);
			//scroll to yellow colour box
			JavascriptExecutor js = (JavascriptExecutor)DriverClass.driver;
			js.executeScript("arguments[0].scrollIntoView();", chkBoxColorYellow);
			WaitAction.wait.until(ExpectedConditions.visibilityOf(imgPrintedChiffonDress));
			//3 second wait
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		
			//hover to element - printed chiffon dress
			WaitAction.action.moveToElement(imgPrintedChiffonDress).perform();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				//click quick view
				lnkQuickView.click();
				
		
	}
	

}
