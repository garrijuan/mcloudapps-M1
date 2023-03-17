package mcloudapps.connectFour.views.console;

import mcloudapps.connectFour.controllers.Controller;
import mcloudapps.connectFour.views.Message;
import mcloudapps.utils.models.Coordinate;

public class BoardView {

    public void write(Controller controller) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int row = controller.getNumberOfRows(); row >=1 ; row--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int col = 1; col <= controller.getNumberOfColumns(); col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (controller.isEmpty(coordinate)) {
                    new MessageView().write(Message.EMPTY);
                } else {
                    new MessageView().writeColor(controller.getColor(coordinate).toString());
                }
                new MessageView().write(Message.VERTICAL_LINE);
            }
            new MessageView().write(Message.NEW_LINE);
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
    
}
