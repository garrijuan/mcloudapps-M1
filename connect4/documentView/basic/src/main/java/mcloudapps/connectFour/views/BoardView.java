package mcloudapps.connectFour.views;

import mcloudapps.connectFour.models.Game;
import mcloudapps.utils.models.Coordinate;

public class BoardView {

    public void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int row = game.getNumberOfRows(); row >=1 ; row--) {
            Message.VERTICAL_LINE.write();
            for (int col = 1; col <= game.getNumberOfColumns(); col++) {
                Coordinate coordinate = new Coordinate(row, col);
                if (game.isEmpty(coordinate)) {
                    Message.EMPTY.write();
                } else {
                    Message.COLOR.writeColor(game.getColor(coordinate).toString());
                }
                Message.VERTICAL_LINE.write();
            }
            Message.NEW_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
    
}
