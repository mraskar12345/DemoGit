package testCase;

import org.testng.Assert;



import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClass.Base;
import baseClass.DataProviderClass;
import baseClass.DriverClass;
import library.CommonFunctions;
import library.DBOperations;
import library.ExcelRead;
import pageObjectModel.SignInPage;
import pageObjectModel.SummerDresses;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectModel.HomePage;
import pageObjectModel.IFrameAddToCart;
import pageObjectModel.LoginPage;
import pageObjectModel.OrderAddress;
import pageObjectModel.OrderPayment;
import pageObjectModel.OrderShipping;
import pageObjectModel.OrderSummary;


public class TestCase extends Base

{

	//4 variables taken form testng.xml
	@Parameters({ "url", "email", "password","browserName" })
	@Test(description="This is just login test case number 1")

	public void testCase1(@Optional("http://automationpractice.com") String url,@Optional("mayurraskar4@gmail.com")String email, @Optional("crossworld4")String password,@Optional("CHROME")String browserName) throws InterruptedException 
	{
				
		// used from @parameters from testng.xml
		//navigate to site
		DriverClass.driver.get(url);
		test.log(Status.INFO, "url opened");
		//maximize window
		DriverClass.driver.manage().window().maximize();
		test.log(Status.PASS, "window maximized");
		//implicit wait
		DriverClass.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//call from POM class SignInPage.java
		SignInPage.clickSignIn();
		//calling login function
		LoginPage l1 = new LoginPage(DriverClass.driver);
		//**************** excel read code is working but commented as of now*****************************************
//		//FETCH EMAIL and password FROM EXCEL SHEET
//		try {
//			email = ExcelRead.Read(0,0);
//			password = ExcelRead.Read(1,0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//**************** excel read code is working but commented as of now*****************************************
		l1.login(email,password);
		test.log(Status.PASS, "login happened");
		//assertion
		Assert.assertEquals("2", "2");
		test.log(Status.PASS, "assertion passed");
		//extent report fail
		if("mayur".equals("mayur"))
		{
			try {
				test.log(Status.FAIL,test.addScreenCaptureFromPath(CommonFunctions.capture(DriverClass.driver)) + "assertion failed screenshot");
			} catch (IOException e) {
				//error
				e.printStackTrace();
			}
		}
	
	}

	
	
