package payments;

import java.util.Scanner;
import arraySorting.sortingImplementations;

public class paymentImplementations implements paymentInterface {
	
	private int denomArr[];
	
	Scanner scan = new Scanner(System.in);

	@Override
	public void getDenominations() {
		
		//Creating and filling up denominations array
		
		System.out.print("Enter the number of currency denominations: ");
		denomArr = new int[scan.nextInt()];
		
		System.out.println("Enter the currency denomination values: ");
		for(int i=0;i<denomArr.length;i++) {
			System.out.print("\tValue "+(i+1)+": ");
			denomArr[i] = scan.nextInt();
		}
		
		//Sorting the denominations array in ascending order
		
		sortingImplementations obj = new sortingImplementations();
		obj.sort(denomArr, 0, denomArr.length-1);
		
		System.out.print("Currency denominations = ");
		System.out.println(obj.display(denomArr));
	}

	@Override
	public void doPayment() {
		
		System.out.println("Enter the amount you want to pay: ");
		int amount = scan.nextInt();
		
		System.out.println("Your payment approach in order to give min no. of notes will be: ");
		
		findPaymentApproach(denomArr, amount);
	}
	
	public static void findPaymentApproach(int array[], int amount){
		
		int change = 0;
		int[] noteCountArr = new int[array.length];
		
		//Calculating minimum no. of notes of various denominations required
		
		for (int i=array.length-1;i>=0;i--) {
			noteCountArr[i] = amount/array[i];
			amount = amount%array[i];
			if (amount == 0) {
				break;
			}
			if (amount < array[0]) {
				noteCountArr[0] += 1;
				change= array[0] - amount;
				break;
			}
		}
		
		//displaying minimum no. of notes of various denominations required
		
		for (int i=noteCountArr.length-1;i>=0;i--) {
			if (noteCountArr[i] > 0) {
				System.out.println(array[i]+":"+noteCountArr[i]);
			}
		}
		
		//displaying change return
		
		if (change > 0) {
			System.out.println("Get change of "+change);
		}
	}		
}
