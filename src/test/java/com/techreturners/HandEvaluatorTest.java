package com.techreturners;


import com.techreturners.EnumsAndConstants.CardSuit;
import com.techreturners.EnumsAndConstants.CardValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandEvaluatorTest {

    /*
    Card High Tests
     */
    @Test
    public void willReturnOneHighCard(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Card card = HandEvaluator.isHighCard(hand);
        assertEquals(card.getValue(), CardValue.ACE);
    }

}
