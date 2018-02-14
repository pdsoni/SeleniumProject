package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerUtils implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult Result) {
		System.out.println("The name of the testcase failed is : "+ Result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult Result) {

		 System.out.println("The name of the testcase Skipped is :"+Result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		
	}

}
