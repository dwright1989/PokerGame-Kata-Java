package com.techreturners.EnumsAndConstants;

public enum CardUnicode {

    SPADES("♠", "\033[0;30m"),
    HEARTS("♥", "\033[0;91m"),
    DIAMONDS("♦", "\033[0;91m"),
    CLUBS("♣", "\033[0;30m");

    private final String code;
    private final String colour;

    CardUnicode(String code, String colour) {

        this.code = code;
        this.colour = colour;
    }

    public String getCode() {
        return code;
    }

    public String getColour(){return colour;}
}

