package com.techreturners;

import com.techreturners.EnumsAndConstants.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DealerTest {

    Dealer dealer;

    @BeforeEach
    public void setUp(){
        dealer = new Dealer(new Deck());
    }
    @Test
    public void canDealRandomHand(){
        Hand hand = dealer.dealHand();
        assertNotNull(hand);
        assertEquals(hand.getCards().size(), Constants.NUM_OF_CARDS_IN_HAND);
        assertEquals(dealer.getDeck().getCards().size(), (Constants.TOTAL_CARDS_IN_DECK - Constants.NUM_OF_CARDS_IN_HAND));
    }

    @Test
    public void handsAreTheSame(){

    }

}
