import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.psl.training.assigment.beans.Contact;
import com.psl.training.assigment.service.ContactService;

public class ContactTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactService service = new ContactService();
		List<Contact> contacts = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		 boolean b= true;
		while(b) {
			 System.out.println("Menu : ");
			 System.out.println("1. add new contact\n"
			 		+ "2. display\n"
			 		+ "3. exit");
			 System.out.println("Enter your choice : ");
			 int key = Integer.parseInt(sc.nextLine());
			 switch (key) {
			case 1:
				System.out.println("Enter Contact Id : ");
				int contactID=Integer.parseInt(sc.nextLine());
				System.out.println("Enter Contact Name : ");
				String contactName = sc.nextLine();
				System.out.println("Enter Email Id : ");
				String emailAddress = sc.nextLine();
				System.out.println("Enter all numbers ( seperate all number by /)");
				String[] numbers = sc.nextLine().split("/");
				List<String> contactNumber = new ArrayList<>();
				contactNumber.addAll(Arrays.asList(numbers));
				
				Contact contact = new Contact(contactID, contactName, emailAddress, contactNumber);
				contacts.add(service.addContact(contact, contacts));
				
				break;
			case 2:
				service.display();
				break;
			case 3:
				b = false;
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		 }
	}

}
