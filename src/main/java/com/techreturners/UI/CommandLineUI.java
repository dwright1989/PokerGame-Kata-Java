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
        System.out.print(CardUnicode.SPADES.getColour() + "" +CardUnicode.SPADES.getCode() + " ");
        System.out.print(CardUnicode.HEARTS.getColour() + "" +CardUnicode.HEARTS.getCode()+ " ");
        System.out.print(CardUnicode.CLUBS.getColour() + "" +CardUnicode.CLUBS.getCode()+ " ");
        System.out.print(CardUnicode.DIAMONDS.getColour() + "" + CardUnicode.DIAMONDS.getCode()+ " ");
        System.out.println("\033[0m");
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
            System.out.print(CardUnicode.valueOf(card.getSuit().name()).getColour());
            System.out.print("+-----"+CardUnicode.valueOf(card.getSuit().name()).getCode()+"-----+  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print(CardUnicode.valueOf(card.getSuit().name()).getColour());
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()).getCode() + "         " + CardUnicode.valueOf(card.getSuit().name()).getCode() + "|  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print(CardUnicode.valueOf(card.getSuit().name()).getColour());
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()).getCode() + "         " + CardUnicode.valueOf(card.getSuit().name()).getCode() + "|  ");
        }
        System.out.println();
        for (Card card : cards) {
            int cardValue = card.getValue().getCardValue();
            System.out.print(CardUnicode.valueOf(card.getSuit().name()).getColour());
            if(cardValue<=9){
                System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()).getCode() +   "    " + card.getValue().getCardValue() + "    " + CardUnicode.valueOf(card.getSuit().name()).getCode() + "|  ");
            }else if(cardValue==10){
                System.out.print("|"  + CardUnicode.valueOf(card.getSuit().name()).getCode() +   "    "      + card.getValue().getCardValue() + "   " + CardUnicode.valueOf(card.getSuit().name()).getCode() + "|  ");
            }else{
                System.out.print("|"  + CardUnicode.valueOf(card.getSuit().name()).getCode() +   "    "  + card.getValue().toString().charAt(0) + "    " + CardUnicode.valueOf(card.getSuit().name()).getCode() + "|  ");
            }

        }
        System.out.println();
        for(Card card : cards){
            System.out.print(CardUnicode.valueOf(card.getSuit().name()).getColour());
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()).getCode() + "         " + CardUnicode.valueOf(card.getSuit().name()).getCode() + "|  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print(CardUnicode.valueOf(card.getSuit().name()).getColour());
            System.out.print("|" + CardUnicode.valueOf(card.getSuit().name()).getCode() + "         " + CardUnicode.valueOf(card.getSuit().name()).getCode() + "|  ");
        }
        System.out.println();
        for(Card card : cards){
            System.out.print(CardUnicode.valueOf(card.getSuit().name()).getColour());
            System.out.print("+-----"+CardUnicode.valueOf(card.getSuit().name()).getCode()+"-----+  ");
        }
        System.out.println();
    }
}