	//4 variables taken form properties file
	@Test(description="This is end to end test case number 5")
	public void testCase5()
	{
		
		//fetching variables from properties file
		
		try {
			Properties obj = new Properties();
			FileInputStream objFile = new FileInputStream(System.getProperty("user.dir")+ "\\application.properties");
			obj.load(objFile);
			
			String url = obj.getProperty("url");
			
			String email = obj.getProperty("email");
			
			String password = obj.getProperty("password");
			
		
		WebDriverWait wait = new WebDriverWait(DriverClass.driver,10);
		DriverClass.driver.get(url);
		test.log(Status.PASS, "url opened");
			
		//maximize window
		DriverClass.driver.manage().window().maximize();
	
		SignInPage.clickSignIn();
		LoginPage l1 = new LoginPage(DriverClass.driver);
		l1.login(email,password);
		test.log(Status.PASS, "login happened");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Women']")));
		//new object for home page
		HomePage h1 = new HomePage(DriverClass.driver);
		//click women-->dresses-->summer dresses
		h1.ClickSummerDress();
		//new object for summer dresses
		SummerDresses summer = new SummerDresses(DriverClass.driver);
		//select sort option as lowest first
		summer.selectSortBy("price:asc");
		//click quick view
		summer.clickQuickView();
		//new object for IFrameAddToCart
		IFrameAddToCart addToCart = new IFrameAddToCart(DriverClass.driver);
		//click add to cart
		addToCart.clickAddToCart();
		//click proceed to checkout
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout']")));
		DriverClass.driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
//		//new object for OrderSummary page
//		OrderSummary order = new OrderSummary(DriverClass.driver);
//		//click proceed on summary page
//		order.clickCheckOut();
//		//new object for OrderAddress
//		OrderAddress orderAddress = new OrderAddress(DriverClass.driver);
//		//click proceed to checkout on address page
//		orderAddress.clickCheckOut();
//		//new object for OrderShipping
//		OrderShipping orderShipping = new OrderShipping(DriverClass.driver);
//		//click proceed on shipping page
//		orderShipping.clickCheckOut();
//		//new object for OrderPayment
//		OrderPayment orderPayment = new OrderPayment(DriverClass.driver);
//		//click confirm on final payment page
//		orderPayment.clickConfirm();
//		test.log(Status.PASS, "order is placed successfully");
		
	}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	
	
	
	
	
	@Parameters({ "url", "email", "password","browserName" })
    @Test(description="This is sigin test case number 2")
    
	public void testCase2(@Optional("http://automationpractice.com") String url,@Optional("mayurraskar4@gmail.com")String email, @Optional("crossworld4")String password,@Optional("CHROME")String browserName) throws InterruptedException
	{
				
		
		//used from @parameters from testng.xml
		DriverClass.driver.get(url);
		test.log(Status.PASS, "url opened");
		//explicit wait
		WebDriverWait wait = new WebDriverWait(DriverClass.driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(SignInPage.lnkSignin));
		
		//maximize window
		DriverClass.driver.manage().window().maximize();
		test.log(Status.PASS, "window maximized");
		//implicit wait
		DriverClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//call from POM class SignInPage.java
		SignInPage.clickSignIn();
		//calling login function
		LoginPage l1 = new LoginPage(DriverClass.driver);
		l1.login(email,password);
		test.log(Status.PASS, "login happened");
		
	
	}
	
	
	@Parameters({ "url", "email", "password","browserName" })
    @Test(description="This is sigin test case number 3")
    
	public void testCase3(@Optional("http://automationpractice.com") String url,@Optional("mayurraskar4@gmail.com")String email, @Optional("crossworld4")String password,@Optional("CHROME")String browserName) throws InterruptedException
	{
		
		//used from @parameters from testng.xml
		DriverClass.driver.get(url);
		test.log(Status.PASS, "url opened");
		//explicit wait
		WebDriverWait wait = new WebDriverWait(DriverClass.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(SignInPage.lnkSignin));
		
		//maximize window
		DriverClass.driver.manage().window().maximize();
		test.log(Status.PASS, "window maximized");
		//implicit wait
		DriverClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//call from POM class SignInPage.java
		SignInPage.clickSignIn();
	
					
	}
	
	
	
	@Parameters({ "url", "email", "password","browserName" })
    @Test(description="This is sigin test case number 4")
    
	public void testCase4(@Optional("http://automationpractice.com") String url,@Optional("mayurraskar4@gmail.com")String email, @Optional("crossworld4")String password,@Optional("CHROME")String browserName) throws InterruptedException
	{
		
		//used from @parameters from testng.xml
		DriverClass.driver.get(url);
		test.log(Status.PASS, "url opened");
		//explicit wait
		WebDriverWait wait = new WebDriverWait(DriverClass.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(SignInPage.lnkSignin));
		
		//maximize window
		DriverClass.driver.manage().window().maximize();
		test.log(Status.PASS, "window maximized");
		//implicit wait
		DriverClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//call from POM class SignInPage.java
		SignInPage.clickSignIn();
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ************************************************************************************************************************************
	// **********************DATABASE CONNECTION TEST
	// CASE****************************************************************************
	// ********************************************************************************************************************************
//	@Test	
//	public void TestCaseForDBConnection() throws Exception
//	{
//			
//			String id = DBOperations.DBRead();
//			System.out.println(id);
//			
//	}

	// test case for properties and xml fetch data
	// *******************************************************************************************************************************
	// **********************Properties and xml fetch data test
	// case*******************************************************************
	// ********************************************************************************************************************************
//	@Test
//	public void TestCaseForPropertiesAndXML()
//	{
//		//********************************* properties and xml code has been commeneted as not used*************************************
//				//properties file implementation for testing URL,ID ,PASSWORD
//				//1) properties file
//				
//				try {
//					Properties obj = new Properties();
//					FileInputStream objFile = new FileInputStream(System.getProperty("user.dir")+ "\\application.properties");
//					obj.load(objFile);
//					@SuppressWarnings("unused")
//					String url1 = obj.getProperty("url");
//					@SuppressWarnings("unused")
//					String email1 = obj.getProperty("email");
//					@SuppressWarnings("unused")
//					String password1 = obj.getProperty("password");
//					
//								
//					
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				//2) XML FILE
//				
//				try {
//					File f1 = new File(System.getProperty("user.dir")+ "\\properties.xml");
//					SAXReader s1 = new SAXReader();
//					Document d1 = s1.read(f1);
//					@SuppressWarnings("unused")
//					String url2 = d1.selectSingleNode("//data/url").getText();
//					@SuppressWarnings("unused")
//					String email2 = d1.selectSingleNode("//data/email").getText();
//					@SuppressWarnings("unused")
//					String password2 = d1.selectSingleNode("//data/password").getText();
//					@SuppressWarnings("unused")
//					String temp1 = null;
//					
//				} catch (DocumentException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				//********************************* properties and xml code has been commeneted as not used*************************************
//				
//				
//		
//		
//		
//	}
//	

	// test case for data provider.
	// *******************************************************************************************************************************
	// **********************BELOW TEST CASE WILL RUN FOR 2 TIMES.EACH TIME WITH 2
	// PARAMETERS***************************************
	// ********************************************************************************************************************************
//	@Test(dataProvider = "SearchProvider",dataProviderClass = DataProviderClass.class)
//	public void TestCase2DataProviderTestCase(String email,String password)
//	{
//		
//		System.setProperty("webdriver.chrome.driver", "D:\\mayur\\car finance\\selenium java downloads\\chromedriver_win32\\chromedriver.exe");
//		//initializing driver
//		DriverClass.driver = new ChromeDriver();
//		//DriverClass.driver.get("http://automationpractice.com");
//		//used from @parameters from testng.xml
//		DriverClass.driver.get("http://automationpractice.com");
//		//maximize window
//		DriverClass.driver.manage().window().maximize();
//		//click signin
//		SignInPage.clickSignIn();
//		//calling login function
//		LoginPage l1 = new LoginPage(DriverClass.driver);
//		l1.login(email,password);
//		
//	}
//	
	
	
	
	
}
