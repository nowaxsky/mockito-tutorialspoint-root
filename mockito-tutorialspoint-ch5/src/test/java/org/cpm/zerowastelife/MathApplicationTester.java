package org.cpm.zerowastelife;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

//	//@InjectMocks annotation is used to create and inject the mock object
//	//because we need to inject CalculatorService(mock) in MathApplication
//	@InjectMocks
//	MathApplication mathApplication = new MathApplication();
//	
//	//@Mock annotation is used to create the mock object to be injected
//	@Mock
//	CalculatorService calculatorService;
//	
//	@Test
//	public void testAdd() {
//
//		when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
//		
//		//test the add functionality
//		//this add use add method in CalculatorService
//		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
//	}
	
	//following is another testing method, same with ch4
	private MathApplication mathApplication;
	private CalculatorService calculatorService;
	
	public static void main(String[] args) {
		MathApplicationTester tester = new MathApplicationTester();
		tester.setUp();
		System.out.println(tester.test() ? "pass" : "fail");
	}	
	
	private void setUp() {
		mathApplication = new MathApplication();
		calculatorService = mock(CalculatorService.class);
		mathApplication.setCalculatorService(calculatorService);
		
	}

	private boolean test() {
		when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
		return mathApplication.add(10.0, 20.0) == 30.0;
	}

}
