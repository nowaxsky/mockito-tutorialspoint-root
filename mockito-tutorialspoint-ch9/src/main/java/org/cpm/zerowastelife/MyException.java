package org.cpm.zerowastelife;

public class MyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1874120629285360176L;
	private int errorCode;
	
	public MyException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
