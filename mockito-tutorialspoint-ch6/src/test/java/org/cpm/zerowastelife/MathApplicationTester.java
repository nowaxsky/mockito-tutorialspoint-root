package org.cpm.zerowastelife;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calculatorService;
	
	@Test
	public void testAdd() {

		//add the behavior of calculatorService service to add two numbers
		when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
		
		//test the add functionality
		//this add use add method in CalculatorService
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		
		//verify the behavior
		//there were zero interactions with this mock 
		//because we directly use add method in MathApplication instead of using mock object of CalculatorService
		verify(calculatorService).add(10, 20);
		
		/**
		 * DIFFERENT ARGUMENTS
		 * 
		 * now adjust add method in MathApplication to return calculatorService.add(input1, input2),
		 * also change verify to verify(calculatorService).add(20, 10) like following,
		 * test will fail too owing to different arguments
		 * 
		 */
//		verify(calculatorService).add(20, 10);
	}
}
