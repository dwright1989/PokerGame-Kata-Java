package com.techreturners;

import java.util.List;

public class Dealer {

    private Deck deck;

    public Hand dealSetHand(List<Card> cards){
        return new Hand(cards);
    }

    public Hand dealHand(){
        return null;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
