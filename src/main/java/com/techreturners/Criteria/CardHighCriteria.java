package com.techreturners.Criteria;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;

public class CardHighCriteria implements HandCombinationCriteria {
    @Override
    public boolean meetCriteria(Hand hand) {
        boolean containsHighCard = false;
        for(Card card: hand.getCards()){
            if(card.getValue().getCardValue()>10){
                hand.setResult(HandType.HIGH_CARD);
                return true;
            }
        }
        return containsHighCard;
    }
}
