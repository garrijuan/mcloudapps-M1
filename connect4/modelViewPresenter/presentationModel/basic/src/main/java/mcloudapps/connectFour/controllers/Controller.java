package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;

public class Controller {

    protected Game game;

    public Controller(Game game) {
        this.game = game;
    }

    public boolean isEmpty(Coordinate coordinate){
        return this.game.isEmpty(coordinate);
    }

    public Color getColor(Coordinate coordinate){
        return this.game.getColor(coordinate);
    }

    public int getNumberOfRows() {
        return this.game.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return this.game.getNumberOfColumns();
    }
}
