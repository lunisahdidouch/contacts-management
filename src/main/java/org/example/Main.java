package org.example;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static int option;
    static ArrayList<Contact> contacts;

    public Main() {
    }

    public static void main(String[] args) {
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
            Contact newContact = new Contact(name, phoneNumber, email, age);
            contacts.add(newContact);
            System.out.println("Contact added successfully!");
            secondMenu();
        } else if (option == 2) {
            for(Contact contact : contacts) {
                System.out.print(contact.getName());
            }

            secondMenu();
        } else if (option == 3) {
            System.out.println("Type in the name of the person you want to search for:");
            String searchQuery = scanner.nextLine();

            for(Contact contact : contacts) {
                if (Objects.equals(contact.getName(), searchQuery)) {
                    PrintStream var10000 = System.out;
                    String var10001 = contact.getName();
                    var10000.print("Here is the contact information:\nName: " + var10001 + "\nPhone number: " + contact.getPhoneNumber() + "\nEmail: " + contact.getEmail() + "\nAge: " + contact.getAge());
                } else {
                    System.out.println("No contact found with that name");
                }
            }

            secondMenu();
        } else if (option == 4) {
            System.out.println("What contact do you want to delete?");
            String deleteContact = scanner.nextLine();
            System.out.println("What contact do you want to delete?");

            for(Contact contact : contacts) {
                if (Objects.equals(contact.getName(), deleteContact)) {
                    System.out.println("Are you sure want to delete " + contact.getName());
                    String answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("yes")) {
                        contacts.remove(contact);
                        System.out.println("Contact has successfully been removed");
                        secondMenu();
                    } else {
                        System.out.println("Contact has not been removed");
                        secondMenu();
                    }
                } else {
                    System.out.println("No contact found with that name");
                    secondMenu();
                }
            }

            secondMenu();
        } else if (option == 0) {
            System.exit(0);
        }

    }

    static void menu() {
        System.out.println("\n\n\nWelcome to your contact management system");
        System.out.println("Choose an option below to continue:");
        System.out.println("1: Add contact\n2: View all contact\n3: Search contact\n4: Delete contact\n5: Exit");
        option = Integer.parseInt(scanner.next());
        scanner.nextLine();
        actions();
    }

    static void secondMenu() {
        System.out.println("\n\n\nChoose an option:\n1: See menu again\n2: Exit");
        int answer = scanner.nextInt();
        if (answer == 2) {
            System.exit(0);
        } else {
            menu();
        }

    }

    static {
        scanner = new Scanner(System.in);
        contacts = new ArrayList();
    }
}