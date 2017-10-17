package org.cpm.zerowastelife;

import static org.mockito.Mockito.spy;

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
		Calculator calculator = new Calculator();	
		
		//Mockito provides an option to create spy on real objects. When a spy is called, then the actual method of the real object is called
		calculatorService = spy(calculator);
		mathApplication.setCalculatorService(calculatorService);
	}
	
	@Test
	public void testAdd() {
		
		//perform operation on real object
		//test the add functionality
		Assert.assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);	

	}
	
	class Calculator implements CalculatorService {

		@Override
		public double add(double input1, double input2) {
			return input1 + input2;
		}

		@Override
		public double subtract(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}

		@Override
		public double multiply(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}

		@Override
		public double divide(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}
		
	}
	
}
