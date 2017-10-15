package org.cpm.zerowastelife;

import static org.mockito.Mockito.doThrow;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	@Mock
	CalculatorService calculatorService;
	
	@Test(expected = RuntimeException.class)
	public void testAdd() {
		
		//add the behavior to throw exception
		doThrow(new RuntimeException("add operation not implemented")).when(calculatorService).add(10.0, 20.0);
		
		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
		
	}
}
