package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.types.Color;
import mcloudapps.utils.models.Coordinate;

public class StartController extends Controller{
    
    public StartController(Game game) {
        super(game);
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
