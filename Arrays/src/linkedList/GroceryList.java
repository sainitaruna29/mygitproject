package linkedList;

import java.util.ArrayList;

public class GroceryList {
	private ArrayList<String> groceryList = new ArrayList<String>();
	
	public void addGroceryItem(String item) {
		groceryList.add(item);
	}
	
	public ArrayList<String> getGroceryList() {
		return groceryList;
	}



	public void printGroceryItems() {
		System.out.println("You have " + groceryList.size() + " items in your cart.");
		for(int i=0 ; i<groceryList.size() ; i++) {
			System.out.println((i+1) + ". " + groceryList.get(i));
		}
	}
	
	public void modifyGroceryItem(String currentItem, String item) {
		int position = findGroceryItem(currentItem);
		if(position >= 0) {
			modifyGroceryItem(position, item);
		}
	}
	
	private void modifyGroceryItem(int position, String newItem) {
		groceryList.set(position, newItem);
		System.out.println("Grocery item at position " + (position+1) + " has been modified.");
	}
	
	public void removeGroceryItem(String item) {
		int position = findGroceryItem(item);
		if(position >= 0) {
			removeGroceryItem(position);
		}
	}
	
	private void removeGroceryItem(int position) {
		String item = groceryList.get(position);
		groceryList.remove(position);
		System.out.println("Grocery item at position " + (position) + " has been removed.");
	}
	
	private int findGroceryItem(String searchItem) {
		//boolean exists = groceryList.contains(searchItem);
		return groceryList.indexOf(searchItem);
	}
	
	public boolean onFile(String searchItem) {
		int position = findGroceryItem(searchItem);
		if(position >= 0) {
			return true;
		}
		return false;
		
	}
}
