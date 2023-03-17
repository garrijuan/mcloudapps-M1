package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;

public class PlayView{
    
    public void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().write(playController);
        } while (!playController.isGameOver());
        new ResultView(playController).interact();
        playController.nextState();
    }
    
}
    
