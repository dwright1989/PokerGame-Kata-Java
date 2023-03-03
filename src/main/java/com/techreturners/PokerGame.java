package com.techreturners;

public class PokerGame {

    private Player[] players;
    private Dealer dealer;

    public PokerGame() {
        startGame();
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void startGame(){
        initialisePlayers();
        initialiseDealer(initialiseDeck());
        dealHands();
        // dealer.checkWinner(players);
    }

    private void dealHands() {
        for(Player player: players){
            player.setHand(dealer.dealHand());
        }
    }

    private void initialiseDealer(Deck deck) {
        dealer = new Dealer(deck);
    }
    private Deck initialiseDeck() {
        return new Deck();
    }
    private void initialisePlayers() {
        Player playerOne = new Player("Black");
        Player playerTwo = new Player("White");
        players =  new Player[]{playerOne, playerTwo};
    }
}
