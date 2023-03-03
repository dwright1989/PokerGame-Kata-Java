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

public class HandEvaluatorFourOfAKindTest {
    @Test
    public void hasOneQuadShouldReturnTrue(){
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.FIVE, CardSuit.SPADES),
                new Card(CardValue.FIVE, CardSuit.HEARTS),
                new Card(CardValue.FIVE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.FIVE, CardSuit.DIAMONDS))));
        assertTrue(HandEvaluator.checkIfFourOfAKind(hand));
        assertEquals(hand.getResult(), HandType.FOUR_OF_A_KIND);
    }
}
