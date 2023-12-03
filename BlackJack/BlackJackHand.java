//Programmer: Zach Snell
//Class: CS 145
//Date: 10/17/2023
//Source: CS 141, Deitel/Deitel, ChatGPT
//Purpose: To run a program designed to play the card game BlackJack between
// the user and an automated dealer.
//Notes: BlackJackHand where we find out which cards we have and if we can hit or not

import java.util.*;

public class BlackJackHand {
   private Stack<BlackJackCard> Hand;
   private Boolean IsDealer;

   // Constructor
   public BlackJackHand(Boolean Dealer, Stack<BlackJackCard> Cards) {
      IsDealer = Dealer;
      Hand = Cards;
      
      PrintHand(false);
   } //end of BlackJackHand

   //Method to print the hand
   public void PrintHand(boolean fin) {
      if (IsDealer) {
         System.out.println("----- Dealer -----");
      } //end of if
      else { 
         System.out.println("----- Player -----");
      } //end of else
      
      for (int i = 0; i < Hand.size(); i++) {
         System.out.println(Hand.get(i));

         if (i == 0 && IsDealer && !fin) {
            System.out.println("Card face down");
            break;
         } // end of if
      } // end of for
      System.out.println();
   } // end of PrintHand

   //Method to calculate the total value of the hand
   public int CountValue() {
      int totalValue = 0;

      //Loop through each card in the hand
      for (BlackJackCard blackJackCard : Hand) {
         int ordinal = blackJackCard.getFace().ordinal();
         
         if (ordinal < 9) {
            totalValue += ordinal + 2;
         } // end of if
         else if (ordinal > 8 && ordinal < 12) {
            totalValue += 10;
         } //end of else if
         else {
            if (totalValue + 11 > 21) {
               totalValue += 1;
            } //end of if
            else {
               totalValue += 11;
            } // end of else
         }//end of else
      } //end of for

      return totalValue;
   } // end of CountValue

   //Method to add a card to the hand (hit)
   public void Hit(BlackJackCard card) {
      Hand.push(card); //Add the card to the hand
      Collections.sort(Hand, null); // Sort the hand 
      PrintHand(false); // Print update hand
   } // end of Hit

   //Method to see if hand has gone bust
   public boolean Bust() {
      int count = CountValue(); //Calculate the total value

      if (count <= 21) { 
         return false; // Hand is not bust
      } // end of if
      else {
         if (IsDealer) {
            System.out.println("Dealer has gone bust!");
         } // end of if
         else {
            System.out.println("You have gone bust!");
         } // end of else
         
         return true;
      } // end of else
   } //end of Bust
} // end of Hand method
