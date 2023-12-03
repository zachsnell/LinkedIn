//Programmer: Zach Snell
//Class: CS 145
//Date: 11/28/2023
//Source: CS 141, Deitel/Deitel, ChatGPT, Building Java Programs: A Back to Basics Approach, 5th edition
//Purpose: This program will create a binary search tree containing information that the user will input. 

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PhoneBookTree {
    private PhonebookNode overallRoot;

    // Method to display all contacts in the phonebook
    public void DisplayData() {
        DisplayData(overallRoot);
        System.out.println();   // end the line of output
    } // end of DisplayData

    // Helper method for recursively displaying contacts
    private void DisplayData(PhonebookNode root) {

        if (root != null) {
            // recursive case: print left, center, right
            DisplayData(root.left);
            System.out.print(root.data.toString() + " ");
            DisplayData(root.right);
        }
    } // end of DisplayData

    // Method to modify details of a contact in the phonebook
    public void modifyContact(Scanner scanner) {
        System.out.println("Please enter lastname of person you wish to modify details for:");
        String lastNameSearch = scanner.nextLine();
        Contact person = lookup(lastNameSearch);

        if (person == null) {
            System.out.println("Could not find person.");
            return;
        }

        System.out.println("Please enter the details you would like to change, leave blank if you do not wish to change it.");

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

        System.out.print("Enter phone email: ");
        String email = scanner.nextLine();

        // Create a new contact object with modified details
        Contact contact = new Contact(
            "".equals(firstName)? person.firstName: firstName, 
            "".equals(lastName)? person.lastName: lastName, 
            "".equals(address)? person.address: address, 
            "".equals(city)? person.city: city, 
            "".equals(phoneNumber)? person.phoneNumber: phoneNumber,
            "".equals(state)? person.state: state,
            "".equals(zip)? person.zip: zip,
            "".equals(email)? person.email: email);

        remove(person);
        add(contact);

        System.out.print("Contact modified successfully.");
    } // end of modifyContact

    // Method to look up a contact by last name
    public Contact lookup(String value) {
        return lookup(overallRoot, value);
    } // end of lookup

    // Helper method for recursively looking up a contact by last name
    private Contact lookup(PhonebookNode root, String value) {
        if (root == null) {
            return null;
        } else if (root.data.lastName.compareTo(value) == 0) {
            return root.data;
        } else if (root.data.lastName.compareTo(value) < 0) {
            return lookup(root.left, value);
        } else {   // root.data < value
            return lookup(root.right, value);
        }
    } // end of lookup

    // Adds the given value to this BST in sorted order.
    public void add(Contact value) {
        overallRoot = add(overallRoot, value);
    } // end of add

    private PhonebookNode add(PhonebookNode root, Contact value) {
        if (root == null) {
            root = new PhonebookNode(value);
        } else if (root.data.lastName.compareTo(value.lastName) < 0) {
            root.left = add(root.left, value);
        } else if (root.data.lastName.compareTo(value.lastName) >= 0) {
            root.right = add(root.right, value);
        }

        return root;
    } // end of add

    // Returns the minimum value from this BST.
    // Throws a NoSuchElementException if the tree is empty.
    public Contact getMin() {
        if (overallRoot == null) {
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    } // end of getMin

    private Contact getMin(PhonebookNode root) {
        if (root.left == null) {
            return root.data;
        } else {
            return getMin(root.left);
        }
    } // end of getMin

    // Removes the given value from this BST, if it exists.
    public void remove(Contact value) {
        overallRoot = remove(overallRoot, value);
    } // end of remove

    private PhonebookNode remove(PhonebookNode root, Contact value) {
        if (root == null) {
            return null;
        } else if (root.data.lastName.compareTo(value.lastName) < 0) {
            root.left = remove(root.left, value);
        } else if (root.data.lastName.compareTo(value.lastName) > 0) {
            root.right = remove(root.right, value);
        } else {  
            if (root.right == null) {
                return root.left;    
            } else if (root.left == null) {
                return root.right;   
            } else {
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            } 
        }
        return root;
    } // end of remove
} // end of phoneBookTree class

class PhonebookNode {
    public Contact data;
    public PhonebookNode left;
    public PhonebookNode right;
        
    // Constructs a leaf node with the given data.
    public PhonebookNode(Contact data) {
        this(data, null, null);
    } // end of phonebookNode method
                
    // Constructs a branch node with the given data and links.
    public PhonebookNode(Contact data, PhonebookNode left, PhonebookNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    } // end of PhonebookNode method
} // end of PhonebookNode class

class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String phoneNumber;
    String state;
    String zip;
    String email;

    // Constructor to initialize contact information
    public Contact(String firstName, String lastName, String address, String city, String phoneNumber, String state, String zip, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.state = state;
        this.zip = zip;
        this.email = email;

    } // end of Contact contructor

    // Method to provide a formatted string representation of the contact
    @Override
    public String toString() {
        return "\nLast Name: " + lastName + 
        "\nFirst Name: " + firstName + 
        "\nAddress: " + address + 
        "\nCity: " + city + 
        "\nPhone Number: " + phoneNumber + 
        "\nState: " + state + 
        "\nZip: " + zip + 
        "\nEmail: " + email + "\n";
    } // end of String
} // end of Contact
