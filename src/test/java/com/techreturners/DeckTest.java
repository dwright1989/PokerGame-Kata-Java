package com.techreturners;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void canCreateDeck(){
        Deck deck = new Deck();
        assertNotNull(deck.getCards());
    }
}
