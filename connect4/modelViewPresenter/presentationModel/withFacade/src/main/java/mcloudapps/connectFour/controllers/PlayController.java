package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.utils.models.Coordinate;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
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

    public boolean isEmpty(Coordinate coordinate){
        return this.game.isEmpty(coordinate);
    }

    public boolean isGameOver() {
        return this.game.isGameOver();
    }

    public Color getResult() {
        return this.game.getResult();
    }
}
