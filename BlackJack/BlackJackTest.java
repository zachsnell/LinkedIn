//Programmer: Zach Snell
//Class: CS 145
//Date: 10/17/2023
//Source: CS 141, Deitel/Deitel, ChatGPT
//Purpose: To run a program designed to play the card game BlackJack between
// the user and an automated dealer.
//Note: Test class

import java.util.Scanner;

public class BlackJackTest {

   public static void main(String[] args) {
     
      //For User input
      Scanner Scanner = new Scanner(System.in);
      
      //Variables for the game
      BlackJackDeck Deck;
      BlackJackHand PlayerHand;
      BlackJackHand DealerHand;

      // Play Blackjack loop
      while (BlackJackGame.PromptUserForPlay(Scanner)) {
         // Get new deck and shuffle
         Deck = new BlackJackDeck();
         Deck.shuffle();

         // Deal cards to player and dealer
         PlayerHand = new BlackJackHand(false, Deck.dealHand(2));
         DealerHand = new BlackJackHand(true, Deck.dealHand(2));

         //Determine if player has busted
         boolean playerBust = BlackJackGame.PlayerTurn(Scanner, Deck, PlayerHand);

         //Determine if dealer needs to play and if dealer has busted
         boolean dealerBust = false;;

         if (!playerBust) {
            dealerBust = BlackJackGame.DealerTurn(Scanner, Deck, DealerHand);
         } // end of if

         //Compute and display game results
         BlackJackGame.ComputeResults(dealerBust, playerBust, DealerHand, PlayerHand);
      } // end of while

      BlackJackGame.QuitMessage();
   } // end of main
} // end of BlackJackTest