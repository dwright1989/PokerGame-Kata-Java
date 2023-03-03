package com.techreturners;
import com.techreturners.EnumsAndConstants.Constants;
import com.techreturners.EnumsAndConstants.HandType;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class HandEvaluator {
    /*
    Could be changed to array of hands to upscale to a 3+ player game
     */
    public static Hand compareHands(Hand one, Hand two){
        /*
        Check for
        - Royal flush
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
        Hand winner = null;
        evaluateHand(one);
        evaluateHand(two);

        if(one.getResult().getHandValue()==(two.getResult().getHandValue())){
            winner = compareHandsOfSameHandType(one, two, one.getResult());
        }else if(one.getResult().getHandValue()>two.getResult().getHandValue()){
            winner = one;
        }else{
            winner = two;
        }
        return winner;
    }

    public static Hand compareHandsOfSameHandType(Hand one, Hand two, HandType result) {
        Hand winner = null;
        switch(result){
            case HIGH_CARD,NO_COMBO -> winner = betterHighCardHand(one, two);
        }
        return winner;
    }

    public static Hand betterHighCardHand(Hand one, Hand two) {
        one.sortHandNumerically();
        two.sortHandNumerically();
        List<Card> handOneCards = one.getCards();
        List<Card> handTwoCards = two.getCards();
        for(int i = 0; i< Constants.NUM_OF_CARDS_IN_HAND; i++){
            if(handOneCards.get(i).getValue().getCardValue()>handTwoCards.get(i).getValue().getCardValue()){
                return one;
            }else if(handOneCards.get(i).getValue().getCardValue()<handTwoCards.get(i).getValue().getCardValue()){
                return two;
            }
        }
        return null;
    }


    public static void evaluateHand(Hand hand){
        boolean foundCombo = false;
        while(!foundCombo){
            if(checkIfOnePair(hand)){
                foundCombo = true;
            }else if(checkContainsHighCard(hand)){
                foundCombo = true;
            }
        }

    }

    public static boolean checkIfOnePair(Hand hand) {
        hand.sortHandNumerically();
        List<Card> pairs = hand.getCards().stream().collect(groupingBy(Card::getValue))
                .values().stream().filter(list->list.size()>=2).flatMap(List::stream).toList();
        if(pairs.size()==2){
            hand.setResult(HandType.PAIR);
            return true;
        }
        return false;
    }

    public static boolean checkContainsHighCard(Hand hand){
        boolean containsHighCard = false;
        for(Card card: hand.getCards()){
            if(card.getValue().getCardValue()>10){
                hand.setResult(HandType.HIGH_CARD);
                return true;
            }
        }
        return containsHighCard;
    }

}