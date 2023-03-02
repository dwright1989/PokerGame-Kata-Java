package com.techreturners;

import java.util.List;

public class Dealer {

    public Hand dealSetHand(List<Card> cards){
        return new Hand(cards);
    }

    public Hand dealHand(){
        return null;
    }
}
