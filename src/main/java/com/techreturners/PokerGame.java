package com.techreturners;

public class PokerGame {

    private Player[] players;
    private Dealer dealer;

    private Player winner;

    public PokerGame() {
        //startGame();
    }
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setPlayersByNames(String nameOne, String nameTwo){
        setPlayers(new Player[]{new Player(nameOne), new Player(nameTwo)});
    }
    public void startGame(){
        initialiseDealer(initialiseDeck());
        dealHands();
        winner = dealer.checkWinner(players);
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


}
