package com.techreturners.EnumsAndConstants;

public enum CardUnicode {

    SPADES("♠"),
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣");

    private final String code;

    CardUnicode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}

