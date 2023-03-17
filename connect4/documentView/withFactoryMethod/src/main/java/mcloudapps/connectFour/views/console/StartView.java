package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.Message;
import mcloudapps.connectFour.views.WithGameView;

public class StartView extends WithGameView{
    
    public StartView(Game game) {
        super(game);
    }
    
    public void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }
}

