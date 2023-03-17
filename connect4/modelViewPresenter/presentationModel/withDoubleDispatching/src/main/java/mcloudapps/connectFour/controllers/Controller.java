package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.models.State;
import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;

public abstract class Controller {

    protected Game game;
    protected State state;

    public Controller(Game game,State state) {
        this.game = game;
        this.state = state;
    }

    public void nextState() {
        this.state.next();
    }

    public abstract void accept(ControllersVisitor controllersVisitor);

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
