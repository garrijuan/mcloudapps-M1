package mcloudapps.connectFour.models;

public class Memento {

    private final Board board;

    private final int activePlayer;

    public Memento(Game game) {
        this.board = game.getBoard();
        this.activePlayer = game.getActivePlayer();
    }
    
    public Board getBoard() {
        return board;
    }

    public int getActivePlayer() {
        return activePlayer;
    }
    
}
