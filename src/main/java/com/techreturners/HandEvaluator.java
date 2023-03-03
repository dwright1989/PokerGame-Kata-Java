package com.techreturners;
import com.techreturners.EnumsAndConstants.Constants;
import com.techreturners.EnumsAndConstants.HandType;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.groupingBy;

public class HandEvaluator {

    /* COMPARE HANDS - Could be changed to array of hands to upscale to a 3+ player game */
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
    private static Hand compareHandsOfSameHandType(Hand one, Hand two, HandType result) {
        Hand winner = null;
        switch(result){
            case HIGH_CARD,NO_COMBO -> winner = betterHighCardHand(one, two);
            case PAIR -> winner = betterPair(one, two);
        }
        return winner;
    }

    /*
    PAIRS
     */
    public static boolean checkIfOnePair(Hand hand) {
        List<Card> pairs = getPairsFromCards(hand.getCards());
        if(pairs.size()==2){
            hand.setResult(HandType.PAIR);
            return true;
        }
        return false;
    }
    public static boolean checkIfTwoPairs(Hand hand){
        List<Card> pairs = getPairsFromCards(hand.getCards());
        if(pairs.size()==4){
            hand.setResult(HandType.TWO_PAIRS);
            return true;
        }
        return false;
    }
    private static List<Card> getPairsFromCards(List<Card> cards){
        return cards.stream().collect(groupingBy(Card::getValue))
                .values().stream().filter(list->list.size()>=2).flatMap(List::stream).toList();
    }
    private static Hand betterPair(Hand one, Hand two) {
        List<Card> pairsInHandOne = getPairsFromCards(one.getCards());
        List<Card> pairsInHandTwo = getPairsFromCards(two.getCards());
        int pairOneValue = pairsInHandOne.get(0).getValue().getCardValue();
        int pairTwoValue = pairsInHandTwo.get(0).getValue().getCardValue();
        if(pairOneValue>pairTwoValue){
            return one;
        }else if(pairTwoValue>pairOneValue){
            return two;
        }else{
            return betterHighCardHand(one, two);
        }
    }

    /*
    HIGH CARD
     */
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
    private static Hand betterHighCardHand(Hand one, Hand two) {
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
}
