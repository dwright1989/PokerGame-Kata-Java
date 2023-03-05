package com.techreturners.UI;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.CardUnicode;
import com.techreturners.EnumsAndConstants.Constants;
import com.techreturners.Hand;
import com.techreturners.PokerGame;

import java.util.List;
import java.util.Scanner;

import static com.techreturners.UI.UIValidation.isValidName;

public class CommandLineUI {

    private Scanner scanner;
    private PokerGame game;

    public CommandLineUI(Scanner scanner, PokerGame game){
        this.scanner = scanner;
        this.game = game;
        init();
    }

    public void init(){
        getPlayerDetails();
        displayWelcome();
        printHand(game.getPlayers()[0].getHand());
        printHand(game.getPlayers()[1].getHand());
    }

    private void displayWelcome() {
        System.out.println("Welcome " + game.getPlayers()[0].getName() + " and " + game.getPlayers()[1].getName());
        System.out.println("Dealing cards...");
    }

    public void getPlayerDetails(){
        System.out.println("\nWelcome to Poker Game.");
        System.out.println(CardUnicode.SPADES + " " + CardUnicode.CLUBS + " " + CardUnicode.HEARTS + " " + CardUnicode.DIAMONDS);
        System.out.println("\nPlayer 1 - Please enter your name:");
        String player1name = scanner.next();
        while(!isValidName(player1name)){
            System.out.println("Please enter a valid name");
            player1name = scanner.next();
        }
        System.out.println("\nPlayer 2 - Please enter your name:");
        String player2name = scanner.next();
        while(!isValidName(player2name)){
            System.out.println("Please enter a valid name");
            player2name = scanner.next();
        }
        game.setPlayersByNames(player1name, player2name);
        game.startGame();
    }


    public void printHand(Hand hand){
        List<Card> cards = hand.getCards();
        for(Card card : cards){
            System.out.print("+-----"+CardUnicode.valueOf(card.getSuit().name())+"-----+  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()) + "         " + CardUnicode.valueOf(card.getSuit().name()) + "|  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()) + "         " + CardUnicode.valueOf(card.getSuit().name()) + "|  ");
        }
        System.out.println();
        for (Card card : cards) {
            int cardValue = card.getValue().getCardValue();
            if(cardValue<=9){
                System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()) +   "    " + card.getValue().getCardValue() + "    " + CardUnicode.valueOf(card.getSuit().name()) + "|  ");
            }else if(cardValue==10){
                System.out.print("|"  + CardUnicode.valueOf(card.getSuit().name()) +   "    "      + card.getValue().getCardValue() + "   " + CardUnicode.valueOf(card.getSuit().name()) + "|  ");
            }else{
                System.out.print("|"  + CardUnicode.valueOf(card.getSuit().name()) +   "    "  + card.getValue().toString().charAt(0) + "    " + CardUnicode.valueOf(card.getSuit().name()) + "|  ");
            }

        }
        System.out.println();
        for(Card card : cards){
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()) + "         " + CardUnicode.valueOf(card.getSuit().name()) + "|  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()) + "         " + CardUnicode.valueOf(card.getSuit().name()) + "|  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print("+-----"+CardUnicode.valueOf(card.getSuit().name())+"-----+  ");
        }
        System.out.println();
    }
}
