package com.psl.training.assigment.service;

import java.util.ArrayList;
import java.util.List;

import com.psl.training.assigment.beans.Contact;

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
	
}
