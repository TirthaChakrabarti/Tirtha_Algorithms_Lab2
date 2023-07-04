package main;

import payments.paymentImplementations;

public class DriverClass {

	public static void main(String[] args) {
		
		paymentImplementations obj = new paymentImplementations();
		
		obj.getDenominations();
		obj.doPayment();
	}
}
