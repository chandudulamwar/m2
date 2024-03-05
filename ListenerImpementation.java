package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpementation implements ITestListener{
	
	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		//System.out.println("testScript execution is stsarted");
		
		//use ExtentSparkReporter class just to cinfigure extent report
		
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"testScript execution is started",true);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		String methodName = result.getMethod().getMethodName();
		//Reporter.log("testScript execution is passed",true);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);

		//add only for testscript fail to add getthowable
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"testScript execution is failure",true);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		
		javautil jutil = new javautil();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("organizarion");
		
		//use ExtentReports to generate extentreport
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chromeversion", "121");
		report.setSystemInfo("Author", "Chandrakant");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		
		report.flush();
	}

	public static void main(String[] args) {
		
	}

}
