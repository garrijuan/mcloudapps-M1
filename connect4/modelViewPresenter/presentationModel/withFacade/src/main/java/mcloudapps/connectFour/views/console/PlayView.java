package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.views.WithLogicView;

public class PlayView extends WithLogicView {
    
    public PlayView(Logic logic) {
        super(logic);
    }
    
    public void interact() {
        do {
            new PlayerView(this.logic).interact();
            this.logic.next();
            new BoardView().write(this.logic);
        } while (!this.logic.isGameOver());
        new ResultView(this.logic).interact();
    }
    
}
    
