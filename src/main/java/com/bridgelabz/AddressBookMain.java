package com.bridgelabz;

import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
    public static AddressBook addressBook = new AddressBook();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Enter 0 to quit the AddressBook system ");
            System.out.println("Enter 1 to add New contact");
            System.out.println("Enter 2 to edit existing contact");
            System.out.println("Enter 3 to edit delete existing contact");
            System.out.println("Enter 4 to Add Multiple Contacts");
            option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Exiting from Address Book");
                    break;
                case 1:
                    addNewContact();
                    displayContacts();
                    break;
                case 2:
                    editContact();
                    displayContacts();
                    break;
                case 3:
                    deleteContact();
                    displayContacts();
                    break;
                case 4:
                    addMultipleContacts();
                default:
                    System.out.println("Invaild entry");
            }
        } while (option != 0);
    }

    private static void addNewContact() {
        System.out.println("Enter first Name:");
        String firstName = scanner.next();
        System.out.println("Enter last Name:");
        String lastName = scanner.next();
        System.out.println("Enter address:");
        String address = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();
        System.out.println("Enter state:");
        String state = scanner.next();
        System.out.println("Enter zip:");
        int zip = scanner.nextInt();
        System.out.println("Enter phoneNumber:");
        long phoneNumber = scanner.nextLong();
        System.out.println("Enter emailId:");
        String email = scanner.next();
        Contact newContact = Contact.createContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        if (!addressBook.findContact(newContact)) {
            addressBook.addNewContact(newContact);
            System.out.println("New contact added Successfully..");
        } else {
            System.out.println("Cannot add " + firstName + " already on contactBook list");
        }
    }

    private static void editContact() {
        System.out.println("Enter existing contact firstName and lastName:");
        String firstName = scanner.next();
        String lastName = scanner.next();
        Contact existingContactRecord = addressBook.queryContactByName(firstName, lastName);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        System.out.println("Enter new first Name:");
        String newFirstName = scanner.next();
        System.out.println("Enter new last Name:");
        String newLastName = scanner.next();
        System.out.println("Enter  new address:");
        String newAddress = scanner.next();
        System.out.println("Enter new city:");
        String newCity = scanner.next();
        System.out.println("Enter new state:");
        String newState = scanner.next();
        System.out.println("Enter  new zip:");
        int newZip = scanner.nextInt();
        System.out.println("Enter  new phone Number:");
        long newPhoneNumber = scanner.nextLong();
        System.out.println("Enter new email:");
        String newEmail = scanner.next();
        Contact newContact = Contact.createContact(newFirstName, newLastName, newAddress, newCity, newState, newZip, newPhoneNumber, newEmail);

        if (addressBook.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated the Contact");
        } else {
            System.out.println("Not updated");
        }
    }


    private static void deleteContact() {
        System.out.println("Enter existing contact firstName & LastName :");
        String firstName = scanner.next();
        String lastName = scanner.next();
        Contact existingContactRecord = addressBook.queryContactByName(firstName, lastName);
        if (existingContactRecord == null) {
            System.out.println("Contact Not Found");
            return;
        }
        if (addressBook.removeContact(existingContactRecord)) {
            System.out.println(firstName + " " + lastName + " is deleted successfully");
        } else {
            System.out.println("Error in deleting the contact");
        }
    }

    private static void addMultipleContacts() {
        System.out.println("Enter first Name:");
        String firstName = scanner.next();
        System.out.println("Enter last Name:");
        String lastName = scanner.next();
        System.out.println("Enter address:");
        String address = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();
        System.out.println("Enter state:");
        String state = scanner.next();
        System.out.println("Enter zip:");
        int zip = scanner.nextInt();
        System.out.println("Enter phoneNumber:");
        long phoneNumber = scanner.nextLong();
        System.out.println("Enter emailId:");
        String email = scanner.next();
        Contact newContact = Contact.createContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        if (!addressBook.findContact(newContact)) {
            addressBook.addNewContact(newContact);
            System.out.println("New contact added Successfully..");
        } else {
            System.out.println("Cannot add " + firstName + " already on contactBook list");
        }

        System.out.println("Do you want add one more Contact Details");
        System.out.println("1 :Yes     2 :No");
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                addMultipleContacts();
                break;
            case 2:
                displayContacts();
                break;
            default:
                System.out.println("Please Enter correct choice");
        }
    }

    private static void displayContacts() {
        List<Contact> myContacts = addressBook.getMyContacts();
        if(!myContacts.isEmpty()) {
            System.out.println("AddressBook List");
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println("Contact " + (i + 1) + myContacts.get(i));
            }
        } else
            System.out.println("Empty Address book");
    }
}