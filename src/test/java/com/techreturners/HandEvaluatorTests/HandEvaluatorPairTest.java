package com.techreturners.HandEvaluatorTests;

import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.*;
import com.techreturners.Hand;
import com.techreturners.HandEvaluator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static com.techreturners.HandEvaluator.pair;
import static com.techreturners.HandEvaluator.twoPair;

public class HandEvaluatorPairTest {
    @Test
    public void hasOnePairShouldReturnTrue(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertTrue(pair.meetCriteria(hand));
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
        assertFalse(pair.meetCriteria(hand));
    }

    @Test
    public void hasTwoPairsShouldReturnFalse(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.EIGHT, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertFalse(pair.meetCriteria(hand));
    }

    @Test
    public void hasTwoPairsShouldReturnTrue(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.EIGHT, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertTrue(twoPair.meetCriteria(hand));
    }

    @Test
    public void compareTwoHandsWithDifferentPairValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
    }

    @Test
    public void compareTwoHandsWithSamePairValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.SEVEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
    }

    @Test
    public void compareTwoHandsWithSamePairValuesAndSameOtherValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertNull(HandEvaluator.compareHands(handOne, handTwo));
    }

    @Test
    public void compareTwoHandsWhereOnlyOneHasAPair(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
    }

    @Test
    public void compareTwoHandsWithDifferentTwoPairValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
    }

    @Test
    public void compareTwoHandsWithTwoPairsEachAndOneTheSame(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.THREE, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.THREE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
    }

    @Test
    public void compareTwoHandsWithSameTwoPairValuesAndDifferentOtherValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.THREE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
    }

    @Test
    public void compareTwoHandsWithSameTwoPairValuesAndSameOtherValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertNull(HandEvaluator.compareHands(handOne, handTwo));
    }

    @Test
    public void compareTwoHandsWhereOneHasAPairAndOneHasTwoPairs(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.SEVEN, CardSuit.DIAMONDS))));
        Hand winner = HandEvaluator.compareHands(handOne, handTwo);
        assertEquals(winner, handTwo);
    }

}
