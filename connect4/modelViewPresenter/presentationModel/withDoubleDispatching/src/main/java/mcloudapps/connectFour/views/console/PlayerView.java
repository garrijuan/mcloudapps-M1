package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.PlayController;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.connectFour.views.ErrorView;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.views.BoundedIntDialog;

public class PlayerView {
    
    private PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }

    public void interact() {
        int column;
        Error error;
        Color color;
        do {
            color = this.playController.getActivePlayerColor();
            column = this.getColumn(Message.ENTER_COLUMN_TO_PUT, color);
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.playController.putToken(column);
    }

    private int getColumn(Message message, Color color) {
        assert message != null;
        BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, playController.getNumberOfColumns());
        return boundedIntDialog.read(message.toString().replaceAll("#player", "" + color));
    }

    private Error getPutTokenError(int column) {
        Error error = this.playController.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }

}
