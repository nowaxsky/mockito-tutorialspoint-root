package org.cpm.zerowastelife;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class MyMatcher extends TypeSafeMatcher<MyException> {

	public static MyMatcher hasFields(ExceptionField entity) {
		return new MyMatcher(entity);
	}
	
	private int foundErrorCode;
	private final int expectedErrorCode;
	private String foundMessage;
	private final String expectedMessage;
	
	private MyMatcher(ExceptionField entity) {
		this.expectedErrorCode = entity.getErrorCode();
		this.expectedMessage = entity.getMessage(); 
	}
	
	
	@Override
	public void describeTo(Description description) {
		description.appendValue(foundErrorCode).appendText(" was not found instead of ").appendValue(expectedErrorCode);
		description.appendValue(foundMessage).appendText(" was not found instead of ").appendValue(foundMessage);	
	}

	@Override
	protected boolean matchesSafely(MyException exception) {
		this.foundErrorCode = exception.getErrorCode();
		this.foundMessage = exception.getMessage();
		
		if(foundErrorCode == expectedErrorCode && foundMessage.equalsIgnoreCase(expectedMessage)) return true;
		else return false;
	}

//	public static MyMatcher hasCode(int item) {
//        return new MyMatcher(item);
//    }
//
//    private int foundErrorCode;
//    private final int expectedErrorCode;
//
//    private MyMatcher(int expectedErrorCode) {
//        this.expectedErrorCode = expectedErrorCode;
//    }
//	
//	@Override
//	public void describeTo(Description description) {
//		 description.appendValue(foundErrorCode).appendText(" was not found instead of ").appendValue(expectedErrorCode);		
//	}
//
//	@Override
//	protected boolean matchesSafely(final MyException exception) {
//		this.foundErrorCode = exception.getErrorCode();
//        return foundErrorCode == expectedErrorCode;
//	}
	
	

}
