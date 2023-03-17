package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.models.Board;
import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.views.BoundedIntDialog;

public class PlayerView implements mcloudapps.connectFour.views.PlayerView {
    
    @Override
    public int readColumn(Color color){
        BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, Board.getNumberOfColumns());
        return boundedIntDialog.read(Message.ENTER_COLUMN_TO_PUT.toString().replaceAll("#player", "" + color));
    }

}
