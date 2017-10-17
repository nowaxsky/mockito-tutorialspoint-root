package org.cpm.zerowastelife;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	private MathApplication mathApplication;
	private CalculatorService calculatorService;
	
	@Before
	public void setUp() {
		mathApplication = new MathApplication();
		calculatorService = mock(CalculatorService.class);
		mathApplication.setCalculatorService(calculatorService);
	}
	
	@Test
	public void testAdd() {
		
		//add the behavior to add numbers
		when(calculatorService.add(20.0,10.0)).thenReturn(30.0);
		//test the add functionality
		Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);
		
		//Mockito provides the capability to reset a mock, so that it can be reused later
		//reset the mock
		reset(calculatorService);
		//test the add functionality after resetting the mock
		Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);

	}
	
}
