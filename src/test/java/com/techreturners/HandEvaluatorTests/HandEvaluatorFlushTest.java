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

public class HandEvaluatorFlushTest {

    @Test
    public void handHasFlush(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.SPADES),
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.NINE, CardSuit.SPADES))));
        assertTrue(HandEvaluator.checkIfFlush(hand));
        assertEquals(hand.getResult(), HandType.FLUSH);
    }

    @Test
    public void handHasFlushButOne(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.HEARTS),
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.NINE, CardSuit.SPADES))));
        assertFalse(HandEvaluator.checkIfFlush(hand));
    }
}
