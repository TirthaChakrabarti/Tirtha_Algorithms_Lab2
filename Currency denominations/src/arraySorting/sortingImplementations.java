package arraySorting;

import java.util.Arrays;

public class sortingImplementations implements sortingInterface {

	@Override
	public void sort(int[] arr, int left, int right) {
		
		if (left < right) {
			int mid = left + (right - left)/2;
			
			sort(arr, left, mid);
			sort(arr, mid+1, right);
			
			mergeSort(arr, left, mid, right);
		}
	}

	@Override
	public void mergeSort(int[] arr, int left, int mid, int right) {
		
		int len1 = mid - left + 1;
		int len2 = right - mid;
		
		int leftArr[] = new int[len1];
		int rightArr[] = new int[len2];
		
		for(int i=0; i<len1; i++) {
			leftArr[i] = arr[left + i];
		}
		
		for (int i=0; i<len2; i++) {
			rightArr[i] = arr[mid + 1 + i];
		}
		
		int i=0; int j=0; int k=left;
		
		while((i<len1)&&(j<len2)) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			}
			else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while(i<len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		
		while(j<len2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	@Override
	public String display(int[] arr) {
		
		return Arrays.toString(arr);	
	}
}
