package org.example.services;

import org.example.models.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContractManagementService implements IContactManagementService{
    ArrayList<Contact> contacts = new ArrayList<>();
    FileService fileService = new FileService();
    @Override
    public void addContact(Contact newContact) {
        contacts.add(newContact);
        fileService.writeToFile(contacts);
    }

    @Override
    public List<Contact> getContacts() {
        contacts = (ArrayList<Contact>) fileService.readFromFile();
        return contacts;
    }

    @Override
    public Contact searchContact(String name) {
        for(Contact contact : contacts) {
            if (Objects.equals(contact.getName(), name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public void deleteContact(String name) {
        boolean contactFound = false;
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (Objects.equals(contact.getName(), name)) {
                contactFound = true;
//                System.out.println("Are you sure you want to delete " + contact.getName() + "? (yes/no)");
//                String answer = scanner.nextLine();
//                if (answer.equalsIgnoreCase("yes")) {
                contacts.remove(i);
                    // Save to JSON after deleting
                fileService.writeToFile(contacts);
//                    JsonFileWriter.writeContacts(contacts);
                    System.out.println("Contact has successfully been removed");
//                } else {
//                    System.out.println("Contact has not been removed");
//                }
                break;
            }
        }
    }
}
