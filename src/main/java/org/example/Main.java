package org.example;

import org.example.models.Contact;
import org.example.services.ContractManagementService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static int option;
    static ArrayList<Contact> contacts;
    ContractManagementService service = new ContractManagementService();

    public Main() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        contacts = JsonFileReader.readContacts();
        scanner = new Scanner(System.in);
        menu();
    }

    static void actions() {
        if (option == 1) {
            System.out.println("Enter the contact's name:");
            String name = scanner.nextLine();
            System.out.println("Enter the phone number");
            String phoneNumber = scanner.nextLine();
            System.out.println("Enter the email address");
            String email = scanner.nextLine();
            System.out.println("Enter the age");

            while(!scanner.hasNextInt()) {
                System.out.println("Invalid! Enter a number: ");
                scanner.next();
            }

            int age = scanner.nextInt();
            scanner.nextLine();
            Contact newContact = new Contact(name, phoneNumber, email, age);
            service.addContact(newContact);
            System.out.println("Contact added successfully!");
            secondMenu();
        } else if (option == 2) {
            if (contacts.isEmpty()) {
                System.out.println("No contacts found.");
            } else {
                for(Contact contact : contacts) {
                    System.out.println(contact.getName());
                }
            }
            secondMenu();
        } else if (option == 3) {
            System.out.println("Type in the name of the person you want to search for:");
            String searchQuery = scanner.nextLine();
            boolean found = false;

            for(Contact contact : contacts) {
                if (Objects.equals(contact.getName(), searchQuery)) {
                    System.out.println("Here is the contact information:");
                    System.out.println("Name: " + contact.getName());
                    System.out.println("Phone number: " + contact.getPhoneNumber());
                    System.out.println("Email: " + contact.getEmail());
                    System.out.println("Age: " + contact.getAge());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No contact found with that name");
            }

            secondMenu();
        } else if (option == 4) {
            System.out.println("What contact do you want to delete?");
            String deleteContact = scanner.nextLine();

            service.deleteContact(deleteContact);

            if (!contactFound) {
                System.out.println("No contact found with that name");
            }

            secondMenu();
        } else if (option == 0) {
            System.exit(0);
        }
    }

    static void menu() {
        System.out.println("\n\n\nWelcome to your contact management system");
        System.out.println("Choose an option below to continue:");
        System.out.println("1: Add contact\n2: View all contact\n3: Search contact\n4: Delete contact\n0: Exit");

        try {
            option = Integer.parseInt(scanner.nextLine());
            actions();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            menu();
        }
    }

    static void secondMenu() {
        System.out.println("\n\n\nChoose an option:\n1: See menu again\n2: Exit");
        try {
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == 2) {
                System.exit(0);
            } else {
                menu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            secondMenu();
        }
    }
}