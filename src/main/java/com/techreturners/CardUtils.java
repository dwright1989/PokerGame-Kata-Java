package com.techreturners;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class CardUtils {

    public static List<Card> getPairsFromCards(List<Card> cards){
        return cards.stream().collect(groupingBy(Card::getValue))
                .values().stream().filter(list->list.size()==2).flatMap(List::stream).toList();
    }

    public static List<Card> getTrioFromCards(List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getValue))
                .values().stream().filter(list->list.size()>=3).flatMap(List::stream).toList();
    }

    public static List<Card> getQuadFromCards(List<Card> cards) {
        return cards.stream().collect(groupingBy(Card::getValue))
                .values().stream().filter(list->list.size()>=4).flatMap(List::stream).toList();
    }

}

