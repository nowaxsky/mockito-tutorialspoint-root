package org.cpm.zerowastelife;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
			fail();
		} catch (Exception e) {
			assertThat("success", true);
		}
		
	}
	
	//BEST WAY SINCE JUNIT 4.7
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testMultiply() {
		
		//You can add any detail of exception you want
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("multiply operation not implemented");
		
		RuntimeException expected = new RuntimeException("multiply operation not implemented");
		when(calculatorService.subtract(20.0, 10.0)).thenThrow(expected);
		Assert.assertEquals(mathApplication.subtract(20.0, 10.0),200.0,0);
		
	}
	
	//CUSTOM EXCEPTION TESTING
	@Test
	public void testDivide() throws MyException {
		
		thrown.expect(MyException.class);
		thrown.expect(MyMatcher.hasFields(new ExceptionField(666, "customized exception method")));
		
		MyException expected = new MyException(666, "customized exception method");
		when(calculatorService.divide(20.0, 0.0)).thenThrow(expected);
		mathApplication.divide(20.0, 0.0);
	}
	
}
