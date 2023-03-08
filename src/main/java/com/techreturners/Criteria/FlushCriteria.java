package com.techreturners.Criteria;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.Constants;
import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class FlushCriteria implements HandCombinationCriteria{
    @Override
    public boolean meetCriteria(Hand hand) {
        List<Card> flush = hand.getCards().stream().collect(groupingBy(Card::getSuit))
                .values().stream().filter(list -> list.size() == 5).flatMap(List::stream).toList();
        if(flush.size() == Constants.NUM_OF_CARDS_IN_HAND){
            hand.setResult(HandType.FLUSH);
            return true;
        }
        return false;
    }
}
