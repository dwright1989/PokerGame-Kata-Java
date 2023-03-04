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

import static org.junit.jupiter.api.Assertions.*;

public class HandEvaluatorStraightFlushTest {

    @Test
    public void handHasStraightFlush(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.SPADES),
                new Card(CardValue.FOUR, CardSuit.SPADES),
                new Card(CardValue.THREE, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.SPADES))));
        assertTrue(HandEvaluator.checkIfStraightFlush(hand));
        assertEquals(hand.getResult(), HandType.STRAIGHT_FLUSH);
    }

    @Test
    public void handHasFlushOnly(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.SPADES),
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.NINE, CardSuit.SPADES))));
        assertFalse(HandEvaluator.checkIfStraightFlush(hand));
    }

    @Test
    public void handHasStraightOnly(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.HEARTS),
                new Card(CardValue.THREE, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.SPADES))));
        assertFalse(HandEvaluator.checkIfStraightFlush(hand));
    }
}
