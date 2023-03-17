package mcloudapps.connectFour.controllers;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.ViewFactory;
import mcloudapps.connectFour.views.BoardView;
import mcloudapps.utils.models.Coordinate;

public class Controller {

    protected Game game;
    protected ViewFactory viewFactory;

    Controller(Game game, ViewFactory viewFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
    }

    public void writeBoard() {
        BoardView boardView = this.viewFactory.createBoardView();
        for (int i = 0; i < this.game.getNumberOfRows(); i++) {
            for (int j = 0; j < this.game.getNumberOfColumns(); j++) {
                boardView.set(new Coordinate(i, j), this.game.getColor(new Coordinate(i, j)));
            }
        }
        boardView.write();
    }
}
