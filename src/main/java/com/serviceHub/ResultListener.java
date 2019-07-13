package com.serviceHub;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ResultListener extends TestListenerAdapter{

	public static int passCont,failCount,skippedCount;
	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started....");
	}

	@Override
	public void onTestSuccess(ITestResult tr) 
	{
		passCont=passCont+1;
		
		log("Test '" + tr.getName() + "' PASSED");
		log(tr.getTestClass());
		log("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}

	@Override
	public void onTestFailure(ITestResult tr) 
	{
		failCount = failCount+1;

		log("Test '" + tr.getName() + "' FAILED");
		log("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".....");
	}

	@Override
	public void onTestSkipped(ITestResult tr) 
	{
		skippedCount = skippedCount+1;
		log("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}

	
	
	private void log(String methodName) {
		System.out.println(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
	}
	public int  getPassCount() {
		
		return passCont;
	}
	public int  getFailCount() {
		
		return failCount;
	}
	public int  getSkippedCount() {
	
		return skippedCount;
}
}
