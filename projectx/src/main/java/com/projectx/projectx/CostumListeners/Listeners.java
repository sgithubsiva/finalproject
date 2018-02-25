package com.projectx.projectx.CostumListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.projectx.projectx.Common.TestBase;

public class Listeners extends TestBase implements ITestListener {

	public static void main(String[] args) {
		

	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		Calendar currentcalender = Calendar.getInstance();
		SimpleDateFormat dateformet = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		String methodName = arg0.getName();
		if (arg0.isSuccess()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/projectx/projectx/";
					
			File destFile = new File((String) reportDirectory + "/Fail_ScreenShots/" + methodName + ""+ dateformet.format(currentcalender.getTime())+ ".png");
					
			try {
				FileUtils.copyFile(scrFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
					
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test is skiped: "+arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test Started running: "+arg0.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		Calendar currentcalender = Calendar.getInstance();
		SimpleDateFormat dateformet = new SimpleDateFormat("dd_mm_yy_hh_mm_ss");
		String methodName = arg0.getName();
		if (arg0.isSuccess()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/projectx/projectx/";
					
			File destFile = new File((String) reportDirectory + "/Pass_ScreenShots/" + methodName + ""+ dateformet.format(currentcalender.getTime())+ ".png");
					
			try {
				FileUtils.copyFile(scrFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			
		
	}

	}
}
