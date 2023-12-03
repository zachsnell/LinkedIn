//Programmer: Zach Snell, Nea Moi Spix, Sarai Ayon
//Class: CS& 145
//Date: 9/26/2023
//Source: CS 141, Zach Snell, Nea Moi Spix, Sarai Ayon, Deitel/Deitel
//Purpose: To run a guessing game between 1-100 and play the game as many times as the user wants, then to have different stats print out when they dont want to play anymore.
//Extra Credit: N/A


import java.util.Scanner;

public class ZSNSSAGuessingGame {

      public static final int MAX = 100; // MAX is the changable so that the game can be any number you want it to be

   public static void main(String[] args) {
      intro(); // Calls for the Introduction method to run
       
      // Play as many games as the user wants
      int totalGames = 0;
      int totalGuesses = 0;
      int bestGame = Integer.MAX_VALUE;
      boolean playAgain = true;
      Scanner input = new Scanner(System.in);
   
      while (playAgain) {
         int guesses = playGame();
         totalGames++;
         totalGuesses += guesses;
         bestGame = Math.min(bestGame, guesses);
      
         // Ask the user if they want to play again prompt
         System.out.print("Do you want to play again? ");
         String answer = input.next();
      
         // Check the user's response if anything that starts with a y then it restarts the game.
         if (!answer.toLowerCase().startsWith("y")) {
            playAgain = false;
         }
      }
        
      // Report overall results of total games played, total guesses, guess/game and finally best game.
      reportResults(totalGames, totalGuesses, bestGame);
   }

   // Method for the introduction of how to play the game
   public static void intro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and " + MAX + " and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you whether the right answer is higher or lower");
      System.out.println("than your guess.\n");
   }

   // Method to play one game with the user
   public static int playGame() {
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      int answer = (int) (Math.random() * MAX) + 1;
      int guess;
      int numGuesses = 0;
      Scanner input = new Scanner(System.in);
   
      //System.out.println("The Random Number is: " + answer); //Cheat
      System.out.print("Your guess? "); //Prompt for user input of their guess between 1-MAX
      guess = input.nextInt();
      numGuesses++;
          
      while (guess != answer){
         if (guess < answer) {
            System.out.println("It's higher.");
            guess = input.nextInt();
            numGuesses++;
         } else {
            System.out.println("It's lower.");
            guess = input.nextInt();
            numGuesses++;
         } 
      }  
      System.out.println("You got it right in " + numGuesses + " guesses");
      return numGuesses;
   }

   // Method to report overall results to the user
   public static void reportResults(int totalGames, int totalGuesses, int bestGame) {
      double averageGuesses = (double) totalGuesses / totalGames;
   
      System.out.println("\nOverall results:");
      System.out.println("  total games = " + totalGames);
      System.out.println("  total guesses = " + totalGuesses);
      System.out.printf("  guesses/game = %.1f\n", averageGuesses);
      System.out.println("  best game = " + bestGame);
   }
}
