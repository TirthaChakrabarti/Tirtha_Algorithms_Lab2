package transactionServices;

import java.util.Scanner;

public class transactionImplementations implements transactionInterface {
	
	private int arr[];
	private int noOfTarget;
	
	Scanner scan = new Scanner(System.in);

	@Override
	public void getTransactions() {
		
		//Creating and filling up transactions array
		
		System.out.print("Enter the size of transaction array: ");
		arr = new int[scan.nextInt()];
		
		System.out.println("Enter the values of array: ");
		for (int i=0;i<arr.length;i++) {
			System.out.print("\ttransaction value "+(i+1)+": ");
			arr[i] = scan.nextInt();
		}
	}

	@Override
	public void getTargets() {
		
		System.out.print("Enter the total no. of target(s) that need to be achieved: ");
		noOfTarget = scan.nextInt();
	}

	@Override
	public void checkTargetStatus() {
		
		for(int j=0;j<noOfTarget;j++) {
			System.out.print("Enter the value of target: ");
			int targetValue = scan.nextInt();
			
			int sum = 0;
			for (int i=0;i<arr.length;i++) {
				sum += arr[i];
				if(sum >= targetValue) {
					System.out.println("Target achieved after "+(i+1)+" transaction(s)");
					break;
				}
			}
			if (sum < targetValue) {
				System.out.println("Given target is not achieved");
			}
		}
	}
}
