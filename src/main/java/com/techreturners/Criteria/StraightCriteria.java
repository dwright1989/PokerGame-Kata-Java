package com.techreturners.Criteria;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.CardValue;
import com.techreturners.EnumsAndConstants.Constants;
import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;

import java.util.List;
import java.util.stream.IntStream;

public class StraightCriteria implements HandCombinationCriteria{
    @Override
    public boolean meetCriteria(Hand hand) {
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
}
