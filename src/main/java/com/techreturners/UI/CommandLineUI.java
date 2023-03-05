package com.techreturners.UI;

import com.techreturners.PokerGame;

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
    }

    public void getPlayerDetails(){
        System.out.println("\nWelcome to Poker Game.");
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

}
