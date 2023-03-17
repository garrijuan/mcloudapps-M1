package mcloudapps.connectFour.views;

import mcloudapps.connectFour.models.Game;

public class StartView extends WithGameView{
    
    public StartView(Game game) {
        super(game);
    }
    
    public void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }
}

