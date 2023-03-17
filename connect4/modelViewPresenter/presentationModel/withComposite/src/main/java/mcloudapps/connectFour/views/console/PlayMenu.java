package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.utils.views.Menu;

public class PlayMenu extends Menu {
    PlayMenu(PlayController playController) {
        this.addCommand(new ActionCommand(playController));
        this.addCommand(new UndoCommand(playController));
        this.addCommand(new RedoCommand(playController));
    }
}
