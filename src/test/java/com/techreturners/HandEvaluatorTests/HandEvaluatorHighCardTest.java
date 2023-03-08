package com.techreturners.HandEvaluatorTests;
import com.techreturners.Card;
import com.techreturners.EnumsAndConstants.*;
import com.techreturners.Hand;
import com.techreturners.HandEvaluator;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static com.techreturners.HandEvaluator.cardHigh;

public class HandEvaluatorHighCardTest {
    @Test
    public void hasOneHighCard(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS))));
        assertTrue(cardHigh.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.HIGH_CARD);
    }

    @Test
    public void hasZeroHighCards(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS))));
        assertFalse(cardHigh.meetCriteria(hand));
    }

    @Test
    public void compareTwoHandsWithDifferentHighCards(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS))));
        Hand winner = HandEvaluator.compareHands(handOne, handTwo);
        assertEquals(winner, handOne);
    }

    @Test
    public void compareTwoHandsWithSameHighCards(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS))));
        Hand winner = HandEvaluator.compareHands(handOne, handTwo);
        assertEquals(winner, handTwo);
    }

    @Test
    public void compareTwoHandsWithIdenticalHighCardsDifferentOrder(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Hand winner = HandEvaluator.compareHands(handOne, handTwo);
        assertNull(winner);
    }
}
