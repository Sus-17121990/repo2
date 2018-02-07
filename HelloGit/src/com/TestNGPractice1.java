package com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGPractice1 {
	@Parameters({"gender"})
	@Test(priority=1,groups="Regression")
	public void method1(String gender){
		System.out.println(gender);
	}
	@Test(priority=2,groups="Regression")
	public void method2(){
		System.out.println("I am in method2");
	}
	@Test(dependsOnMethods={"method2"})
	public void method3(){
		System.out.println("I am in method3");
	}
	@Test(priority=4)
	public void method4(){
		System.out.println("I am in method4");
	}
}
