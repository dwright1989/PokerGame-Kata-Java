package com.techreturners;
import com.techreturners.EnumsAndConstants.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class HandEvaluator {

    /* COMPARE HANDS - Could be changed to array of hands to upscale to a 3+ player game */
    public static Hand compareHands(Hand one, Hand two){
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
        boolean evaluated =
                checkIfRoyalFlush(hand) ||
                checkIfStraightFlush(hand) ||
                checkIfFourOfAKind(hand) ||
                checkIfFullHouse(hand) ||
                checkIfFlush(hand) ||
                checkIfStraight(hand) ||
                checkIfThreeOfAKind(hand) ||
                checkIfTwoPairs(hand) ||
                checkIfOnePair(hand) ||
                checkContainsHighCard(hand);
    }
    private static Hand compareHandsOfSameHandType(Hand one, Hand two, HandType result) {
        Hand winner = null;
        switch(result){
            case HIGH_CARD,NO_COMBO -> winner = betterHighCardHand(one, two);
            case PAIR, TWO_PAIRS -> winner = betterPair(one, two);
            case THREE_OF_A_KIND -> winner = betterTrio(one, two);
            case STRAIGHT -> winner = betterStraight(one, two);
            case FLUSH, STRAIGHT_FLUSH -> winner = betterFlush(one, two);
            case FULL_HOUSE -> winner = betterFullHouse(one, two);
            case FOUR_OF_A_KIND -> winner = betterFourOfAKind(one, two);
        }
        return winner;
    }
    /*
    ROYAL FLUSH
     */
    public static boolean checkIfRoyalFlush(Hand hand){
        if(checkIfStraightFlush(hand)){
            boolean royalFlush = hand.getCards().stream().anyMatch(card -> card.getValue().equals(CardValue.TEN)) &&
                    hand.getCards().stream().anyMatch(card -> card.getValue().equals(CardValue.JACK)) &&
                    hand.getCards().stream().anyMatch(card -> card.getValue().equals(CardValue.QUEEN)) &&
                    hand.getCards().stream().anyMatch(card -> card.getValue().equals(CardValue.KING)) &&
                    hand.getCards().stream().anyMatch(card -> card.getValue().equals(CardValue.ACE));
            if(royalFlush){
                hand.setResult(HandType.ROYAL_FLUSH);
                return true;
            }
        }
        return false;
    }

    /*
    STRAIGHT FLUSH
     */
    public static boolean checkIfStraightFlush(Hand hand){
        if(checkIfFlush(hand)){
             if(checkIfStraight(hand)){
                 hand.setResult(HandType.STRAIGHT_FLUSH);
                 return true;
             }
        }
        return false;
    }

    /*
    FOUR OF A KIND
     */
    public static boolean checkIfFourOfAKind(Hand hand){
        List<Card> quad = getQuadFromCards(hand.getCards());
        if(quad.size()==4){
            hand.setResult(HandType.FOUR_OF_A_KIND);
            return true;
        }
        return false;
    }
    private static List<Card> getQuadFromCards(List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getValue))
                .values().stream().filter(list->list.size()>=4).flatMap(List::stream).toList();
    }

    private static Hand betterFourOfAKind(Hand one, Hand two) {
        List<Card> fourOfAKindFromHandOne = getQuadFromCards(one.getCards());
        List<Card> fourOfAKindFromHandTwo = getQuadFromCards(two.getCards());
        if(fourOfAKindFromHandOne.get(0).getValue().getCardValue()>fourOfAKindFromHandTwo.get(0).getValue().getCardValue()){
            return one;
        }else if(fourOfAKindFromHandOne.get(0).getValue().getCardValue()<fourOfAKindFromHandTwo.get(0).getValue().getCardValue()){
            return two;
        }else{
            return betterHighCardHand(one, two);
        }
    }

    /*
    FULL  HOUSE
     */
    public static boolean checkIfFullHouse(Hand hand){
        boolean trio = checkIfThreeOfAKind(hand);
        if(trio){
            if(checkIfOnePair(hand)){
                hand.setResult(HandType.FULL_HOUSE);
                return true;
            }
        }
        return false;
    }

    private static Hand betterFullHouse(Hand one, Hand two) {
        Hand bestTrio = betterTrio(one, two);
        if(bestTrio!=null){
            return bestTrio;
        }else{
            return betterPair(one, two);
        }
    }

    /*
    FLUSH
     */
    public static boolean checkIfFlush(Hand hand){
        List<Card> flush = hand.getCards().stream().collect(groupingBy(Card::getSuit))
                .values().stream().filter(list -> list.size() == 5).flatMap(List::stream).toList();
        if(flush.size() == Constants.NUM_OF_CARDS_IN_HAND){
            hand.setResult(HandType.FLUSH);
            return true;
        }
        return false;
    }
    private static Hand betterFlush(Hand one, Hand two) {
        return betterHighCardHand(one, two);
    }

    /*
    STRAIGHT
     */
    public static boolean checkIfStraight(Hand hand){
        hand.sortHandNumerically();
        List<Card> cards = hand.getCards();
        boolean straight = false;
        // Check for ace LOW (automatically considered HIGH)
        if(cards.get(Constants.NUM_OF_CARDS_IN_HAND-1).getValue().equals(CardValue.ACE) && cards.get(0).getValue().equals(CardValue.TWO)){
            straight = IntStream.range(1, cards.size()-1).allMatch(
                    value -> cards.get(value).getValue().getCardValue() - cards.get(value - 1).getValue().getCardValue() == 1);
        }else{
            straight = IntStream.range(1, cards.size()).allMatch(
                    value -> cards.get(value).getValue().getCardValue() - cards.get(value - 1).getValue().getCardValue() == 1);
        }
        if(straight){
            hand.setResult(HandType.STRAIGHT);
        }
        return straight;
    }

    private static Hand betterStraight(Hand one, Hand two) {
        return betterHighCardHand(one, two);
    }


    /*
    THREE OF A KIND
     */
    public static boolean checkIfThreeOfAKind(Hand hand) {
        List<Card> trio = getTrioFromCards(hand.getCards());
        if(trio.size()==3){
            hand.setResult(HandType.THREE_OF_A_KIND);
            return true;
        }
        return false;
    }

    private static List<Card> getTrioFromCards(List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getValue))
                .values().stream().filter(list->list.size()>=3).flatMap(List::stream).toList();
    }

    private static Hand betterTrio(Hand one, Hand two) {
        List<Card> trioInHandOne = getTrioFromCards(one.getCards());
        List<Card> trioInHandTwo = getTrioFromCards(two.getCards());
        int maxOneValue = trioInHandOne.stream().max(Comparator.comparing(value -> value.getValue().getCardValue())).get().getValue().getCardValue();
        int maxTwoValue = trioInHandTwo.stream().max(Comparator.comparing(value -> value.getValue().getCardValue())).get().getValue().getCardValue();
        if(maxOneValue>maxTwoValue){
            return one;
        }else if(maxTwoValue>maxOneValue){
            return two;
        }else{
            return betterHighCardHand(one, two);
        }
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
                .values().stream().filter(list->list.size()==2).flatMap(List::stream).toList();
    }
    private static Hand betterPair(Hand one, Hand two) {
        List<Card> pairsInHandOne = getPairsFromCards(one.getCards());
        List<Card> pairsInHandTwo = getPairsFromCards(two.getCards());
        int maxOneValue = pairsInHandOne.stream().max(Comparator.comparing(value -> value.getValue().getCardValue())).get().getValue().getCardValue();
        int maxTwoValue = pairsInHandTwo.stream().max(Comparator.comparing(value -> value.getValue().getCardValue())).get().getValue().getCardValue();
        if(maxOneValue>maxTwoValue){
            return one;
        }else if(maxTwoValue>maxOneValue){
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
