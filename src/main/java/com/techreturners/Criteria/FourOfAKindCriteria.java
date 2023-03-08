package com.techreturners.Criteria;

import com.techreturners.Card;
import com.techreturners.CardUtils;
import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;

import java.util.List;

public class FourOfAKindCriteria implements HandCombinationCriteria{
    @Override
    public boolean meetCriteria(Hand hand) {
        List<Card> quad = CardUtils.getQuadFromCards(hand.getCards());
        if(quad.size()==4){
            hand.setResult(HandType.FOUR_OF_A_KIND);
            return true;
        }
        return false;
    }
}
