//Programmer: Zach Snell
//Class: CS 145
//Date: 10/31/2023
//Source: CS 141, Deitel/Deitel, ChatGPT, Building Java Programs: A Back to Basics Approach, 5th edition
//Purpose: To run a program that allows the user to add, remove, modify and eventually print out contacts for a phonebook.


import java.util.Scanner;

public class PhonebookManager {

    public static void main(String[] args) {
            Phonebook phonebook = new Phonebook();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Contact");
                System.out.println("2. Display Contacts");
                System.out.println("3. Modify Contact");
                System.out.println("4. Remove Contact");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        phonebook.addContact(scanner);
                        phonebook.sortContacts();
                        break;

                    case 2:
                        phonebook.sortContacts();
                        phonebook.displayContacts();
                        break;

                    case 3:
                        phonebook.modifyContact(scanner);
                        break;

                    case 4:
                        phonebook.removeContact(scanner);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                } // end of switch
            } // end of while
        } // end of main
    } //end of PhonebookManager class
