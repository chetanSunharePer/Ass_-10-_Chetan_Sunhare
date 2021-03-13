package com.psl.training.assigment.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.psl.training.assigment.beans.Contact;
import com.psl.training.assigment.beans.ContactNotFoundException;

public class ContactService {
	List<Contact> contacts = new ArrayList<>();
	public Contact addContact(Contact contact,List<Contact> contacts) {
		this.contacts.addAll(contacts);
		this.contacts.add(contact);
		return contact;
	}
	public void display() {
		for (Contact contact : contacts) {
			System.out.println("ID : "+contact.getContactID()+"\n"
					+ "Name : "+contact.getContactName()+"\n"
							+ "Email : "+contact.getEmailAddress()+"\n"
									+ "Numbers : ");
			for (String number : contact.getContactNumber()) {
				System.out.print(number+" ");
			}
			System.out.println();
		}
	}
	public void removeContact(Contact contact, List<Contact> contacts) throws ContactNotFoundException{
		Iterator<Contact> i = this.contacts.iterator();
		boolean b =true;
		while (i.hasNext()) {
			if (i.next().getContactID()==contact.getContactID()) {
				i.remove();
				b=false;
			}
		}
		if(b) {
			throw new ContactNotFoundException("Contact not found");
		}
	}
	public Contact searchContactByName(String name, List<Contact> contacts) throws ContactNotFoundException{
		Iterator<Contact> i = contacts.iterator();
		Contact con=null;
		while (i.hasNext()) {
			con = i.next();
			if(con.getContactName().equalsIgnoreCase(name)) {
				return con;
			}
		}
		throw new ContactNotFoundException("Contact Not Found.");
	}
}
