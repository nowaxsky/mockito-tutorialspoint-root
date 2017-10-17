package org.cpm.zerowastelife;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

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
		
		when(calculatorService.add(20.0,10.0)).thenAnswer(new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				
				//get the arguments passed to mock
				Object[] args = invocation.getArguments();
				
				//get the mock
				Object mock = invocation.getMock();
				
				//return the result
				return 30.0;			
			}		
		});
		
		Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
		

	}
	
}
