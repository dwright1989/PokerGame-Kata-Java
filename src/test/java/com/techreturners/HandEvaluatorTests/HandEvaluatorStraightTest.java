package com.techreturners.HandEvaluatorTests;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.*;
import com.techreturners.Hand;
import com.techreturners.HandEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void compareTwoHandsWithDifferentStraightValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.THREE, CardSuit.CLUBS),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.SIX, CardSuit.SPADES),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.STRAIGHT);
    }

    @Test
    public void compareTwoHandsWithSameStraightValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS))));
        assertNull(HandEvaluator.compareHands(handOne, handTwo));
    }

    @Test
    public void compareTwoHandsWithOneStraightAndOneTrio(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.STRAIGHT);
        assertEquals(handTwo.getResult(), HandType.THREE_OF_A_KIND);
    }

}
