package com.ust.Testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sampletest {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Im before test");
	}
	@Test(priority = 0)
	public void Testcase1() {
		System.out.println("testcase 1");
	}
	@Test(dependsOnMethods = "Testcase1")
	public void Testcase2() {
		System.out.println("testcase 2");
	}
	@Test
	public void Testcase3() {
		System.out.println("testcase 3");
	}
	@Test
	public void Testcase4() {
		System.out.println("testcase 4");
	}
}
