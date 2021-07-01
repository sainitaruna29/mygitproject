package linkedList;

import java.util.Scanner;

public class ContactMain {
	
	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new MobilePhone("0039 330 4404");
	public static void main(String[] args) {
		
		boolean quit = false;
		startPhone();
		printActions();
		while(!quit) {
			System.out.println("\n Enter action: 6 (to show available actions)");
			int actions = scanner.nextInt();
			scanner.nextLine();
			switch(actions) {
			case 0 :
				System.out.println("Shutting down....");
				quit = true;
				break;
			case 1 :
				mobilePhone.printContacts();
				break;
			case 2 :
				addNewContact();
				break;
			case 3 :
				updateContact();
				break;
			case 4 :
				removeContact();
				break;
			case 5 :
				queryContact();
				break;
			case 6 :
				printActions();
				break;
			}
		}
	}
	
	private static void addNewContact() {
		System.out.println("Enter new contact name ");
		String name = scanner.nextLine();
		System.out.println("Enter phone number ");
		String phone = scanner.nextLine();
		Contacts contact = Contacts.createContact(name, phone);
		if(mobilePhone.addNewContact(contact)) {
			System.out.println("New contact added : name = " + name + ", phone = " + phone);
		}else {
			System.out.println("Cannot add " + name + "already on file.");
		}
			
	}
	
	private static void updateContact() {
		System.out.println("Enter existing contact name: ");
		String exisitingContact = scanner.nextLine();
		Contacts exisitingContactRecord = mobilePhone.queryContact(exisitingContact);
		if(exisitingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		
		System.out.println("Enter new contact name ");
		String newName = scanner.nextLine();
		System.out.println("Enter new phone number ");
		String newPhone = scanner.nextLine();
		Contacts newContact = Contacts.createContact(newName, newPhone);
		if(mobilePhone.updateContact(exisitingContactRecord, newContact)) {
			System.out.println("Contact updated successfully.");
		}else {
			System.out.println("Error updating record.");		
		}
	}
	
	private static void removeContact() {
		System.out.println("Enter existing contact name: ");
		String exisitingContact = scanner.nextLine();
		Contacts exisitingContactRecord = mobilePhone.queryContact(exisitingContact);
		if(exisitingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		
		if(mobilePhone.removeContact(exisitingContactRecord)) {
			System.out.println("Deleted successfully.");
		}else {
			System.out.println("Error in deleting.");		
		}
	}
	
	private static void queryContact() {
		System.out.println("Enter existing contact name: ");
		String exisitingContactName = scanner.nextLine();
		Contacts exisitingContactRecord = mobilePhone.queryContact(exisitingContactName);
		if(exisitingContactRecord == null) {
			System.out.println("Contact not found");
			return;
		}
		
		System.out.println("Name = " + exisitingContactRecord.getName() + " phone number = " +
				exisitingContactRecord.getPhoneNumber());
	}
	
	private static void startPhone() {
		System.out.println("Starting phone....");
	}
	
	private static void printActions() {
		System.out.println("\nAvailable actions: \npress");
		System.out.println("0 - to shutdown\n"    +
						"1 - to print contacts\n" +
						"2 - to add a new contact\n" +
						"3 - to update an existing contact\n" +
						"4 - to remove an existing contact\n"+
						"5 - query if an existing contact exists\n"+
						"6 - to print a list of avilable actions");
		System.out.println("Choose your action : ");				
		
	}

}
