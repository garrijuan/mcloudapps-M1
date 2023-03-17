package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Logic;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.models.Coordinate;

public class BoardView {

    public void write(Logic logic) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int row = logic.getNumberOfRows(); row >=1 ; row--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int col = 1; col <= logic.getNumberOfColumns(); col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (logic.isEmpty(coordinate)) {
                    new MessageView().write(Message.EMPTY);
                } else {
                    new MessageView().writeColor(logic.getColor(coordinate).toString());
                }
                new MessageView().write(Message.VERTICAL_LINE);
            }
            new MessageView().write(Message.NEW_LINE);
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
    
}
