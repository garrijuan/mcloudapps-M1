package mcloudapps.connectFour;

import java.util.HashMap;
import java.util.Map;

import mcloudapps.utils.Coordinate;
import mcloudapps.utils.Direction;

public class Board {

    public static final int NCOLS = 7;
    public static final int NROWS = 6;

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

    public void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int row = Board.NROWS; row >= 1 ; row--) {
            Message.VERTICAL_LINE.write();
            for (int col = 1; col <= Board.NCOLS; col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (this.cells.containsKey(coordinate)) {
                    Message.COLOR.writeColor(this.cells.get(coordinate).toString());
                } else {
                    Message.EMPTY.write();
                }
                Message.VERTICAL_LINE.write();
            }
            Message.NEW_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
