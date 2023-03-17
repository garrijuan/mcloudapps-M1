package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.models.Board;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.models.Coordinate;

public class BoardView extends mcloudapps.connectFour.views.BoardView {

    @Override
    public void write() {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int row = Board.getNumberOfRows(); row >=1 ; row--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int col = 1; col <= Board.getNumberOfColumns(); col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (this.isEmpty(coordinate)) {
                    new MessageView().write(Message.EMPTY);
                } else {
                    new MessageView().writeColor(this.getColor(coordinate));
                }
                new MessageView().write(Message.VERTICAL_LINE);
            }
            new MessageView().write(Message.NEW_LINE);
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
    
}
