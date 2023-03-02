package com.techreturners;

public class Card {
    private String suit;
    private String value;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }
}
