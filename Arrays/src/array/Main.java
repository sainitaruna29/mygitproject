package array;

import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] myIntegers = myIntegers(5);
		for(int i = 0; i < myIntegers.length; i++) {
			System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
		}
		
		System.out.println("Average of " + myIntegers.length + " is " + average(myIntegers));
		
	}
	
	public static int[] myIntegers(int num) {
		System.out.println("Enter " + num + " numbers.\r");
		int [] myArray = new int[num];
		for(int i = 0; i < myArray.length; i++) {
			myArray[i] = scanner.nextInt();
		}
		return myArray ;
		
	}
	
	public static double average(int [] num) {
		int sum = 0;
		for(int i =0 ; i < num.length ; i++) {
			sum += num[i];
		}
		return (double)sum / (double)num.length ;
	}

}
