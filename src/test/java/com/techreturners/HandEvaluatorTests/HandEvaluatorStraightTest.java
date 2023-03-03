package com.techreturners.HandEvaluatorTests;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.CardSuit;
import com.techreturners.EnumsAndConstants.CardValue;
import com.techreturners.EnumsAndConstants.HandType;
import com.techreturners.Hand;
import com.techreturners.HandEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandEvaluatorStraightTest {

    @Test
    public void handHasStraightInOrder(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.HEARTS),
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.DIAMONDS),
                new Card(CardValue.NINE, CardSuit.DIAMONDS))));
        assertTrue(HandEvaluator.checkIfStraight(hand));
        assertEquals(hand.getResult(), HandType.STRAIGHT);
    }

    @Test
    public void handHasStraightOutOfOrder(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.NINE, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.HEARTS),
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertTrue(HandEvaluator.checkIfStraight(hand));
        assertEquals(hand.getResult(), HandType.STRAIGHT);
    }
}
