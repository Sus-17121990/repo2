package com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg {
	@Parameters({"name"})
	@Test
	public void Test1(String name){
		System.out.println(name);
	}

}
