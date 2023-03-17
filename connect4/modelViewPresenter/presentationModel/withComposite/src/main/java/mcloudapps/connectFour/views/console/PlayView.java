package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;

public class PlayView{
    
    public void interact(PlayController playController) {
        do {
            new PlayMenu(playController).execute();
        } while (!playController.isGameOver());
        new ResultView(playController).interact();
        playController.nextState();
    }
    
}
    
