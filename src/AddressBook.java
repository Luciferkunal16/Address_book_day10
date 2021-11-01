package Line_Conversion;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	private ArrayList<contact> person = new ArrayList<contact>(); // An array of Contacts - each stores info for one
																	// friend

	// Add a contact that's passed in as a parameter.
	public void addContact(contact c) {
		person.add(c);
	}

	/* Method For Printing Values */
	public void printContacts() {
		for (int i = 0; i < person.size(); i++)
			System.out.println(person.get(i));
	}

	public void deleteContact(String s) {
		int place = haveContact(s);
		if (place >= 0)
			person.remove(place);
	}

	int haveContact(String s) {
		for (int i = 0; i < person.size(); i++)
			if (person.get(i).getfName().equals(s))
				return i;

		return -1;
	}

// method for Editing existing contact
	public void editContact(String s) {
		Scanner inp = new Scanner(System.in);
		int place = haveContact(s);
		if (place > 0) {

			System.out.println("Enter Last name");
			String lname = inp.next();
			System.out.println("Enter Phone Number");
			int phoneNumber = inp.nextInt();
			System.out.println("Enter City");
			String city = inp.next();
			System.out.println("Enter State");
			String state = inp.next();
			System.out.println("Enter Pin Code");
			int pinCode = inp.nextInt();

			contact obj = new contact(s, lname, phoneNumber, city, state, pinCode);

			person.set(place, obj);
		} else if (place == -1)
			;
		{
			System.out.println("\nFirst Name Not Match\n");
		}
	}

	public static void menu() {
		System.out.println("1.Add a new contact to your address book.");
		System.out.println("2.Print out the  contacts you have.");
		System.out.println("3.Edit Existing contact");
		System.out.println("4.Delete Existing Contact");
		System.out.println("5.Add Multiple Conatct at Once");
		System.out.println("6.Quit.");
		System.out.println("Enter your menu choice:");
	}

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		AddressBook obj = new AddressBook();
		menu();
		int choice = inp.nextInt();
		while (choice != 6) {

			if (choice == 1) {
				System.out.println("Enter First Name:");
				String fName = inp.next();
				System.out.println("Enter Last NAme");
				String lName = inp.next();
				System.out.println("Enter  phone number.");
				int number = inp.nextInt();
				System.out.println("Enter The City");
				String city = inp.next();
				System.out.println("Enter The State");
				String state = inp.next();
				System.out.println("Enter the pin code");
				int pinCode = inp.nextInt();
				obj.addContact(new contact(fName, lName, number, city, state, pinCode));

			} else if (choice == 2) {
				obj.printContacts();

			} else if (choice == 3) {
				contact rv = new contact();
				System.out.println("Enter the First Name of the contact you want to edit?");
				String fName = inp.next();
				obj.editContact(fName);

			} else if (choice == 4) {
				System.out.println("What is the First name of the contact you want to delete?");
				String fName = inp.next();
				obj.deleteContact(fName);
			} else if (choice == 5) {
				System.out.println("Enter How Many Contact You Want to Add");
				int number=inp.nextInt();
				for(int i=0;i<number;i++) {
					System.out.println("Enter First Name:");
					String fName = inp.next();
					System.out.println("Enter Last NAme");
					String lName = inp.next();
					System.out.println("Enter  phone number.");
					int pnumber = inp.nextInt();
					System.out.println("Enter The City");
					String city = inp.next();
					System.out.println("Enter The State");
					String state = inp.next();
					System.out.println("Enter the pin code");
					int pinCode = inp.nextInt();
					obj.addContact(new contact(fName, lName, pnumber, city, state, pinCode));
				}

			}
			menu();
			choice = inp.nextInt();
		}
	}
}
