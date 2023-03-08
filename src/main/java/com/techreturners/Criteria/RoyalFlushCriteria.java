package com.techreturners.Criteria;

import com.techreturners.EnumsAndConstants.CardValue;
import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;
import static com.techreturners.HandEvaluator.straightFlush;

public class RoyalFlushCriteria implements HandCombinationCriteria{
    @Override
    public boolean meetCriteria(Hand hand) {
        if(straightFlush.meetCriteria(hand)){
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
}
