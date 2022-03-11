package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {

    private List<Contact> myContacts = new ArrayList<>();

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public void addNewContact(Contact contact) {
        myContacts.add(contact);
    }

    public boolean findContact(Contact newContact) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getFirstName().equals(newContact.getFirstName()) && contact.getLastName().equals(newContact.getLastName())) {
                return true;
            }
        }
        return false;
    }

    public Contact queryContactByName(String firstName, String lastName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getFirstName().equals(firstName) && myContacts.get(i).getLastName().equals(lastName))
                return myContacts.get(i);
        }
        return null;
    }

    public boolean updateContact(Contact existingContactRecord, Contact newContact) {
        int position = myContacts.indexOf(existingContactRecord);
        myContacts.set(position, newContact);
        return true;
    }

    public boolean removeContact(Contact existingContactRecord) {
        myContacts.remove(existingContactRecord);
        return true;
    }
}