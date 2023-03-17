package mcloudapps.connectFour.models;

import java.util.HashMap;
import java.util.Map;

import mcloudapps.connectFour.types.Color;

import mcloudapps.utils.models.Coordinate;
import mcloudapps.utils.models.Direction;

public class Board {

    private static final int NCOLS = 7;
    private static final int NROWS = 6;

    public Map<Coordinate, Color> cells;
    public Coordinate lastCoordinate;

    public Board() {
        this.cells = new HashMap<>();
        this.reset();
    }

    public void reset() {
        this.cells.clear();
        this.lastCoordinate = null;
    }

    public static int getNumberOfRows() {
        return Board.NROWS;
    }

    public static int getNumberOfColumns() {
        return Board.NCOLS;
    }

    public void putToken(int column, Color color) {
        assert color != null;
        assert this.isColumnValid(column);
        assert this.isColumnFull(column);
        int row = 1;
        Coordinate coordinate = new Coordinate(row, column);
        while (row <= Board.NROWS && this.cells.containsKey(coordinate)) {
            coordinate.shift(Direction.NORTH);
            row++;
        }
        this.cells.put(coordinate, color);
        this.lastCoordinate = coordinate;
    }

    public Color getCoordinate(Coordinate coordinate){
        assert coordinate != null;
        return this.cells.containsKey(coordinate) ? this.cells.get(coordinate) : null;
    }
    
    public boolean isColumnValid(int column) {
        return column >= 1 && column <= Board.NCOLS;
    }

    public boolean isColumnFull(int column) {
        return this.cells.containsKey(new Coordinate(NROWS, column));
    }

    public boolean isBoardFull(){
        int full_columns = 1;
        for (int column = 1 ; column <= Board.NCOLS ; column++){
            if (this.isColumnFull(column)){
                full_columns++;
            }
        }
        return (full_columns == Board.NCOLS);
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return !this.cells.containsKey(coordinate);
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.cells.get(coordinate);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        Board board = (Board) object;
        return this.cells.equals(board.cells);
    }
  
}
