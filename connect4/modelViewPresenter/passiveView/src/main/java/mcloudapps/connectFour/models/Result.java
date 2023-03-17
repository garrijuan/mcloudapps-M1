package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;
import mcloudapps.utils.models.Direction;

public class Result {

    private final int line_length = 4;
    private Board board;

    public Result(Board board) {
        assert board != null;
        this.board = board;
    }

	public Color getResult() {
        for (Direction direction : Direction.halfValues()) {
            if (this.checkLine(this.board.lastCoordinate, direction)) {
                return this.board.getCoordinate(this.board.lastCoordinate);
            }
        }
        return null;
    }   

    public boolean checkLine(Coordinate coordinate, Direction direction) {
        assert coordinate != null;
        assert direction != null;
        if (isLine(coordinate, direction) || isLine(coordinate, direction.reverse())) {
            return true;
        }
        return false;
    }

    public boolean isLine(Coordinate originCoordinate, Direction direction) {
        int inLineTokenCounter = 1;
        Coordinate nextCoordinate = (Coordinate) originCoordinate.clone();
        Color originColor = this.board.getCoordinate(originCoordinate);
        while (inLineTokenCounter < this.line_length){
            nextCoordinate.shift(direction); 
            Color nextColor = this.board.getCoordinate(nextCoordinate);
            if (nextColor != null && nextColor.equals(originColor)) {
                inLineTokenCounter++;
            } else {
                break;
            }
        }
        return inLineTokenCounter == this.line_length;
    }

    public boolean isGameOver()
    {
        return this.getResult() != null || this.board.isBoardFull();
    }

}
