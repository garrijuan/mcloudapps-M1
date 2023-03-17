package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.views.Message;
import mcloudapps.connectFour.views.WithLogicView;

public class StartView extends WithLogicView {
    
    StartView(Logic logic) {
        super(logic);
    }
    
    public void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.logic);
    }
}

