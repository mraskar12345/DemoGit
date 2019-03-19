package library;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.DriverClass;

public class CommonFunctions 

{
	
	//to set value in webedit
	public static void setText(WebElement element,String value)
	{
		
		element.sendKeys(value);
		
		
		
	}
	
	//to click button	
	public static void btnClick(WebElement element)
	{
		
		element.click();
		
		
	}
	
	//take screenshot
	public static String capture(WebDriver driver) throws IOException
	{
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()+ ".png");
		
			
		String errflpath = Dest.getAbsolutePath();
		
		FileUtils.copyFile(scrFile, Dest);
		
		return errflpath;

	
	}
	
	
	
	
	
	
	
	
	
	
	
	//to click using href
//	public void clickLinkByHref(String href) 
//	{
//        List<WebElement> anchors = driver.findElements(By.tagName("a");
//        Iterator<WebElement> i = anchors.iterator();
//
//        while(i.hasNext()) {
//            WebElement anchor = i.next();
//            if(anchor.getAttribute("href").contains(href)) {
//                anchor.click();
//                break;
//            }
//        }
//    }
	
	//to click if 2 same links are there
//	public void clickLinkByHref(String href, int position) {
//        List<WebElement> anchors = driver.findElements(By.tagName("a");
//        Iterator<WebElement> i = anchors.iterator();
//
//        int j = 0;
//        while(i.hasNext()) {
//            WebElement anchor = i.next();
//
//            if(anchor.getAttribute("href").contains(href)) {
//                j++;
//            }
//
//            if(anchor.getAttribute("href").contains(href)
//                    && j == position) {
//                anchor.click();
//                break;
//            }
//        }
//    }
	
	
	
	

}
