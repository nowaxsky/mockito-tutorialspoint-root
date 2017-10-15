package org.cpm.zerowastelife;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
	public void testAddAndSubtract() {
		
		//add the behavior to add numbers
		when(calculatorService.add(20.0,10.0)).thenReturn(30.0);
		
		//subtract the behavior to subtract numbers
		when(calculatorService.subtract(20.0,10.0)).thenReturn(10.0);
		
		//subtract is tested before add
		//test the subtract functionality
		Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);
		
		//test the add functionality
		Assert.assertEquals(mathApplication.add(20.0, 10.0),30.0,0);
		
		//verify call to calcService is made or not
		verify(calculatorService).add(20.0,10.0);
		verify(calculatorService).subtract(20.0,10.0);
		
	}
	
}
