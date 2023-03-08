package com.techreturners.Criteria;

import com.techreturners.Card;
import com.techreturners.CardUtils;
import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;

import java.util.List;

public class PairCriteria implements HandCombinationCriteria{
    @Override
    public boolean meetCriteria(Hand hand) {
        List<Card> pairs = CardUtils.getPairsFromCards(hand.getCards());
        if(pairs.size()==2){
            hand.setResult(HandType.PAIR);
            return true;
        }
        return false;
    }


}
