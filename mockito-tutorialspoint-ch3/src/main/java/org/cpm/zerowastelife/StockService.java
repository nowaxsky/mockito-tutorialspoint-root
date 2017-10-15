package org.cpm.zerowastelife;

public interface StockService {

	//IMPORTANT!
	//we don't plan to implement this method, we try to use mockito to mock this method behavior
	public double getPrice(Stock stock);
}
