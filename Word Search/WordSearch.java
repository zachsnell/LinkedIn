//Programmer: Zach Snell
//Class: CS 145
//Date: 10/17/2023
//Source: CS 141, Deitel/Deitel, ChatGPT
//Purpose: A word search puzzle that is created by user input. 


import java.util.Scanner;


public class WordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a scanner object
        WordGame gameBoard = new WordGame(24, 24);
        boolean cont = true;

        while (cont){
            char input = Intro(scanner);

            switch(input){
                case 'g':
                    gameBoard.generate(scanner);
                    break;
                case 'p':
                    gameBoard.printGame();
                    break;
                case 's':
                    gameBoard.printSolution();
                    break;
                case 'q':
                    cont = false;
                    break;
                default:
            } // end of switch case
        } // end of while loop

        System.out.println("Thanks for playing!");
    } // end of main

    public static char Intro (Scanner scanner){
            System.out.print(
                "Welcome to my word search generator! \n"+
                "This programs will allow you to generate your own word search puzzle \n"+
                "Please select and option: \n"+
                "Generate a new word search (g) \n"+
                "Print out your word search (p) \n" +
                "Show the solution to your word search (s) \n" +
                "Quit the program (q) \n"
            ); // end of print

            char input = scanner.next().charAt(0);

            return input;
        } // end of Intro
} // end of WordSearch