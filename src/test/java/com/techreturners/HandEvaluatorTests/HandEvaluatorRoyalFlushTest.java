package com.techreturners.HandEvaluatorTests;

import com.techreturners.*;
import com.techreturners.EnumsAndConstants.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static com.techreturners.HandEvaluator.royalFlush;

public class HandEvaluatorRoyalFlushTest {

    @Test
    public void handHasRoyalFlush(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.SPADES))));
        assertTrue(royalFlush.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.ROYAL_FLUSH);
    }
    @Test
    public void compareTwoHandsOneStraightFlushOneHasRoyalFlush(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.SPADES))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.THREE, CardSuit.SPADES),
                new Card(CardValue.SIX, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.SEVEN, CardSuit.SPADES),
                new Card(CardValue.FOUR, CardSuit.SPADES))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.ROYAL_FLUSH);
        assertEquals(handTwo.getResult(), HandType.STRAIGHT_FLUSH);
    }

}
