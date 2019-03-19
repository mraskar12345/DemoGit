package testCase;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener

{

	public void onTestStart(ITestResult result)
	{
		System.out.println("Listener Test case started");
		
	}

	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Listener Test case passed");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Listener Test case failed");
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		
		System.out.println("Listener Test case skipped");
	}

	
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}
