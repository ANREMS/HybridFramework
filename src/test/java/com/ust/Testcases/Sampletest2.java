package com.ust.Testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sampletest2 {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Im before test");
	}
	@Test(groups = {"valid"})
	public void Testcase1() {
		System.out.println("testcase 1");
	}
	@Test(groups = {"valid"})
	public void Testcase2() {
		System.out.println("testcase 2");
	}
	@Test(groups = {"invalid"})
	public void Testcase3() {
		System.out.println("testcase 3");
	}
	@Test(groups = {"invalid","valid"} )
	public void Testcase4() {
		System.out.println("testcase 4");
	}
	//suite file-Test suite
}
