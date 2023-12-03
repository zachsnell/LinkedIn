//Programmer: Zach Snell
//Class: CS 145
//Date: 11/28/2023
//Source: CS 141, Deitel/Deitel, ChatGPT, Building Java Programs: A Back to Basics Approach, 5th edition
//Purpose: This program will create a binary search tree containing information that the user will input.

import java.util.Scanner;

public class PhonebookManagerBST {

    public static void main(String[] args) {
            // Initialize PhoneBookTree and Scanner
            PhoneBookTree phonebook = new PhoneBookTree();
            Scanner scanner = new Scanner(System.in);

            // Display ASCII art
            String asciiArt =
            " ____    __                              ____                    __\n" +
            "/\\  _`\\ /\\ \\                            /\\  _`\\                 /\\ \\ \n" +
            "\\ \\ \\L\\ \\ \\ \\___     ___     ___      __\\ \\ \\L\\ \\    ___     ___\\ \\ \\/'\\ \n" +
            " \\ \\ ,__/\\ \\  _ `\\  / __`\\ /' _ `\\  /'__`\\ \\  _ <'  / __`\\  / __`\\ \\ , < \n" +
            "  \\ \\ \\/  \\ \\ \\ \\ \\/\\ \\L\\ \\/\\ \\/\\ \\/\\  __/\\ \\ \\L\\ \\/\\ \\L\\ \\/\\ \\L\\ \\ \\ \\ \\`\\\n" +
            "   \\ \\_\\   \\ \\_\\ \\_\\ \\____/\\ \\_\\ \\_\\ \\____\\\\ \\____/\\ \\____/\\ \\____/\\ \\_\\ \\_\\\n" +
            "    \\/_/    \\/_/\\/_/\\/___/  \\/_/\\/_/\\/____/ \\/___/  \\/___/  \\/___/  \\/_/\\/_/";

            System.out.println(asciiArt);
            
            // Main program loop
            while (true) {
                // Display menu options
                System.out.println("\nMenu:");
                System.out.println("1. Add Contact");
                System.out.println("2. Display Contacts");
                System.out.println("3. Modify Contact");
                System.out.println("4. Remove Contact");
                System.out.println("5. Lookup Contact");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                // Get user input for menu choice
                int choice = scanner.nextInt();
                scanner.nextLine();

                // Switch statement to handle user's choice
                switch (choice) {
                    case 1:
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

                        System.out.print("Enter state: ");
                        String state = scanner.nextLine();

                        System.out.print("Enter zip: ");
                        String zip = scanner.nextLine();

                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();

                        // Create a new contact object
                        Contact contact = new Contact(firstName, lastName, address, city, phoneNumber, state, zip, email);

                        phonebook.add(contact);

                        System.out.println("\nContact added: " + contact.toString());

                        break;

                    case 2:
                        // Displaying all contacts
                        System.out.println("\nContacts:");
                        phonebook.DisplayData();

                        break;

                    case 3:
                        // Modifying a contact
                        phonebook.modifyContact(scanner);

                        break;
                    case 4:
                        //Removing a contact
                        System.out.println("Enter last name of person you would like to remove:");
                        String lastNameToRemove = scanner.nextLine();

                        phonebook.remove(new Contact(null, lastNameToRemove, null, null, null, null, null, null));
                        break;

                    case 5:
                        // Looking up a contact
                        System.out.println("Enter last name of person you would like to lookup:");
                        String lastNameToLookup = scanner.nextLine();
                        Contact contactFound = phonebook.lookup(lastNameToLookup);

                        if (contactFound == null){
                            System.out.println("Could not find contact with that last name");
                        }
                        else {
                            System.out.println(contactFound.toString());
                        }
                        break;

                    case 6:
                        // Exiting the program
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);

                    default:
                        // Handling invalid choices
                        System.out.println("Invalid choice. Please try again.");
                        break;
                } // end of switch
            } // end of while
        } // end of main
    } //end of PhonebookManager class
