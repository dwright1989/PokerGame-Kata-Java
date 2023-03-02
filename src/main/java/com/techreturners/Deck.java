package com.techreturners;

import com.techreturners.EnumsAndConstants.CardSuit;
import com.techreturners.EnumsAndConstants.CardValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for(CardSuit suit: CardSuit.values()){
            for(CardValue cardValue: CardValue.values()){
                Card card = new Card(cardValue, suit);
                cards.add(card);
            }
        }

    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffleCards(){
        Collections.shuffle(cards);
    }

    public void printCards(){
        for(Card card: cards){
            System.out.println("Card: " + card.getValue() + "" + card.getSuit());
        }
    }

}
