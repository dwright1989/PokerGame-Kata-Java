package com.techreturners.HandEvaluatorTests;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.*;
import com.techreturners.Hand;
import com.techreturners.HandEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandEvaluatorPairTest {
    @Test
    public void hasOnePairShouldReturnTrue(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertTrue(HandEvaluator.checkIfOnePair(hand));
        assertEquals(hand.getResult(), HandType.PAIR);
    }

    @Test
    public void hasThreeOfAKindShouldReturnFalse(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertFalse(HandEvaluator.checkIfOnePair(hand));
    }

    @Test
    public void hasTwoPairsShouldReturnFalse(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.EIGHT, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertFalse(HandEvaluator.checkIfOnePair(hand));
    }
}
