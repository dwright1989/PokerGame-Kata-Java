package com.techreturners.HandEvaluatorTests;

import com.techreturners.*;
import com.techreturners.EnumsAndConstants.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static com.techreturners.HandEvaluator.straight;

public class HandEvaluatorStraightTest {


    @Test
    public void handHasStraightInOrder(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.HEARTS),
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.DIAMONDS),
                new Card(CardValue.NINE, CardSuit.DIAMONDS))));
        assertTrue(straight.meetCriteria(hand));
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
        assertTrue(straight.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.STRAIGHT);
    }


    @Test
    public void straightWithAceHigh(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.ACE, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.DIAMONDS),
                new Card(CardValue.KING, CardSuit.DIAMONDS))));
        assertTrue(straight.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.STRAIGHT);
    }


    @Test
    public void straightWithAceLow(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.THREE, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS))));
        assertTrue(straight.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.STRAIGHT);
    }

    @Test
    public void compareStraightWithAceLowAndAceHigh(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.THREE, CardSuit.CLUBS),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.SPADES),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.STRAIGHT);
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
