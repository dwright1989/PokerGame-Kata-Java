package com.techreturners;

import com.techreturners.EnumsAndConstants.CardSuit;
import com.techreturners.EnumsAndConstants.CardValue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    public void canSortHand(){
        Card one = new Card(CardValue.FIVE, CardSuit.SPADES);
        Card two = new Card(CardValue.EIGHT, CardSuit.HEARTS);
        Card three = new Card(CardValue.TEN, CardSuit.SPADES);
        Card four = new Card(CardValue.ACE, CardSuit.DIAMONDS);
        Card five = new Card(CardValue.FIVE, CardSuit.DIAMONDS);
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(one,two,three,four,five)));
        hand.sortHandNumerically();
        assertEquals(hand.getCards().get(0).getValue().getCardValue(),5);
        assertEquals(hand.getCards().get(1).getValue().getCardValue(),5);
        assertEquals(hand.getCards().get(2).getValue().getCardValue(),8);
        assertEquals(hand.getCards().get(3).getValue().getCardValue(),10);
        assertEquals(hand.getCards().get(4).getValue().getCardValue(),14);
    }
}
