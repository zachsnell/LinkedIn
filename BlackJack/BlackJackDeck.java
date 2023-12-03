//Programmer: Zach Snell
//Class: CS 145
//Date: 10/17/2023
//Source: CS 141, Deitel/Deitel, ChatGPT
//Purpose: To run a program designed to play the card game BlackJack between
// the user and an automated dealer.
//Notes: DeckOfCards class represents a deck of playing cards.

import java.security.SecureRandom;
import java.util.*;

public class BlackJackDeck {
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

   private Stack<BlackJackCard> deck = new Stack<>(); // Card references
   
   private int currentCard = 0; // index of next Card to be dealt (0-51)

   // constructor fills deck of Cards
   public BlackJackDeck() {
      for (int suitCount = 0; suitCount <= Suit.SPADES.ordinal(); suitCount++) {
         for (int faceCount = 0; faceCount <= Face.ACE.ordinal(); faceCount++) {

            deck.add(suitCount * 13 + faceCount, new BlackJackCard(Face.values()[faceCount], Suit.values()[suitCount]));
         } //end of for       
      } // end of for
   } // end of DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.size(); first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Collections.swap(deck, first, second);
      } // end of for
   } // end of shuffle

   // deal one Card
   public BlackJackCard dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.size()) {
         return deck.get(currentCard++); // return current Card in array
      } //end of if
      else {
         return null; // return null to indicate that all Cards were dealt
      } //end of else
   } // end of dealcard

   // deal one Hand
   public Stack<BlackJackCard> dealHand(int numCards) {
      Stack<BlackJackCard> hand = new Stack<BlackJackCard>();

      for (int i = 0; i < numCards; i++) {
         hand.add(i, dealCard());
      } //end of for

      return hand;
   } // end of dealHand
} //end of DeckOfCards class