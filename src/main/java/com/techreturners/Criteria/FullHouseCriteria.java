package com.techreturners.Criteria;

import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;

import static com.techreturners.HandEvaluator.pair;
import static com.techreturners.HandEvaluator.threeOfAKind;

public class FullHouseCriteria implements HandCombinationCriteria{
    @Override
    public boolean meetCriteria(Hand hand) {
        boolean trio = threeOfAKind.meetCriteria(hand);
        if(trio){
            if(pair.meetCriteria(hand)){
                hand.setResult(HandType.FULL_HOUSE);
                return true;
            }
        }
        return false;
    }
}
