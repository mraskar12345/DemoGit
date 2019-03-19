package baseClass;

import java.lang.reflect.InvocationTargetException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import baseClass.DriverClass;


public class Base 

{
	
	protected ExtentReports extent;
	protected ExtentTest test;
	
	//need to do only once before all test cases.so here written.
	@BeforeSuite
	public void BeforeSuite()
	{
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./ExtentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Application URL", "http://automationpractice.com");
	}

	
	@Parameters({ "url", "email", "password","browserName" })
	@BeforeMethod
	public void BeforeMethod(ITestResult result,@Optional("http://automationpractice.com") String url,@Optional("mayurraskar4@gmail.com")String email, @Optional("crossworld4")String password,@Optional("CHROME")String browserName)
	{
		
		//log start in console
		Reporter.log("===== Browser session started=======",true);
		//below line commented and browserSelect function is called
		//DriverClass.driver = new ChromeDriver();
		//call browser select to initiate driver as per selected browser.TAKES CARE OF BOTH DRIVER AND BROWSER
		browserSelect(browserName);
		//printing test case name  in extent report
		test = extent.createTest(result.getMethod().getMethodName());
		
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result)
	{
		
		extent.flush();
		//close all browsers
		DriverClass.driver.quit();
		Reporter.log("===== Browser session Closed=======",true);
		//using ItestResult to log final status of test case
		if(result.getStatus() == ITestResult.SUCCESS)
			test.log(Status.PASS, "complete method is passed");
		else if(result.getStatus() == ITestResult.FAILURE)
			test.log(Status.PASS, "complete method is failed");
		else if(result.getStatus() == ITestResult.SKIP)
			test.log(Status.PASS, "complete method is skipped");
			
			
	}
	

	public void browserSelect(String browserName)
	{
	
		switch(browserName.toUpperCase())
		{
		case "CHROME" : 
			System.setProperty("webdriver.chrome.driver","D:\\mayur\\car finance\\selenium java downloads\\chromedriver_win32\\chromedriver.exe");
			DriverClass.driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver","D:\\mayur\\car finance\\Java Workspace\\jars and drivers\\geckodriver.exe");
			DriverClass.driver = new FirefoxDriver();
			break;
		case "INTERNET EXPLORER":
			System.setProperty("webdriver.ie.driver","D:\\mayur\\car finance\\Java Workspace\\jars and drivers\\IEDriverServer.exe");
			DriverClass.driver = new InternetExplorerDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver","D:\\mayur\\car finance\\selenium java downloads\\chromedriver_win32\\chromedriver.exe");
			DriverClass.driver = new ChromeDriver();
			break;
		}
	}
	
	//***************************************as of now not used*************************************************
	public enum browser
	{
		CHROME,
		IE,
		FIREFOX
		
	}
	
	
	
	
}
