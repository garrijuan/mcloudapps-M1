package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.utils.models.Coordinate;

public class Game {
   
    private Board board;
    private Turn turn;
    private Result result;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.result = new Result(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    } 

    public int getNumberOfRows() {
        return this.board.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return this.board.getNumberOfColumns();
    }

    public void next() {
        this.turn.nextPlayer();
    }

    public Color getActivePlayerColor() {
        return this.turn.getActivePlayer().getColor();
    }

    public boolean isEmpty(Coordinate coordinate) {
        return this.board.isEmpty(coordinate);
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void putToken(int column, Color color) {
        this.board.putToken(column, color);
    }

    public Error getPutTokenError(int column) {
        return this.turn.getPutTokenError(column);
    }

    public boolean isGameOver() {
        return this.result.isGameOver();
    }

    public Color getResult() {
        return this.result.getResult();
    }

}
