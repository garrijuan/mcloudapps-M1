package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.Message;
import mcloudapps.connectFour.views.WithGameView;

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

