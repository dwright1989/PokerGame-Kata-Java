package com.techreturners;

import java.util.ArrayList;
import java.util.List;

public class HandEvaluator {
    /*
    Could be changed to array of hands to upscale to a 3+ player game
     */
    public Hand compareHands(Hand one, Hand two){
        /*
        Check for
        - Straight flush
        - Four of a kind
        - Full House
        - Flush
        - Straight
        - Three of a kind
        - Two Pairs
        - Pair
        - High Card
        I.e. if straight flush break else keep going until find one
        */
        Card highCard = isHighCard(one);
        return null;
    }

    /*
    Checks if a hand has a high card value
    If so, returns the high card
    If there are multiple, returns the highest
     */
    public static Card isHighCard(Hand hand){
        Card highCard = null;
        List<Card> highCards = new ArrayList<>();
        for(Card card: hand.getCards()){
            if(card.getValue().getCardValue()>10){
                highCards.add(card);
                highCard = card;
            }
        }
        if(highCards.size()>1){
            for(int i=highCards.size()-1; i>0; i--){
                if(highCards.get(i).getValue().getCardValue()>highCard.getValue().getCardValue()){
                    highCard = highCards.get(i);
                }
            }
        }
        return highCard;
    }
}
