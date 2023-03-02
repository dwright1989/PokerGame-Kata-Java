package com.techreturners;

import com.techreturners.Enums.CardSuit;
import com.techreturners.Enums.CardValue;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void canCreateDeck(){
        Deck deck = new Deck();
        assertNotNull(deck.getCards());
        assertEquals(deck.getCards().size(), 52);
    }

    @Test
    public void shuffleSuccessful(){
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();
        List<Card> cardsOriginalCopy = new ArrayList<>(cards);
        deck.shuffleCards();
        assertNotEquals(cards, cardsOriginalCopy);
    }

    @Test
    public void testPrint(){
        Deck deck = new Deck();
        deck.printCards();
    }
}
