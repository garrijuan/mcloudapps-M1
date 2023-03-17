package mcloudapps.connectFour;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    
    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private List<Player> players;
    private int activePlayer;

    public Turn(Board board) {
        assert board != null;
        this.board = board;
		this.players = new ArrayList<>();
		this.reset();
    }

    public void reset() {
		for (int i = 0; i < NUMBER_PLAYERS; i++) {
			players.add(new Player(Color.get(i), this.board));
		}        
        this.activePlayer = this.randomTurn();
    }

    public void play(){
        this.activePlayer = this.nextPlayer();
        this.getActivePlayer().play();
    }

    public Player getActivePlayer() {
        return this.players.get(this.activePlayer);
    }
    
    private int randomTurn() {
        return (int) (Math.random() * Turn.NUMBER_PLAYERS);
    }

    private int nextPlayer() {
        return (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
    }
    
}
