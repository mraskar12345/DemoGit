package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Log4j 
{

	public static void main(String[] args) 
	{
		
		BasicConfigurator.configure();
		
		System.setProperty("webdriver.gecko.driver", "D:\\mayur\\car finance\\Java Workspace\\jars and drivers\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 //SYSTEM LEVEL LOGS
         Logger log = Logger.getLogger("devpinoyLogger");

         
        //properties file path
         String log4jConfPath = "D:\\mayur\\car finance\\Java Workspace\\TestGuiFramework\\Log4j.properties";
         PropertyConfigurator.configure(log4jConfPath);
         
                
         
         driver.get("http://healthunify.com/bmicalculator/");
         //MANUAL LOGS
		 log.debug("opening webiste");
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 log.debug("entring weight");
		 driver.findElement(By.name("wg")).sendKeys("87");
         log.debug("selecting kilograms");
         driver.findElement(By.name("opt1")).sendKeys("kilograms");
         log.debug("selecting height in feet");
         driver.findElement(By.name("opt2")).sendKeys("5");
         log.debug("selecting height in inchs");
         driver.findElement(By.name("opt3")).sendKeys("10");
         log.debug("Clicking on calculate");
         driver.findElement(By.name("cc")).click();

		 log.debug("Getting SIUnit value");
         String SIUnit = driver.findElement(By.name("si")).getAttribute("value");
         log.debug("Getting USUnit value");
         String USUnit = driver.findElement(By.name("us")).getAttribute("value");
         log.debug("Getting UKUnit value");
         String UKUnit = driver.findElement(By.name("uk")).getAttribute("value");
         log.debug("Getting overall description");
         String note = driver.findElement(By.name("desc")).getAttribute("value");
      
         System.out.println("SIUnit = " + SIUnit);
         System.out.println("USUnit = " + USUnit);
         System.out.println("UKUnit = " + UKUnit);
         System.out.println("note = " + note); 
		 driver.quit();
		
		
		
	}
		
		
		
		
		
	}


