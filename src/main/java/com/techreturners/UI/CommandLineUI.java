package com.techreturners.UI;

import com.techreturners.*;
import com.techreturners.EnumsAndConstants.*;
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
        game.startGame();
        System.out.println(Colour.MAIN_TEXT_COLOUR);
        System.out.println(game.getPlayers()[0].getName()+"'s hand is: ");
        System.out.println(getUserFriendlyHandType(game.getPlayers()[0].getHand().getResult()));
        printHand(game.getPlayers()[0].getHand());
        System.out.println(Colour.MAIN_TEXT_COLOUR);
        System.out.println(game.getPlayers()[1].getName()+"'s hand is: ");
        System.out.println(getUserFriendlyHandType(game.getPlayers()[1].getHand().getResult()));
        printHand(game.getPlayers()[1].getHand());
        displayWinner();
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
        System.out.println(Colour.RESET);
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
    }

    private void displayWinner() {
        System.out.println(Colour.MAIN_TEXT_COLOUR);
        String result = getUserFriendlyHandType(game.getWinner().getHand().getResult());
        System.out.println("The winner is: " + game.getWinner().getName() + " with " + result);
    }

    private String getUserFriendlyHandType(HandType handtype){
        String result = "";
        switch(handtype){
            case HIGH_CARD -> result = "High card";
            case PAIR -> result = "Pair";
            case TWO_PAIRS -> result = "Two pairs";
            case THREE_OF_A_KIND -> result = "Three of a kind";
            case STRAIGHT -> result = "Straight";
            case FLUSH -> result = "Flush";
            case FULL_HOUSE -> result = "Full house";
            case FOUR_OF_A_KIND -> result = "Four of a kind";
            case STRAIGHT_FLUSH -> result = "Straight flush";
            case ROYAL_FLUSH -> result = "Royal flush";
            default -> result = "No combination";
        }
        return result;
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
