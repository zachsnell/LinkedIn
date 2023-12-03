//Programmer: Zach Snell
//Class: CS 145
//Date: 10/17/2023
//Source: CS 141, Deitel/Deitel, ChatGPT
//Purpose: To run a program designed to play the card game BlackJack between
// the user and an automated dealer.
//Note: BlackJackGame where we are asked if we want to play, contains game mechanics,
//hit and stay, dealersturn and results from the gameplay.

import java.util.Scanner;

public class BlackJackGame {
      //Prompt to start the game
      public static boolean PromptUserForPlay(Scanner scanner) {
      System.out.print(
         "Welcome to BlackJack! \n"+
         "Play a game of BlackJack (p) \n" +
         "Quit the program (any other key) \n"
      );

      char input = scanner.next().charAt(0);

      if (input == 'p') {
         return true;
      }//end of if
      else {
         return false;
      } //end of else
   } //end of PromptUserForPlay

   public static void QuitMessage() {
      System.out.print(
         "Thanks for playing! \n"
      );
   } // end of QuitMessage

   //Players turn
   public static boolean PlayerTurn(Scanner scanner, BlackJackDeck Deck, BlackJackHand Hand) {
      boolean playerTurn = true;

      while(playerTurn) {
         
         System.out.print(
            "Hit (h)\n" +
            "Stand (s) \n"
         );

         char input = scanner.next().charAt(0);

         if (input == 'h') {
            Hand.Hit(Deck.dealCard());

            if (Hand.Bust()) {
               return true;
            } //end of if
         } //end of if
         else if (input == 's') {
            playerTurn = false;
         } //end of else if
      } // end of while

      return false;
   } // end of PlayerTurn

   //Dealers turn
   public static boolean DealerTurn(Scanner scanner, BlackJackDeck Deck, BlackJackHand Hand) {
      int total;
      boolean continuePlaying = true;

      while (continuePlaying) {
         total = Hand.CountValue();
         if (total >=17) {
            Hand.PrintHand(true);
            if (Hand.Bust()) {
               return true;
            } // end of if
            continuePlaying = false;
            
         }//end of if
         else if (total <= 16) {
            Hand.Hit(Deck.dealCard());
         }//end of else if
      }//end of while

      return false;
   }//end of DealerTurn

   public static void ComputeResults(boolean dealerBust, boolean playerBust, BlackJackHand DealerHand, BlackJackHand PlayerHand) {
      //If player busts they lose
      if (playerBust) {
         System.out.print(
            "You have lost! \n"
         );
      } // end of if
      
      //If dealer busts player wins
      else if (dealerBust) {
         System.out.print(
            "You have won! \n"
         );
      } // end of else if
      
      //If dealers hand is larger than players hand, player loses
      else {
         if (DealerHand.CountValue() > PlayerHand.CountValue()) {
            System.out.print(
               "You have lost! \n"
            );
         } // end of if

         //If dealers hand and players hand are the same value, tie
         else if (DealerHand.CountValue() == PlayerHand.CountValue()) {
            System.out.print(
               "Its a tie! \n"
            );
         } // end of else if

         //If not a tie and dealers hand is smaller, player wins
         else {
            System.out.print(
               "You have won! \n"
            );
         } // end of else
      } // end of else
   } // end of ComputeResults
} // end of BlackJackGame
