package com.techreturners.Criteria;

import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;

import static com.techreturners.HandEvaluator.flush;
import static com.techreturners.HandEvaluator.straight;

public class StraightFlushCriteria implements HandCombinationCriteria{
    @Override
    public boolean meetCriteria(Hand hand) {
        if(flush.meetCriteria(hand)){
            if(straight.meetCriteria(hand)){
                hand.setResult(HandType.STRAIGHT_FLUSH);
                return true;
            }
        }
        return false;
    }
}
