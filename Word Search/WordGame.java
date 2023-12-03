//Programmer: Zach Snell
//Class: CS 145
//Date: 10/17/2023
//Source: CS 141, Deitel/Deitel, ChatGPT
//Purpose: A word search puzzle that is created by user input. 

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
    char placeholder = '-';
    char [][] wordGame;
    char [][] wordGameSolution;
    int x = 0;
    int y = 0;

    static Random rand = new Random(); // Randomize starting point for where word is placed

    public WordGame(int rowCount, int colCount)
    {
        wordGame = new char[rowCount][colCount];  //2D array of characters
        wordGameSolution = new char[rowCount][colCount];  //2D array of characters
        x = rowCount;
        y = colCount;
    }

    public void printGame() {
        for (int r = 0; r < x; r++){
            for (int c = 0; c < y; c++) {
                System.out.printf("%4s",wordGame[r][c]);
            } // end of for
            System.out.println("");;
        } // end of for 
    } // end of printgame

    public void printSolution() {
        for (int r = 0; r < x; r++){
            for (int c = 0; c < y; c++) {
                System.out.printf("%4s",wordGameSolution[r][c]);
            } // end of for
            System.out.println("");;
        } // end of for  
    } // end of printsolution

    public char[][] generate(Scanner scanner) {
        ArrayList<String> words = new ArrayList<String>();

        //Blank our 2D array out with X
        for (int r = 0; r < x; r++){
            for (int c = 0; c < y; c++) {
                wordGame[r][c] = placeholder;
                wordGameSolution[r][c] = placeholder;
            } // end of for 
        } // end of for

        //Take in words from the user
        while(words.size() < 5) {
            System.out.println("Please enter word number " + (words.size() + 1) + " :");

            String word = scanner.next();

            if (word.length() > 8) {
                System.out.println("Words must be less or equal 8 characters, please enter a shorter word. Sorry!");
            } 
            else {
                words.add(words.size(), word.toUpperCase());
            }
        } //end of while

        //Insert words into our 2D character array
        while(words.size() > 0) {
            String word = words.get(0);
            int x = rand.nextInt(this.x);
            int y = rand.nextInt(this.y);
            boolean reverse = rand.nextBoolean();
            Direction dir = Direction.values()[rand.nextInt(Direction.values().length)];
            boolean wordPlaced = false;

            //Place our word somewhere
            switch (dir) {
                case vertical:
                    wordPlaced = placeVertical(word, x, y, reverse);
                    break;
                case horizontal:
                    wordPlaced = placeHorizontal(word, x, y, reverse);
                    break;
                case diagDown:
                    wordPlaced = placeDiagDown(word, x, y, reverse);
                    break;
                case diagUp:
                    wordPlaced = placeDiagUp(word, x, y, reverse);
                    break;
            } // end of switch case

            //Remove successfully placed word from list of words to place
            if (wordPlaced) {
                words.remove(0);
            } // end of if
        } //end of while loop

        //Replace placeholder '-' with randomized words
        for (int r = 0; r < x; r++){
            for (int c = 0; c < y; c++) {
                if (wordGame[r][c] == placeholder) {
                    char rChar = (char)(rand.nextInt(26) + 'A');
                    wordGame[r][c] = rChar;
                } // end of if
            } // end of for 
        } // end of for 

        return wordGame;
    } // end of generate

    boolean placeVertical(String word, int x, int y, boolean reverse) {
        boolean letterConflict;
        int wordSize = word.length();

        //Check if the word fits on the column
        if (x + wordSize > this.x)
        {
            return false;
        }

        //Check if a character is in the way
        letterConflict = false;
        for(int i = 0; i < wordSize; i++){
            if (wordGameSolution[i + x][y] != word.charAt(i) && wordGameSolution[i + x][y] != placeholder){
                letterConflict = true;
                break;
            } // end of if
        } // end of for

        //Place word
        if (!letterConflict) {
            for(int i = 0; i < wordSize; i++){
                if (reverse) {
                    wordGame[i + x][y] = word.charAt(wordSize - i - 1);
                    wordGameSolution[i + x][y] = word.charAt(wordSize - i - 1);
                } // end of if
                else {
                    wordGame[i + x][y] = word.charAt(i);
                    wordGameSolution[i + x][y] = word.charAt(i);
                } // end of else
            } // end of for

            return true;
        } // end of if

        return false;
    } // end of placevertical

    boolean placeHorizontal(String word, int x, int y, boolean reverse) {
        boolean letterConflict;
        int wordSize = word.length();

        //Check if the word fits on the row
        if (y + wordSize > this.y) {
            return false;
        } // end of if

        //Check if a character is in the way
        letterConflict = false;
        for(int i = 0; i < wordSize; i++){
            if (wordGameSolution[x][i + y] != word.charAt(i) && wordGameSolution[x][y + i] != placeholder){
                letterConflict = true;
                break;
            } // end of if
        } // end of for

        //Place word
        if (!letterConflict) {
            for(int i = 0; i < wordSize; i++){
                if (reverse) {
                    wordGame[i + y][x] = word.charAt(wordSize - i - 1);
                    wordGameSolution[i + y][x] = word.charAt(wordSize - i - 1);
                } // end of if
                else {
                    wordGame[i + y][x] = word.charAt(i);
                    wordGameSolution[i + y][x] = word.charAt(i);
                } // end of else
            } //end of for

            return true;
        } // end of if
        
        return false;
    } // end of placehorizontal

    boolean placeDiagDown(String word, int x, int y, boolean reverse) {
        boolean letterConflict;
        int wordSize = word.length();

        //Check if the word fits on the row
        if (y + wordSize > this.y || x + wordSize > this.x) {
            return false;
        } // end of if

        //Check if a character is in the way
        letterConflict = false;
        for(int i = 0; i < wordSize; i++){
            if (wordGameSolution[i + x][i + y] != word.charAt(i) && wordGameSolution[x + i][y + i] != placeholder){
                letterConflict = true;
                break;
            } //end of if
        } //end of for

        //Place word
        if (!letterConflict) {
            for(int i = 0; i < wordSize; i++){
                if (reverse) {
                    wordGame[i + x][i + y] = word.charAt(wordSize - i - 1);
                    wordGameSolution[i + x][i + y] = word.charAt(wordSize - i - 1);
                } //end of if
                else {
                    wordGame[i + x][i + y] = word.charAt(i);
                    wordGameSolution[i + x][i + y] = word.charAt(i);
                } //end of else
            } //end of for

            return true;
        } // end of if
        
        return false;
    } // end of placeDiagDown

       boolean placeDiagUp(String word, int x, int y, boolean reverse) {
        boolean letterConflict;
        int wordSize = word.length();

        //Check if the word fits on the row
        if (y + wordSize > this.y || x - wordSize < 0) {
            return false;
        } // end of if

        //Check if a character is in the way
        letterConflict = false;
        for(int i = 0; i < wordSize; i++){
            if (wordGameSolution[x - i][y + i] != word.charAt(i) && wordGameSolution[x - i][y + i] != placeholder){
                letterConflict = true;
                break;
            } // end of if
        } // end of for

        //Place word
        if (!letterConflict) {
            for(int i = 0; i < wordSize; i++){
                if (reverse) {
                    wordGame[x - i][i + y] = word.charAt(wordSize - i - 1);
                    wordGameSolution[x - i][i + y] = word.charAt(wordSize - i - 1);
                } // end of if 
                else {
                    wordGame[x - i][i + y] = word.charAt(i);
                    wordGameSolution[x - i][i + y] = word.charAt(i);
                } // end of else
            } // end of for

            return true;
        } // end of if
        
        return false;
    } // end of placeDiagUp
} // end of WordGame

enum Direction {
    vertical,
    horizontal,
    diagUp,
    diagDown
}
