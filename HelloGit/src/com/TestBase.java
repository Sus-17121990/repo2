package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	public static String webBrowser;
	@Parameters({"browser"})
	public TestBase(String browser){
		this.webBrowser=browser;
		System.out.println("browser name :" +webBrowser);
	}
	public TestBase(){
		
	}
	public static WebDriver getDriver(){
		
		System.out.println(webBrowser);
		  
		if(webBrowser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "G:\\workspace\\project\\HelloGit\\src\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		if(webBrowser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
		}
		
		if(webBrowser.equals("firefox")){
			System.setProperty("webdriver.firefox.driver", "");
			driver=new FirefoxDriver();
		}
		
		return driver;
	}
	
	public static WebDriver getExistingDriver(){
		return driver;
		
	}

}
