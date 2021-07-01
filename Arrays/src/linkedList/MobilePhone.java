package linkedList;

import java.util.ArrayList;

public class MobilePhone {
	private String myNumber;
	private ArrayList<Contacts> myContacts;
	
	public MobilePhone(String myNumber) {
		this.myNumber = myNumber;
		this.myContacts = new ArrayList<Contacts>();
	}
	
	public boolean addNewContact(Contacts contact) {
		if(findContact(contact.getName()) >= 0) {
			System.out.println("Contact is already on file");
			return false;
		}
		
		this.myContacts.add(contact);
		return true;
	}
	
	public boolean updateContact(Contacts existingContact, Contacts newContact) {
		int foundPosition = findContact(existingContact);
		if(foundPosition < 0) {
			System.out.print(existingContact.getName() + " was not found");
			return false;
		}else if(findContact(newContact) != -1) {
			System.out.print(" Contact with name " + newContact.getName() + " already exists. Update was unsuccessful");
			return false;
		}
			
		
		this.myContacts.set(foundPosition, newContact);
		return true;
	}
	
	public boolean removeContact(Contacts contact) {
		int foundPosition = findContact(contact);
		if(foundPosition < 0) {
			System.out.print(contact.getName() + " was not found");
			return false;
		}
		this.myContacts.remove(foundPosition);
		return true;
	}
	
	private int findContact(Contacts contact) {
		return this.myContacts.indexOf(contact);
	}
	
	private int findContact(String contactName) {
		for(int i=0 ; i<this.myContacts.size() ; i++) {
			Contacts contact = this.myContacts.get(i);
			if(contact.getName().equals(contactName)){
				return i;
			}
		}
		return -1;
	}
	
	public Contacts queryContact(String name) {
		int position = findContact(name);
		if(position >= 0) {
			return this.myContacts.get(position);
		}
		return null;
	}
	
	public String queryContact(Contacts contact) {
		if(findContact(contact) >= 0) {
			return contact.getName();
		}
		return null;
	}
	
	public void  printContacts() {
		System.out.println("Contact list : ");
		for(int i=0 ; i < this.myContacts.size() ; i++) {
			System.out.println((i+1) + ". " +
								this.myContacts.get(i).getName() +
								" -> " + this.myContacts.get(i).getPhoneNumber());
		}
	}
}
