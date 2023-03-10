package com.techreturners;


import com.techreturners.EnumsAndConstants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer {

    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    public Hand dealHand(){
        List<Card> deckCards = deck.getCards();
        List<Card> handCards = new ArrayList<>();
        for(int i = 0; i< Constants.NUM_OF_CARDS_IN_HAND; i++){
            Random rand = new Random();
            Card randomCard = deckCards.get(rand.nextInt(deckCards.size()));
            handCards.add(randomCard);
            deckCards.remove(randomCard);
        }
        return new Hand(handCards);
    }

    public Deck getDeck() {
        return deck;
    }


    public Player checkWinner(Player[] players) {
        Player playerOne = players[0];
        Player playerTwo = players[1];
        Hand hand =   HandEvaluator.compareHands(playerOne.getHand(), playerTwo.getHand());
        if(hand == playerOne.getHand()){
            return playerOne;
        }else if(hand==playerTwo.getHand()){
            return playerTwo;
        }else{
            return null;
        }
    }
}
