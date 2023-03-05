package com.techreturners;

import com.techreturners.UI.CommandLineUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PokerGame game = new PokerGame();
        Scanner scanner = new Scanner(System.in);
        CommandLineUI GUI = new CommandLineUI(scanner, game);
    }
}

