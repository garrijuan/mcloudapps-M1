package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.utils.models.Coordinate;

public class Logic {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic(Game game) {
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public Color getColor(Coordinate coordinate) {
        return this.startController.getColor(coordinate);
    }

    public int getNumberOfRows() {
        return this.startController.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return this.startController.getNumberOfColumns();
    }

    public boolean isEmpty(Coordinate coordinate){
        return this.playController.isEmpty(coordinate);
    }

    public Color getActivePlayerColor(){
        return this.playController.getActivePlayerColor();
    }

    public void putToken(int column) {
        this.playController.putToken(column);
    }

    public Error getPutTokenError(int column) {
        return this.playController.getPutTokenError(column);
    }

    public void next() {
        this.playController.next();
    }

    public boolean isGameOver() {
        return this.playController.isGameOver();
    }

    public Color getResult() {
        return this.playController.getResult();
    }

    public void reset() {
        this.resumeController.reset();
    }

}
