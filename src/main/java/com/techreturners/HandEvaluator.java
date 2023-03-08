package com.techreturners;
import com.techreturners.Criteria.*;
import com.techreturners.EnumsAndConstants.*;
import java.util.Comparator;
import java.util.List;

public class HandEvaluator {

    public static HandCombinationCriteria cardHigh = new CardHighCriteria();
    public static HandCombinationCriteria pair = new PairCriteria();
    public static HandCombinationCriteria twoPair = new TwoPairCriteria();
    public static HandCombinationCriteria threeOfAKind = new ThreeOfAKindCriteria();
    public static HandCombinationCriteria straight = new StraightCriteria();
    public static HandCombinationCriteria flush = new FlushCriteria();
    public static HandCombinationCriteria fullHouse = new FullHouseCriteria();
    public static HandCombinationCriteria fourOfAKind = new FourOfAKindCriteria();
    public static HandCombinationCriteria straightFlush = new StraightFlushCriteria();
    public static HandCombinationCriteria royalFlush = new RoyalFlushCriteria();

    /* COMPARE HANDS - Could be changed to array of hands to upscale to a 3+ player game */
    public static Hand compareHands(Hand one, Hand two){
        Hand winner;
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
                royalFlush.meetCriteria(hand) || straightFlush.meetCriteria(hand) || fourOfAKind.meetCriteria(hand) || fullHouse.meetCriteria(hand) || flush.meetCriteria(hand) ||
                straight.meetCriteria(hand) || threeOfAKind.meetCriteria(hand) || twoPair.meetCriteria(hand) || pair.meetCriteria(hand) || cardHigh.meetCriteria(hand);
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
    private static Hand betterFourOfAKind(Hand one, Hand two) {
        List<Card> fourOfAKindFromHandOne = CardUtils.getQuadFromCards(one.getCards());
        List<Card> fourOfAKindFromHandTwo = CardUtils.getQuadFromCards(two.getCards());
        if(fourOfAKindFromHandOne.get(0).getValue().getCardValue()>fourOfAKindFromHandTwo.get(0).getValue().getCardValue()){
            return one;
        }else if(fourOfAKindFromHandOne.get(0).getValue().getCardValue()<fourOfAKindFromHandTwo.get(0).getValue().getCardValue()){
            return two;
        }else{
            return betterHighCardHand(one, two);
        }
    }
    private static Hand betterFullHouse(Hand one, Hand two) {
        Hand bestTrio = betterTrio(one, two);
        if(bestTrio!=null){
            return bestTrio;
        }else{
            return betterPair(one, two);
        }
    }
    private static Hand betterFlush(Hand one, Hand two) {
        return betterHighCardHand(one, two);
    }
    private static Hand betterStraight(Hand one, Hand two) {
        return betterHighCardHand(one, two);
    }
    private static Hand betterTrio(Hand one, Hand two) {
        List<Card> trioInHandOne = CardUtils.getTrioFromCards(one.getCards());
        List<Card> trioInHandTwo = CardUtils.getTrioFromCards(two.getCards());
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
    private static Hand betterPair(Hand one, Hand two) {
        List<Card> pairsInHandOne = CardUtils.getPairsFromCards(one.getCards());
        List<Card> pairsInHandTwo = CardUtils.getPairsFromCards(two.getCards());
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
