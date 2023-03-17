package mcloudapps.connectFour.views;

import mcloudapps.connectFour.models.Game;

public class ResultView extends WithGameView{
    
    public ResultView(Game game) {
        super(game);
    }
    
    public void interact() {
        if (game.getResult() == null) {
            Message.RESULT_DRAW.writeln();
        } else {
            Message.RESULT_WIN.writeln(game.getResult().toString());
        }
        Message.HORIZONTAL_LINE.writeln();
    }
    
}

