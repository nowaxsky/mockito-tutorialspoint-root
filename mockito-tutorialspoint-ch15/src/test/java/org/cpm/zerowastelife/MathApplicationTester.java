package org.cpm.zerowastelife;

import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;

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
		
		//Behavior Driven Development is a style of writing tests using given, when, and then format as test methods
		//given
		given(calculatorService.add(20.0, 10.0)).willReturn(30.0);
		
		//when
		double result = calculatorService.add(20.0, 10.0);
		
		//then
		Assert.assertEquals(result, 30.0, 0);

	}
	
}
