package pageObjectModel;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.Base;
import baseClass.DriverClass;
import library.WaitAction;
import testCase.TestCase;

public class HomePage 

{
	//below 3 lines are moved to base.java
	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(DriverClass.driver,10);
	//Actions action = new Actions(DriverClass.driver);
	
	

	public HomePage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css = "a[title='Women']")
	public WebElement lnkWomen;
	
	@FindBy(css = "a[title='Summer Dresses']")
	public WebElement lnkSummerDresses;
	
	
	
	public void ClickSummerDress()
	{
		
				WaitAction.initiateWait(driver);
				WaitAction.initiateAction(driver);
				//click women-->dresses-->summer dresses
				WaitAction.action.moveToElement(lnkWomen).perform();
				WaitAction.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Summer Dresses']")));
				
				lnkSummerDresses.click();
				//check small size
				//DriverClass.driver.findElement(By.xpath("//input[@name='layered_id_attribute_group_1' AND @id='layered_id_attribute_group_1']")).click();
				//DriverClass.driver.findElement(By.cssSelector("input[name='layered_id_attribute_group_1']")).click();
				//check yellow colour
				//DriverClass.driver.findElement(By.cssSelector("input[name='layered_id_attribute_group_16']")).click();
		
		
	}
	
	
	
	
	
	
	
	

}