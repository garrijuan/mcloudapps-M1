package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.StartController;
import mcloudapps.connectFour.views.Message;

public class StartView {
    
    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }
    
    public void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.startController);
    }
}

