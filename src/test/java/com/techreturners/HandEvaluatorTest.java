package com.techreturners;

import com.techreturners.EnumsAndConstants.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandEvaluatorTest {

    /*
    Card High Tests
     */
    @Test
    public void willReturnOneHighCard(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Card card = HandEvaluator.isHighCard(hand);
        assertEquals(card.getValue(), CardValue.ACE);
    }

    @Test
    public void willReturnZeroHighCards(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Card card = HandEvaluator.isHighCard(hand);
        assertNull(card);
    }

    @Test
    public void willReturnHighestCard(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        Card card = HandEvaluator.isHighCard(hand);
        assertEquals(card.getValue(), CardValue.KING);
    }

}
