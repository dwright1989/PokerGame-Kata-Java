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

    @Test
    public void compareTwoHandsWithDifferentFlushValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.NINE, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.SPADES))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.THREE, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.SEVEN, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.FLUSH);
    }

    @Test
    public void compareTwoHandsWithSameFlushValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.SPADES))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.SPADES))));
        assertNull(HandEvaluator.compareHands(handOne, handTwo));
    }

    @Test
    public void compareTwoHandsWithOneStraightAndOneFlush(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.THREE, CardSuit.SPADES))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
        assertEquals(handOne.getResult(), HandType.STRAIGHT);
        assertEquals(handTwo.getResult(), HandType.FLUSH);
    }
}
