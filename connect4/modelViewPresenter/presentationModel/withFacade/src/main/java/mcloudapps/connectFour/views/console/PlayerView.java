package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.connectFour.views.ErrorView;
import mcloudapps.connectFour.views.Message;
import mcloudapps.connectFour.views.WithLogicView;
import mcloudapps.utils.views.BoundedIntDialog;

public class PlayerView extends WithLogicView {


    public PlayerView(Logic logic) {
        super(logic);
    }

    public void interact() {
        int column;
        Error error;
        Color color;
        do {
            color = this.logic.getActivePlayerColor();
            column = this.getColumn(Message.ENTER_COLUMN_TO_PUT, color);
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.logic.putToken(column);
    }

    private int getColumn(Message message, Color color) {
        assert message != null;
        BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, this.logic.getNumberOfColumns());
        return boundedIntDialog.read(message.toString().replaceAll("#player", "" + color));
    }

    private Error getPutTokenError(int column) {
        Error error = this.logic.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }

}
