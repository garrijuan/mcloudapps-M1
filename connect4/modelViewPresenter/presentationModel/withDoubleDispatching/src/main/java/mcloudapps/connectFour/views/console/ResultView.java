package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.connectFour.views.Message;

public class ResultView{
   
    private PlayController playController;

    public ResultView(PlayController playController) {
        this.playController = playController;
    }
    
    public void interact() {
        if (playController.getResult() == null) {
            new MessageView().writeln(Message.RESULT_DRAW);
        } else {
            new MessageView().writeWinner(playController.getResult().toString());
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
    
}

