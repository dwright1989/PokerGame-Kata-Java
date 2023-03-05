package com.techreturners.UI;

import com.techreturners.PokerGame;

import java.util.Scanner;

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
        System.out.println("\nPlayer 2 - Please enter your name:");
        String player2name = scanner.next();
        game.setPlayersByNames(player1name, player2name);
    }

}
