package com.techreturners.EnumsAndConstants;

public enum HandType {
    NO_COMBO(0),
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9),

    ROYAL_FLUSH(10);

    private int handValue;

    private HandType (int value) {this.handValue=value;}
    public int getHandValue(){return handValue;}
}
