package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.views.WithGameView;

public class PlayView extends WithGameView{
    
    public PlayView(Game game) {
        super(game);
    }
    
    public void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isGameOver());
        new ResultView(this.game).interact();
    }
    
}
    
