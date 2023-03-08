package com.techreturners.HandEvaluatorTests;

import com.techreturners.*;
import com.techreturners.EnumsAndConstants.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static com.techreturners.HandEvaluator.fourOfAKind;

public class HandEvaluatorFourOfAKindTest {
    @Test
    public void hasOneQuadShouldReturnTrue(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.HEARTS),
                new Card(CardValue.FIVE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertTrue(fourOfAKind.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.FOUR_OF_A_KIND);
    }

    @Test
    public void compareTwoHandsWithDifferentFourOfAKindValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.THREE, CardSuit.DIAMONDS),
                new Card(CardValue.THREE, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.THREE, CardSuit.HEARTS),
                new Card(CardValue.THREE, CardSuit.CLUBS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.FOUR_OF_A_KIND);
    }

    @Test
    public void compareTwoHandsWithSameFourOfAKindValuesAndDifferentSingleValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.CLUBS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
        assertEquals(handOne.getResult(), HandType.FOUR_OF_A_KIND);
    }

    @Test
    public void compareTwoHandsWithSameFourOfAKindValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.CLUBS))));
        assertNull(HandEvaluator.compareHands(handOne, handTwo));
    }
}
