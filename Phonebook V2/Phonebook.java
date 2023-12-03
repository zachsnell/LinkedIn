//Programmer: Zach Snell
//Class: CS 145
//Date: 10/31/2023
//Source: CS 141, Deitel/Deitel, ChatGPT, Building Java Programs: A Back to Basics Approach, 5th edition
//Purpose: To run a program that allows the user to add, remove, modify and eventually print out contacts for a phonebook.


import java.util.Scanner;

public class Phonebook {
    Node head;

    // Constructor to initialize the head of the linked list
    public Phonebook() {
        this.head = null;
    } // end of Phonebook

    // Method to add a new contact to the phonebook
    public void addContact(Scanner scanner) {
        
        // Prompt user for contact information
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create a new contact object
        Contact contact = new Contact(firstName, lastName, address, city, phoneNumber);

        // Create a new node and add it to the beginning of the linked list
        Node newNode = new Node(contact);
        newNode.next = head;
        head = newNode;

        System.out.println("\nContact added: " + contact.toString());
    } // end of addContact

    // Method to display all contacts in the phonebook
    public void displayContacts() {
        Node current = head;
        System.out.println("\nContacts:");

        while (current != null) {
            System.out.println(current.contact.toString());
            current = current.next;
        } // end of while
    } // end of displayContacts

    // Method to sort contacts by last name using bubble sort
    public void sortContacts() {
        Node current = head, index = null;
        String tempFirstName, tempLastName, tempPhone, tempAddress, tempCity;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.contact.lastName.compareTo(index.contact.lastName) > 0) {
                        // Temporary variables to hold contact information for swapping
                        tempLastName = current.contact.lastName;
                        tempFirstName = current.contact.firstName;
                        tempAddress = current.contact.address;
                        tempCity = current.contact.city;
                        tempPhone = current.contact.phoneNumber;

                        // Swap values of current contact with index contact
                        current.contact.lastName = index.contact.lastName;
                        current.contact.firstName = index.contact.firstName;
                        current.contact.address = index.contact.address;
                        current.contact.city = index.contact.city;
                        current.contact.phoneNumber = index.contact.phoneNumber;
                        
                        // Assign original values of current contact to index contact
                        index.contact.lastName = tempLastName;
                        index.contact.firstName = tempFirstName;
                        index.contact.address = tempAddress;
                        index.contact.city = tempCity;
                        index.contact.phoneNumber = tempPhone;
                    } // end of if
                    index = index.next;
                } // end of while
                current = current.next;
            } //end of while
        } // end of else
    } // end of sortContacts

    // Method to modify an existing contact
    public void modifyContact(Scanner scanner) {
        Node current = head;
        Node previous = null;

        System.out.println("Enter last name of person you would like to modify:");
        String lastName = scanner.nextLine();

        while (current != null && !current.contact.lastName.toLowerCase().equals(lastName.toLowerCase())) {
            previous = current;
            current = current.next;
        } // end of while

        if (current == null) {
            System.out.println("\nContact not found.");
            return;
        } // end of if

        // Prompt user for updated contact information
        System.out.print("Enter new first name: ");
        String firstNameMod = scanner.nextLine();

        System.out.print("Enter new last name: ");
        String lastNameMod = scanner.nextLine();

        System.out.print("Enter new address: ");
        String addressMod = scanner.nextLine();

        System.out.print("Enter new city: ");
        String cityMod = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumberMod = scanner.nextLine();

        // Update contact information
        current.contact.firstName = firstNameMod;
        current.contact.lastName = lastNameMod;
        current.contact.address = addressMod;
        current.contact.city = cityMod;
        current.contact.phoneNumber = phoneNumberMod;

        System.out.println("\nContact modified: " + current.contact.toString());
    } // end of modifyContact

    // Method to remove a contact from the phonebook
    public void removeContact(Scanner scanner) {
        Node current = head;
        Node previous = null;

        System.out.println("Enter last name of person you would like to remove:");
        String lastName = scanner.nextLine();

        while (current != null && !current.contact.lastName.toLowerCase().equals(lastName.toLowerCase())) {
            previous = current;
            current = current.next;
        } // end of while

        if (current == null) {
            System.out.println("\nContact not found.");
            return;
        } // end of if

        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        } // end of else

        System.out.println("\nContact removed: " + current.contact.toString());
    } // end of removeContact
} // end of Phonebook class

class Node {
    Contact contact;
    Node next;

    // Constructor to initialize a node with a contact
    public Node(Contact contact) {
        this.contact = contact;
        this.next = null;
    } // end of Node method
} //end of Node class

class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String phoneNumber;

    // Constructor to initialize contact information
    public Contact(String firstName, String lastName, String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    } // end of Contact contructor

    // Method to provide a formatted string representation of the contact
    @Override
    public String toString() {
        return "\nLast Name: " + lastName + "\nFirst Name: " + firstName + "\nAddress: " + address + "\nCity: " + city + "\nPhone Number: " + phoneNumber;
    } // end of String
} // end of Contact class
