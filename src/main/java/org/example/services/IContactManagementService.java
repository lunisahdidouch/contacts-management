package org.example.services;

import org.example.models.Contact;

import java.util.List;

public interface IContactManagementService {
    void addContact(Contact newContact);
    List<Contact> getContacts();
    Contact searchContact(String name);
    void deleteContact(String name);
}z