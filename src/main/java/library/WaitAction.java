package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitAction {
	
	public static WebDriverWait wait;
	public static Actions action;
	
	
	
	public static void initiateWait(WebDriver driver)
	{
		
		wait = new WebDriverWait(driver,10);
		
		
	}
	public static void initiateAction(WebDriver driver)
	{
		
		action = new Actions(driver);
		
	}

}
