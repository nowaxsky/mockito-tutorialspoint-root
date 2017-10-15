package org.cpm.zerowastelife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

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
	
	//NOT A GOOD WAY
	@Test(expected = RuntimeException.class)
	public void testAdd() {
		
		//add the behavior to throw exception
		doThrow(new RuntimeException("add operation not implemented")).when(calculatorService).add(10.0, 20.0);
		
		//test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
		
	}
	
	//GOOD WAY
	@Test
	public void testSubtract() throws Exception {
		
		RuntimeException expected = new RuntimeException("subtract operation not implemented");
		when(calculatorService.subtract(20.0, 10.0)).thenThrow(expected);

		try {
			Assert.assertEquals(mathApplication.subtract(20.0, 10.0),10.0,0);
			assertThat("fail", false);
		} catch (Exception e) {
			assertThat("success", true);
		}
		
	}
	
}
