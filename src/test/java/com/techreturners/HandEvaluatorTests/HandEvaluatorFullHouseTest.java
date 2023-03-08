package com.techreturners.HandEvaluatorTests;

import com.techreturners.*;
import com.techreturners.EnumsAndConstants.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static com.techreturners.HandEvaluator.fullHouse;

public class HandEvaluatorFullHouseTest {
    @Test
    public void handHasFullHouse() {
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES))));
        assertTrue(fullHouse.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.FULL_HOUSE);
    }

    @Test
    public void handHasOnlyTrio() {
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.FOUR, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES))));
        assertFalse(fullHouse.meetCriteria(hand));
        assertEquals(hand.getResult(), HandType.THREE_OF_A_KIND);
    }


    @Test
    public void compareTwoHandsWithDifferentFullHouseValues(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.THREE, CardSuit.DIAMONDS),
                new Card(CardValue.THREE, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.THREE, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.CLUBS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.FULL_HOUSE);
    }

    @Test
    public void compareTwoHandsWithDifferentFullHouseValuesSameThreeDifferentTwo(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.CLUBS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.FULL_HOUSE);
    }

    @Test
    public void compareTwoHandsWithDifferentFullHouseValuesSameTwoDifferentThree(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TWO, CardSuit.DIAMONDS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TWO, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.HEARTS),
                new Card(CardValue.TWO, CardSuit.CLUBS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handOne);
        assertEquals(handOne.getResult(), HandType.FULL_HOUSE);
    }

    @Test
    public void compareTwoHandsWithDifferentFullHouseValuesThreeAndTwoReversed(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.JACK, CardSuit.DIAMONDS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.CLUBS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
        assertEquals(handOne.getResult(), HandType.FULL_HOUSE);
    }

    @Test
    public void compareFullHouseToTrio(){
        Hand handOne = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.TEN, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.QUEEN, CardSuit.HEARTS))));
        Hand handTwo = new Hand(new ArrayList<>(Arrays.asList(
                new Card(CardValue.JACK, CardSuit.DIAMONDS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.CLUBS))));
        assertEquals(HandEvaluator.compareHands(handOne, handTwo), handTwo);
        assertEquals(handOne.getResult(), HandType.THREE_OF_A_KIND);
        assertEquals(handTwo.getResult(), HandType.FULL_HOUSE);
    }
}
