package org.cpm.zerowastelife;

public class MathApplication {

	private CalculatorService calculatorService;
	
	public void setCalculatorService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	//we directly implement add method
	public double add(double input1, double input2) {
//		return calculatorService.add(input1, input2);
		return input1 + input2;
	}
	
	public double subtract(double input1, double input2) {
		return calculatorService.add(input1, input2);
	}
	
	public double multiply(double input1, double input2) {
		return calculatorService.add(input1, input2);
	}
	
	public double divide(double input1, double input2) {
		return calculatorService.add(input1, input2);
	}
}
