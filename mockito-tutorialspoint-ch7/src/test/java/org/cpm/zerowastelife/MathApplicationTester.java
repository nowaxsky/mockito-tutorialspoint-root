package org.cpm.zerowastelife;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
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

		when(calculatorService.add(10.0, 20.0)).thenReturn(30.00);
		when(calculatorService.subtract(20.0, 10.0)).thenReturn(10.00);
		
		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		
		Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0.0);
		
		//default call count is 1
		verify(calculatorService).subtract(20, 10);
		
		//check if add function is called three times
		verify(calculatorService, times(3)).add(10.0, 20.0);
		
		//verify that method was never called on a mock
		verify(calculatorService, never()).multiply(10.0, 20.0);
		
		
		
	}
}
