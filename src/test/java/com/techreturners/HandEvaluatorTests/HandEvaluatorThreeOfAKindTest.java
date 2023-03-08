package com.techreturners.HandEvaluatorTests;

import com.techreturners.*;
import com.techreturners.EnumsAndConstants.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static com.techreturners.HandEvaluator.threeOfAKind;

public class HandEvaluatorThreeOfAKindTest {

    @Test
    public void hasOneTrioShouldReturnTrue(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertTrue(threeOfAKind.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.THREE_OF_A_KIND);
    }

    @Test
    public void hasFourOfAKindShouldReturnFalse(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.CLUBS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertFalse(threeOfAKind.meetCriteria(hand));
    }


    @Test
    public void compareTwoHandsWithDifferentTrioValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
    }

    @Test
    public void compareTwoHandsWithSameTrioValuesAndDifferentOtherValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.THREE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
    }


    @Test
    public void compareTwoHandsWithSameTrioValuesAndSameOtherValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertNull(HandEvaluator.compareHands(handOne, handTwo));
    }


    @Test
    public void compareOneHandTrioAndOneHandPair(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.THREE, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
    }
}
