package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.StartController;
import mcloudapps.connectFour.views.Message;

public class StartView {
    
    public void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
        startController.nextState();
    }
}

