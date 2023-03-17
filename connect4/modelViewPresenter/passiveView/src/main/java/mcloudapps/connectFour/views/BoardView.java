package mcloudapps.connectFour.views;

import java.util.HashMap;
import java.util.Map;

import mcloudapps.connectFour.models.Board;
import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;

public abstract class BoardView {

    public Map<Coordinate, Color> cells;

    public BoardView() {
        this.cells = new HashMap<>();
    }

    public void set(Coordinate coordinate, Color color) {
        assert this.cells.size() < (Board.getNumberOfRows() * Board.getNumberOfColumns());
        this.cells.put(coordinate, color);
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return !this.cells.containsKey(coordinate) || this.cells.get(coordinate) == null;
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.cells.get(coordinate);
    }
    
    public abstract void write();
}
