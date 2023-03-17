package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.ViewFactory;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class PlayController extends Controller {

    public PlayController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }
    
    public void control() {
        do {
            this.putToken();
            this.next();
            this.writeBoard();
        } while (!this.isGameOver());
        if (this.getResult() == null) {
            this.viewFactory.createResultView().writeDraw();
        } else {
            this.viewFactory.createResultView().writeWinner(this.getResult());
        }
    }

    public void putToken() {
        int column;
        Error error;
        Color color;
        do {
            color = this.getActivePlayerColor();
            column = this.getColumn(color);
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.game.putToken(column, color);
    }

    private void next() {
        this.game.next();
    }

    private int getColumn(Color color) {
        return this.viewFactory.createPlayerView().readColumn(color);
    }

    private Color getActivePlayerColor(){
        return this.game.getActivePlayerColor();
    }

    private Error getPutTokenError(int column) {
        return this.game.getPutTokenError(column);
    }

    private boolean isGameOver() {
        return this.game.isGameOver();
    }

    private Color getResult() {
        return this.game.getResult();
    }
}
