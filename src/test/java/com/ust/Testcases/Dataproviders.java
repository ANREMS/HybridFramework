package com.ust.Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders {

	@Test(dataProvider = "testData")
	public void testcase1(String username,String password) {
		System.out.println(username+" "+password);
	}
	
	@DataProvider(name = "testData")
	public Object[][] testdata(){
		String[][] data= {
				{"thupakki","vijay"},
				{"lucifer","mohanlal"},
				{"rolex","surya"}
		};
		return data;
	}
}
