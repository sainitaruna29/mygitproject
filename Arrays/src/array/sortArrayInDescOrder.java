package array;

import java.util.Scanner;

public class sortArrayInDescOrder {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] myIntegers = getIntegers(5);
		printArray(myIntegers);
		System.out.println(sortArray(myIntegers));
		descSort(myIntegers);
		
	}
	
	public static int[] getIntegers(int num) {
		System.out.println("Enter " + num + " numbers.\r");
		int [] myArray = new int[num];
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = scanner.nextInt();
		}
		return myArray ;
		
	}
	
	public static void printArray(int[] num) {
		for(int i = 0; i < num.length; i++) {
			System.out.println("Element " + i + ", typed value was " + num[i]);
		}
		
	}
	
	public static int[] sortArray(int [] num) {
		System.out.println("Sorting of array started in descending order");
		int [] sortedArray = new int[num.length];
		for(int i = 0; i < num.length; i++) {
			sortedArray[i] = num[i];
		}
		
		boolean flag = true;
		int temp;
		while(flag) {
			flag = false;
			for(int i=0; i <sortedArray.length-1  ; i++) {
				if(sortedArray[i] < sortedArray[i+1]) {
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[i+1];
					sortedArray[i+1] = temp;
					flag = true;
				}
			}
			
		}
		return sortedArray;
	}
	
	public static void descSort(int [] num) {
		System.out.println("Sorting of array started in descending order");
		for(int i=num.length - 1 ; i >= 0 ; i--) {
			System.out.println(num[i]);
		}
	}

}
