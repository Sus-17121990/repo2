package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGPractice {
	WebDriver driver;
	@Parameters({"firstName","lastName"})
	@Test(groups="Regression")
	public void method1(String firstName,String lastName){
		System.out.println(firstName+" "+lastName);
	}
	@Test
	public void method2(){
		System.out.println("This is second method");
	}
	@Test(groups="Regression")
	public void method3(){
		
		driver=TestBase.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.id("abcd")).click();
		System.out.println("This is third method");
	}

}









