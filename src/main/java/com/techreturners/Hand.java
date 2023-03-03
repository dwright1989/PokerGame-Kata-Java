package com.techreturners;

import com.techreturners.EnumsAndConstants.HandType;

import java.util.List;

public class Hand {
    private List<Card> cards;
    private HandType result = HandType.NO_COMBO;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public HandType getResult() {
        return result;
    }

    public void setResult(HandType result) {
        this.result = result;
    }

    public void sortHandNumerically(){
        cards.sort((current, next) -> {
            Integer currentValue = current.getValue().getCardValue();
            Integer nextValue = next.getValue().getCardValue();
            return currentValue.compareTo(nextValue);
        });
    }
}
