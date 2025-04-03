package org.example.services;

import org.example.models.Contact;

import java.util.List;

public interface IFileService {
    void writeToFile(List<Contact> contacts);

    List<Contact> readFromFile();
}
