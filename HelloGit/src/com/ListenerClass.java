package com;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter {
	WebDriver driver;
	private static String fileSeperator = System.getProperty("file.separator");
	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started....");
		//System.out.println(fileSeperator);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");
		
		log("Test "+tr.getTestName());
		log("Test "+tr.getMethod());
		log("Test "+tr.getTestClass());

		// This will print the class name in which the method is present
		log(tr.getTestClass());

		// This will print the priority of the method.
		// If the priority is not defined it will print the default priority as
		// 'o'
		log("Priority of this method is " + tr.getMethod().getPriority());

		System.out.println(".....");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("***** Error " + result.getName() + " test has failed *****");
        driver=TestBase.getExistingDriver();
        System.out.println("...............................");
        System.out.println(result.getInstanceName());
		String testClassName = getTestClassName(result.getInstanceName()).trim();

		String testMethodName = result.getName().toString().trim();
		String screenShotName = testMethodName + ".png";

		if (driver != null) {
			String imagePath = ".." + fileSeperator + "Screenshots"
					+ fileSeperator + "Results" + fileSeperator + testClassName
					+ fileSeperator+"Failed"+fileSeperator
					+ takeScreenShot(driver, screenShotName, testClassName);
			System.out.println("Screenshot can be found : " + imagePath);
		}
	}
	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	}
	private void log(String methodName) {
		System.out.println(methodName);
	}
	private void log(IClass testClass) {
		System.out.println(testClass);
	}
	public static String takeScreenShot(WebDriver driver,
			String screenShotName, String testName) {
		try {
			File file = new File("Screenshots" + fileSeperator + "Results");
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File("Screenshots" + fileSeperator + "Results" + fileSeperator+"Failed"+fileSeperator+ testName, screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);

			return screenShotName;
		} catch (Exception e) {
			System.out.println("An exception occured while taking screenshot " + e.getCause());
			return null;
		}
	}
	
	public String getTestClassName(String testName) {
		String[] reqTestClassname = testName.split("\\.");
		int i = reqTestClassname.length - 1;
		System.out.println("Required Test Name : " + reqTestClassname[i]);
		return reqTestClassname[i];
	}

}