package linkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static GroceryList groceryList = new GroceryList();
	
	public static void main(String[] args) {
		boolean quit = false;
		int choice = 0;
		printInstructions();
		
		while(!quit) {
		System.out.print("Enter your choice : ");
		choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
		case 0 :
			printInstructions();
			break;
		case 1 :
			groceryList.printGroceryItems();
			break;
		case 2 :
			addItem();
			break;
		case 3 :
			modifyItem();
			break;
		case 4 :
			removeItem();
			break;
		case 5 :
			searchForItem();
			break;
		case 6 :
			processArrayList();
			break;
		case 7 :
			quit = true;
			break;
		}
		}

	}
	
	public static void printInstructions() {
		System.out.println("\nPress");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1 - To print the list of grocery items.");
		System.out.println("\t 2 - To add the grocery items to the list.");
		System.out.println("\t 3 - To modify an item in the list.");
		System.out.println("\t 4 - To remove the item from the list.");
		System.out.println("\t 5 - To search the item in the list.");
		System.out.println("\t 7 - To quit the application.");
	}
	
	public static void addItem() {
		System.out.print("Please enter the grocery item : ");
		groceryList.addGroceryItem(scanner.nextLine());
	}
	
	public static void modifyItem() {
		System.out.print("Current item name");
		String currentItem = scanner.nextLine();
		scanner.nextLine();
		System.out.print("Enter the new item");
		String newItem = scanner.nextLine();
		groceryList.modifyGroceryItem(currentItem, newItem);
	}
	
	public static void removeItem() {
		System.out.print("Enter the item to be removed");
		String item = scanner.nextLine();
		scanner.nextLine();
		groceryList.removeGroceryItem(item);
	}
	
	public static void searchForItem() {
		System.out.print("Enter the item to be searched");
		String searchItem = scanner.nextLine();
		if(groceryList.onFile(searchItem)) {
			System.out.print("Found " + searchItem + " in groceryList.");
		}else {
			System.out.print(searchItem + " is not in the list");
		}
	}
	
	public static void processArrayList() {
		ArrayList<String> newArrayList = new ArrayList<String>();
		newArrayList.addAll(groceryList.getGroceryList());
		
		ArrayList<String> nextArrayList = new ArrayList<String>(groceryList.getGroceryList());
		
		String [] myArray = new String[groceryList.getGroceryList().size()];
		myArray = groceryList.getGroceryList().toArray(myArray);
	}

}
