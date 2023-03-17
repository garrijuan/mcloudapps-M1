package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;

public class PlayView{
    
    private PlayController playController;

    public PlayView(PlayController playController) {
        this.playController = playController;
    }
    
    public void interact() {
        do {
            new PlayerView(this.playController).interact();
            this.playController.next();
            new BoardView().write(this.playController);
        } while (!this.playController.isGameOver());
        new ResultView(this.playController).interact();
    }
    
}
    
