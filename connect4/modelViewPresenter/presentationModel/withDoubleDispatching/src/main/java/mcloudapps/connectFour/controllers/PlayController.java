package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.models.State;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
    }
    
    public Color getActivePlayerColor(){
        return this.game.getActivePlayerColor();
    }

    public void putToken(int column) {
        this.game.putToken(column, this.getActivePlayerColor());
    }

    public Error getPutTokenError(int column) {
        return this.game.getPutTokenError(column);
    }

    public void next() {
        this.game.next();
    }

    public boolean isGameOver() {
        return this.game.isGameOver();
    }

    public Color getResult() {
        return this.game.getResult();
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
