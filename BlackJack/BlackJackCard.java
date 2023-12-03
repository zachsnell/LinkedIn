//Programmer: Zach Snell
//Class: CS 145
//Date: 10/17/2023
//Source: CS 141, Deitel/Deitel, ChatGPT
//Purpose: To run a program designed to play the card game BlackJack between
// the user and an automated dealer.
//Note: Card class represents a playing card.

public class BlackJackCard implements Comparable<BlackJackCard> {
   private final Face face; // face of card ("Ace", "Deuce", ...)
   private final Suit suit; // suit of card ("Hearts", "Diamonds", ...)

   // two-argument constructor initializes card's face and suit
   public BlackJackCard(Face cardFace, Suit cardSuit) {
      this.face = cardFace; // initialize face of card
      this.suit = cardSuit; // initialize suit of card
   } // end of constructor

   // return String representation of Card
   public String toString() {             
      return face + " of " + suit;        
   } //end of toString               

   public Face getFace() {
     return this.face;
  } // end of getFace 

  public Suit getSuit() {
     return this.suit;
  } // end of getSuit

   @Override
   public int compareTo(BlackJackCard o) {
      return this.face.compareTo(o.face);
   } // end of compareTo
} // end of Card class

// enum for Face values
enum Face {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
} // end of enum Face

// enum for Suit values
enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
} // end of enum Suit