package main;

import transactionServices.transactionImplementations;

public class DriverClass {

	public static void main(String[] args) {
		
		transactionImplementations obj = new transactionImplementations();
		
		obj.getTransactions();
		obj.getTargets();
		obj.checkTargetStatus();
	}
}
