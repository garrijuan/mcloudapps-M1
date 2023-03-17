package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.models.Game;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.connectFour.views.ErrorView;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.views.BoundedIntDialog;

public class PlayerView {
    
    private Game game;

    public PlayerView(Game game) {
        this.game = game;
    }

    public void interact() {
        int column;
        Error error;
        Color color;
        do {
            color = this.game.getActivePlayerColor();
            column = this.getColumn(Message.ENTER_COLUMN_TO_PUT, color);
            error = this.getPutTokenError(column, color);
        } while (!error.isNull());
        this.game.putToken(column, color);
    }

    private int getColumn(Message message, Color color) {
        assert message != null;
        BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, game.getNumberOfColumns());
        return boundedIntDialog.read(message.toString().replaceAll("#player", "" + color));
    }

    private Error getPutTokenError(int column, Color color) {
        assert color != Color.NONE;
        Error error = this.game.getPutTokenError(column);
        new ErrorView().writeln(error);
        return error;
    }

}
